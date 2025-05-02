import UGT_Controllers.IDGenerator;
import UGT_Controllers.LoginController;
import UGT_Data.Brand;
import UGT_Data.Customer;
import UGT_Data.Item;
import UGT_UI.*;
import javax.swing.*;
import UGT_Controllers.LoginController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main extends JFrame {
    public static void main(String[] args) throws FileNotFoundException{




        Buyer_Pages buyer_pages = new Buyer_Pages();
        //Brand_Pages brand_pages = new Brand_Pages();


        /*
        try {
            LoginController.populateHashMap();
            new Login();

        } catch (FileNotFoundException e) {
            System.out.println("Error: userInfoFile.txt not found!");
            throw new FileNotFoundException();
        }
        */


        /*
        // Create brand
        Brand brand = new Brand(
                "brand@email.com", "branduser", "password123",
                "HypeWear", "High-end streetwear", new File("logo.png"),
                "@hypewear", "@hype.tt", IDGenerator.generateID()
        );

        // Create item (itemId generated in constructor)
        Item item = new Item(
                brand.getId(), "Red Hoodie", 29.99, 10, "Cozy red hoodie",
                "Cotton", "Polyester", "", "Red",
                "Warm", "Winter", "Trendy"// brandId stored inside Item
        );
        //brand.addItem(item); // Add item to brand
        System.out.println("Brand posted item: " + item.getName());

        // Create customer
        Customer customer = new Customer(
                "buyer@email.com", "coolbuyer", "securepass",
                "Alex", "Rivera", "123 Main St",
                IDGenerator.generateID()
        );

        // Customer likes the item
        customer.getLikedPosts().add(item.getItemId());
        System.out.println("Customer liked item: " + item.getName());

        // Now display to verify
        System.out.println("\n--- BRAND INFO ---");
        brand.displayInfo();

        System.out.println("\n--- CUSTOMER INFO ---");
        customer.displayInfo();

        // Optional: simulate item lookup from ID
        HashMap<String, Item> itemMap = new HashMap<>();
        itemMap.put(item.getItemId(), item);

        System.out.println("\nCustomer's liked item details:");
        for (String likedId : customer.getLikedPosts()) {
            Item likedItem = itemMap.get(likedId);
            if (likedItem != null) {
                System.out.println("Liked: " + likedItem.getName() + " - $" + likedItem.getPrice());
            }
        }

         */
/*
        LoginController.initialize();
        new Login();
*/



    }
}
