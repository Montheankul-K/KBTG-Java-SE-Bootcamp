package product;

public class ProductRepository {
	public Product getProduct(int id) {
		return new Product(1, "iPhone", 3, 40000);
	}
}
