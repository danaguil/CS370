package UGT_Controllers;

import UGT_Data.Customer;
import UGT_Data.Item;
import UGT_Data.programSession;

public class UserInteractions {
    // Adding an item to the cart
    public static void addToCart(Item item) {
        System.out.println("Item information adding to cart: ");

        // Getting customer information currently logged in
        Customer customer = programSession.getLoggedInCustomer();

        customer.addToCart(item);
        System.out.println("Customer cart: ");
        System.out.println(customer.getCart());

        System.out.println("Item added to cart!");
    }

    public static void removeFromCart(Item item) {
        System.out.println("Item information removing from cart: ");
        Customer customer = programSession.getLoggedInCustomer();
        customer.removeFromCart(item);
        System.out.println("Customer cart: ");
        System.out.println(customer.getCart());
        System.out.println("Item removed from cart!");
    }


}
