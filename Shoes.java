package rs.milnik;

public class Shoes extends Product {

	private int size;

	public Shoes(String name, String brand, String color, double price, int size) {
		super(name, brand, color, price);
		this.size = size;
	}

	@Override
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
