package UGT_Controllers;

import UGT_Data.Brand;
import UGT_Data.Customer;
import UGT_Data.Item;
import UGT_Data.programSession;
import UGT_UI.*;

public class UserInteractions {
    static Customer customer = programSession.getLoggedInCustomer();
    static Buyer_CartPage cartPage = Buyer_Pages.getCartPage();
    static Buyer_LikedPage likedPage = Buyer_Pages.getLikePage();
    static Buyer_HomePage homePage = Buyer_Pages.getHomePage();

    // Adding an item to the cart
    public static void addToCart(Item item) {
        System.out.println("Item information adding to cart: ");

        // Getting customer information currently logged in
        customer = programSession.getLoggedInCustomer();

        if(!customer.getCart().contains(item.getItemId())){
            customer.addToCart(item);
            cartPage.refreshCartPage();

        } else {
            System.out.println("Item already in cart");
            return;
        }

        System.out.println("Customer cart: ");
        System.out.println(customer.getCart());

        System.out.println("Item added to cart!");
    }

    public static void removeFromCart(Item item) {
        System.out.println("Item information removing from cart: ");

        customer = programSession.getLoggedInCustomer();

        if(!customer.getCart().isEmpty()){
            customer.removeFromCart(item);
        } else{
            System.out.println("Cart is empty");
            return;
        }


        System.out.println("Customer cart: ");
        System.out.println(customer.getCart());

        System.out.println("Item removed from cart!");
    }

    public static void likeDislikeFunction(Item item){
        customer = programSession.getLoggedInCustomer();

        // Dislike
        if(customer.getLikedPosts().contains(item.getItemId())){
            customer.removeFromLikedPosts(item.getItemId());
            System.out.println("Post removed from liked posts");
        } else {
            customer.addToLikedPosts(item.getItemId());
            System.out.println("Post added to liked posts");
        }

        likedPage.refreshLikePage();
        System.out.println("Customer liked posts: ");
        System.out.println(customer.getLikedPosts());
    }

    public static void followFunction(Item item){
        customer = programSession.getLoggedInCustomer();

        if(customer.getFollowedBrand().contains(item.getBrandId())){
            customer.removeFromFollowedBrand(item.getBrandId());
            System.out.println("Brand removed from followed brand");
        } else {
            customer.addToFollowedBrand(item.getBrandId());
            System.out.println("Brand added to followed brand");
        }

        homePage.refreshHomePage();
        System.out.println("Customer followed brand: ");
        System.out.println(customer.getFollowedBrand());
    }

    public static void purchaseItem(){
        System.out.println("Purchase item");
        Customer customer = programSession.getLoggedInCustomer();
        customer.getCart().clear();

        System.out.println("Customer cart: ");
        System.out.println(customer.getCart());
    }




}
