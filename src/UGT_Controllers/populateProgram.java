package UGT_Controllers;

import UGT_Data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import static UGT_Data.Brand.getBrandUsernameById;

public class populateProgram {
    // Getting the correct file location
    // Create class for hashmap, file information
    private static final String directoryPath = "src/UGT_Data/accountInformation/";
    private static final String usersFileName = "userInfoFile.txt";
    private static final String brandsFileName = "brands.txt";
    private static final String customersFileName = "buyers.txt";
    private static final String itemsFileName = "items.txt";

    public static final File userFile = new File(directoryPath + usersFileName);
    public static final File brandFile = new File(directoryPath + brandsFileName);
    public static final File customerFile = new File(directoryPath + customersFileName);
    public static final File itemsFile = new File(directoryPath + itemsFileName);

    public static final HashMap<String, User> userMap = new HashMap<>(); // User hash map
    public static final HashMap<String, Brand> brandMap = new HashMap<>(); // Brand hash map, key = brand name, value = brand class object
    public static final HashMap<String, Customer> customerMap = new HashMap<>(); // Customer hash map

    /**
     * Populates the user hashmap with the information from the userInfoFile.txt file.
     * @throws FileNotFoundException If the userInfoFile.txt file cannot be found.
     */
    public static void populateMap() throws FileNotFoundException {
        verifyFileExist(userFile, "user");
        verifyFileExist(itemsFile, "item");
    }

    /**
     * Function can be reused
     * @param theFile The file to be verified. Must be a valid file.
     */
    public static void verifyFileExist(File theFile, String fileType) throws FileNotFoundException {
        if (!theFile.exists()) {
            System.out.println(theFile + " not found. Creating empty file...");
            try {
                PrintWriter writer = new PrintWriter(theFile);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
        readFileLines(theFile, fileType);
    }

    public static void readFileLines(File theFile, String fileType) throws FileNotFoundException {
        Scanner inFile = new Scanner(theFile);

        while (inFile.hasNextLine()) {
            // Trims the line
            String line = inFile.nextLine().trim();
            if (line.isEmpty()) continue; // Cont if line is empty

            // Splits line into 3 sections: username, email and password
            String[] parts = line.split(",");

            switch (fileType.toLowerCase()) {
                case "user" -> populateUserMap(parts);
                case "item" -> populateItemsMap(parts);
                default -> System.out.println("Unknown file type: " + fileType);
            }
        }
        inFile.close();
    }
    public static void populateUserMap(String[] parts){
        String username = parts[0].trim();
        String id = parts[3].trim();
        String type = parts[4].trim().toLowerCase(); // brand or buyer

        if (type.equals("brand")) {
            Brand brand = populateBrandFromFile(id);
            if (brand != null) {
                userMap.put(username, brand);
                brandMap.put(brand.getBrand_name().toLowerCase(), brand);
            }
        } else if (type.equals("buyer")) {
            Customer customer = populateCustomerFromFile(id);
            if (customer != null) {
                userMap.put(username, customer);
                customerMap.put(username, customer);
            }
        } else {
            System.out.println("Unknown user type: " + type);
        }
    }



    public static Brand populateBrandFromFile(String idToFind) {
        try (Scanner scanner = new Scanner(brandFile)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",", -1);
                if (parts.length < 9) continue;

                String username = parts[0].trim();
                String email = parts[1].trim();
                String password = parts[2].trim();
                String brandName = parts[3].trim();
                String aboutBrand = parts[4].trim();
                String logoFileLocation = parts[5].trim();
                String instagram = parts[6];
                String tiktok = parts[7];
                String id = parts[8].trim();

                if (id.equals(idToFind)) {
                    return new Brand(email, username, password, brandName,
                            aboutBrand, new File(logoFileLocation), instagram, tiktok, id);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brand file not found: " + e.getMessage());
        }
        return null;
    }



    public static Customer populateCustomerFromFile(String idToFind) {
        try (Scanner scanner = new Scanner(customerFile)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",", -1);


                if (parts.length < 7) continue;

                String username = parts[0].trim();
                String email = parts[1].trim();
                String password = parts[2].trim();
                String firstName = parts[3];
                String lastName = parts[4];
                String address = parts[5];
                String id = parts[6].trim();


                if (id.equals(idToFind)) {
                    return new Customer(email, username, password, firstName, lastName, address, id);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found: " + e.getMessage());
        }
        return null;
    }
    // key = if; value = brandItems.txt
    public static final HashMap<String, Item> itemMap = new HashMap<>();

    public static void populateItemsMap(String[] parts) {
        String name = parts[0];
        String size = parts[1];
        String uniqueField = parts[2]; // sleeveLength OR waistSize OR shoeType
        double price = Double.parseDouble(parts[3]);
        String description = parts[4];
        String color = parts[5];
        String imagePath = parts[6];
        String itemId = parts[7];
        String itemType = parts[8];
        String brandId = parts[9];

        Item item = null;

        switch (itemType.toLowerCase()) {
            case "tops" -> {
                item = new Tops(name, size, uniqueField, price, color, description, imagePath, itemId, brandId);
            }
            case "bottoms" -> {
                int waistSize = Integer.parseInt(uniqueField);
                item = new Bottoms(name, size, waistSize, price, color, description, imagePath, itemId, brandId);
            }
            case "shoes" -> {
                item = new Shoes(name, size, uniqueField, price, color, description, imagePath, itemId, brandId);
            }
        }

        itemMap.put(itemId, item);
        assert item != null;
        item.displayInfo();

        // Optionally: connect to brand
        Brand brand = brandMap.getOrDefault(getBrandUsernameById(brandId), null);
        if (brand != null) {
            brand.addItem(item);
        }
        assert brand != null;
        brand.displayInfo();
    }
}


