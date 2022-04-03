package rs.milnik;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ListIterator;

public class Cashier {

	public static void main(String[] args) {

		Product shirt = new Shirt("Cotton Shirt", "BrandA", "Blue", 20.00, Size.XXL);

		Product sneakers = new Shoes("Basketball Sneakers", "BrandB", "White", 110.00, 46);

		Product jacket = new Jacket("Texas Jacket", "BrandC", "Black", 80.00, 52);

		Cart cart1 = new Cart();

		cart1.addToCart(jacket);
		cart1.addToCart(sneakers);
		cart1.addToCart(shirt);

		printReceipt(cart1);

	}

//	I intentionally used LocalDate.now() and LocalTime.now(),
//	instead of passing the date and time as an argument, to add more realistic feeling to method;
//	For testing purpose, LocalDate.now().getDayOfWeek().getValue() == 2 can be changed to some other number,
//	representing the day of the week;
	public static void printReceipt(Cart cart) {

		boolean isTuesday = false;
		boolean quantityDiscount = false;

		int itemDiscountPercent;
		double itemDiscount;

		double totalPrice = 0;
		double totalDiscount = 0;

		if (LocalDate.now().getDayOfWeek().getValue() == 2) {
			isTuesday = true;
		}

		if (cart.getProductList().size() > 2) {
			quantityDiscount = true;
		}

		System.out.println("Date: " + LocalDate.now() + "      " + LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
		System.out.println();
		System.out.println("---  Products  ---");
		System.out.println();
		System.out.println();

		ListIterator<Product> iterator = cart.getProductList().listIterator();

		while (iterator.hasNext()) {
			Product product = iterator.next();
			System.out.println(product.getColor() + " " + product.getName() + " - " + product.getBrand());
			System.out.println("$" + String.format("%.2f",product.getPrice()));
			System.out.println();

			if (isTuesday && (product instanceof Shoes) && !quantityDiscount) {
				itemDiscountPercent = 10;
				itemDiscount = product.getPrice() * 0.1;
			} else if (!(product instanceof Shirt) && quantityDiscount) {
				itemDiscountPercent = 20;
				itemDiscount = product.getPrice() * 0.2;
			}
		      else if (!isTuesday && quantityDiscount) {
				itemDiscountPercent = 20;
				itemDiscount = product.getPrice() * 0.2;
			}
			
			
			else if (isTuesday && (product instanceof Shirt)) {
				itemDiscountPercent = 25;
				itemDiscount = product.getPrice() * 0.25;
			} else {
				itemDiscountPercent = 0;
				itemDiscount = 0;
			}

			System.out.println("#discount " + itemDiscountPercent + "% -$" + String.format("%.2f",itemDiscount));
			System.out.println();
			System.out.println();
			System.out.println();


			totalPrice += product.getPrice();
			totalDiscount += itemDiscount;
		}

		System.out.println("---------------------------------------------");
		System.out.println("SUBTOTAL: $" + String.format("%.2f",totalPrice));
		System.out.println("DISCOUNT: -$" + String.format("%.2f",totalDiscount));
		System.out.println();
		System.out.println("TOTAL: $" + String.format("%.2f",(totalPrice - totalDiscount)));

	}

}
