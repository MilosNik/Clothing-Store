package rs.milnik;

enum Size {
	XS, S, M, L, XL, XXL;
}

public class Shirt extends Product {

	private Size size;

	public Shirt(String name, String brand, String color, double price, Size size) {
		super(name, brand, color, price);
		this.size = size;

	}
	@Override
	public Size getShirtSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}
