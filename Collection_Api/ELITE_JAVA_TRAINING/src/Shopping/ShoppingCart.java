package Shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                item.increaseQuantity(quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public void removeProduct(String productName) {
        items.removeIf(item ->
                item.getProduct().getName().equals(productName));
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (CartItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");

        for (CartItem item : items) {
            System.out.println(
                item.getProduct().getName()
                + " x " + item.getQuantity()
                + " = $" + item.getSubtotal()
            );
        }

        System.out.println("Total: $" + getTotalPrice());
    }
}