package rs.milnik;

public class Product {

	private String name;
	private String brand;
	private String color;
	private double price;
	

	public Product(String name, String brand, String color, double price) {
		super();
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Size getShirtSize() {
		return getShirtSize();
	}
	
	public int getSize() {
		return getSize();
	}

}
