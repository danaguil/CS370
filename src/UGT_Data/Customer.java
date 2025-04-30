package UGT_Data;

import java.util.ArrayList;

/*
    The `Customer` class extends the `User` class, inheriting user details like `email`, `username`, and `password`.
    It adds customer-specific attributes such as `name`, `address`, `payment details`, and activity lists
    (`likedPosts`, `followedBrand`, `orders`, and `cart`). It also includes methods to manage orders and the
    shopping cart.
 */

public class Customer extends User{

    // Name of customer
    private String first_name;
    private String last_name;

    // Customers address information
    private String address;

    // List of CRUD attributes
    private final ArrayList<String> likedPosts;
    private final ArrayList<String> followedBrand ;
    private final ArrayList<Order> ordersList;
    private final ArrayList<Item> customerCart;

    // Constructor for Customer class
    public Customer(String email, String username, String password, String first_name, String last_name, String address,
                    String id) {
        super(email, username, password, id);

        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;

        this.likedPosts = new ArrayList<>();
        this.followedBrand = new ArrayList<>();
        this.ordersList = new ArrayList<>();
        this.customerCart = new ArrayList<>();
    }

    // All the getters
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order)
    {
        ordersList.add(order);
    }

    public void addToCart(Item item){
        customerCart.add(item);
    }

    public ArrayList<String> getLikedPosts() {
        return likedPosts;
    }

    public ArrayList<String> getFollowedBrand() {
        return followedBrand;
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // calls User's displayInfo()
        System.out.println("First Name: " + first_name);
        System.out.println("Last Name: " + last_name);
        System.out.println("Address: " + address);
        System.out.println("Liked Posts: " + likedPosts);
        System.out.println("Followed Brands: " + followedBrand);
        System.out.println("Orders List: " + ordersList);
        System.out.println("Customer Cart: " + customerCart);
        System.out.println("ID: " + getId());
        System.out.println("---------------------------");
    }

}
