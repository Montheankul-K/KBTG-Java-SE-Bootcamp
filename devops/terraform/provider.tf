terraform {
  # setup provider
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.29.0"
    }
  }
}

# config provider region
provider "aws" {
  region = "ap-southeast-1"
}
