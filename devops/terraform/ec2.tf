# get availability zones
resource "tls_private_key" "key" {
  # algorithm to generate key pair
  algorithm = "RSA"
  rsa_bits  = 4096
}

# generate a private key (key pair) and encode it as PEM
resource "aws_key_pair" "key_pair" {
  key_name   = "key"
  public_key = tls_private_key.key.public_key_openssh

  provisioner "local-exec" {
    # echo private key to key.pem (binding from instance)
    command = "echo '${tls_private_key.key.private_key_pem}' > ./key.pem"
  }
}

# create nginx
resource "aws_instance" "node" {
  instance_type = "t2.micro"
  ami           = "ami-02ee763250491e04a"
  # binding key pair to use with instance
  key_name               = aws_key_pair.key_pair.id
  vpc_security_group_ids = [aws_security_group.secgroup.id]
  # binding subnet
  # get subnet from vpc service in aws console
  subnet_id                   = "subnet-06866d88d98e3ea42"
  associate_public_ip_address = "true"

  root_block_device {
    volume_size = 10
  }

  connection {
    type        = "ssh"
    host        = self.public_ip
    user        = "ubuntu"
    private_key = tls_private_key.key.private_key_pem
  }
  # run command after provision nginx instance
  provisioner "remote-exec" {
    inline = [
      "sudo apt update -y",
      "sudo apt install nginx -y",
      "sudo service nginx start"
    ]
  }
}
