# internat gateway 
# prevent connection from internet
resource "aws_internet_gateway" "igw" {
  vpc_id = aws_vpc.devops-training.id

  tags = {
    Cluster = "training"
  }
}
