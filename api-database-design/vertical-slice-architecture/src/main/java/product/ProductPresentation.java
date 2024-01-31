package product;

import product.Product;

public class ProductPresentation {
	public void present() {
		Product product = new Product(1, "iPhone", 3, 40000);
		System.out.println("Product: " + product.getName());
	}
}
