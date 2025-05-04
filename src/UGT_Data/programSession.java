package UGT_Data;


/**
 * Session class that tracks both the currently logged-in brand and the currently logged-in buyer (customer)
 */
public class programSession {
    // Currently logged in Brand user
    public static Brand loggedInBrand = null;

    // Currently logged in Customer user
    public static Customer loggedInCustomer = null;

    // Setters
    public static void setLoggedInBrand(Brand brand) {
        loggedInBrand = brand;
    }

    public static void setLoggedInCustomer(Customer customer) {
        loggedInCustomer = customer;
    }

    // Getters
    public static Brand getLoggedInBrand() {
        return loggedInBrand;
    }

    public static Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    // Logout
    public static void logout() {
        loggedInBrand = null;
        loggedInCustomer = null;
    }
}
