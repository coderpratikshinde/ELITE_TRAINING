package Shopping;

public class TestShopping {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 1200.00);
        Product mouse = new Product("Mouse", 25.00);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(laptop, 1);
        cart.addProduct(mouse, 2);

        cart.displayCart();

        cart.removeProduct("Mouse");

        System.out.println("\nAfter removing mouse:");
        cart.displayCart();
    }
}