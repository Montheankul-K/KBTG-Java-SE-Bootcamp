terraform {

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.29.0"
    }
  }
  cloud {
    # organization on terraform cloud
    organization = "devops-java-se-bootcamp"
    # config workspaces
    workspaces {
      name = "devops-infra"
    }
  }
}

provider "aws" {
  region     = "ap-southeast-1"
  access_key = var.aws_access_key
  secret_key = var.aws_secret_access_key
}
