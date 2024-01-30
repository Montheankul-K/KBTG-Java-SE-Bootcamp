package product;

public class Product {
	private int id;
	private String name;
	private int weight;
	private int price;

	public Product(int id, String name, int weight, int price) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getPrice() { return  price; }
}
