# create security groups
resource "aws_security_group" "secgroup" {
  name        = "global-allow-all"
  # get vpc_id from vpc service in aws console
  vpc_id      = "vpc-00b15d4fe37a77025"

ingress {
    from_port   = 0
    to_port     = 0
    protocol    = -1
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = -1
    cidr_blocks = ["0.0.0.0/0"]
  }
}