# get availability zones
resource "tls_private_key" "key" {
  algorithm = "RSA"
  rsa_bits  = 4096
}

# generate a private key (key pair) and encode it as PEM
resource "aws_key_pair" "key_pair" {
  key_name   = "key"
  public_key = tls_private_key.key.public_key_openssh

  provisioner "local-exec" {
    command = "echo '${tls_private_key.key.private_key_pem}' > ./key.pem"
  }
}

# create sonarqube server
resource "aws_instance" "node" {
  instance_type               = "t3a.medium"
  ami                         = "ami-07d23eb66d6346e0e"
  key_name                    = aws_key_pair.key_pair.id
  vpc_security_group_ids      = [aws_security_group.secgroup.id]
  subnet_id                   = aws_subnet.public-1a.id
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
}
