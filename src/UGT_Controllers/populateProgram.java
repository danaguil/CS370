package UGT_Controllers;

import UGT_Data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
    private static final String topsFileName = "topsItems.txt";
    private static final String bottomsFileName = "bottomsItems.txt";
    private static final String shoesFileName = "shoesItems.txt";
    private static final String followersFileName = "followers.txt";

    public static final File userFile = new File(directoryPath + usersFileName);
    public static final File brandFile = new File(directoryPath + brandsFileName);
    public static final File customerFile = new File(directoryPath + customersFileName);
    public static final File topsFile = new File(directoryPath + topsFileName);
    public static final File bottomsFile = new File(directoryPath + bottomsFileName);
    public static final File shoesFile = new File(directoryPath + shoesFileName);
    public static final File followersFile = new File(directoryPath + followersFileName);

    public static final HashMap<String, User> userMap = new HashMap<>(); // User hash map
    public static final HashMap<String, Brand> brandMap = new HashMap<>(); // Brand hash map, key = brand name, value = brand class object
    public static final HashMap<String, Customer> customerMap = new HashMap<>(); // Customer hash map
    public static final HashMap<String, Item> itemMap = new HashMap<>(); // key = id; value = item object
    public static final HashMap<String, Tops> topsItemMap = new HashMap<>(); // key = item id; value = top object
    public static final HashMap<String, Bottoms> bottomsItemMap = new HashMap<>(); // key = item id; value = bottom object
    public static final HashMap<String, Shoes> shoesMap = new HashMap<>(); // key = item id; value = shoes object

    /**
     * Populates the user hashmap with the information from the userInfoFile.txt file.
     * @throws FileNotFoundException If the userInfoFile.txt file cannot be found.
     */
    public static void populateMap() throws FileNotFoundException {
        verifyFileExist(userFile, "user");
        verifyFileExist(topsFile, "tops");
        verifyFileExist(bottomsFile, "bottoms");
        verifyFileExist(shoesFile, "shoes");
        verifyFileExist(brandFile, "brand");
        verifyFileExist(customerFile, "buyer");
        verifyFileExist(followersFile, "follower");
        populateItemsMap();
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
                case "tops" -> populateTopsMap(parts);
                case "bottoms" -> populateBottomsMap(parts);
                case "shoes" -> populateShoesMap(parts);
                case "follower" -> populateFollowersMap(parts);
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
                            aboutBrand, logoFileLocation, instagram, tiktok, id);
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
    public static void populateItemsMap() {
        // Populate the item map with tops
        for (Item item : topsItemMap.values()) {
            itemMap.put(item.getItemId(), item);
        }
        // Populate the item map with bottoms
        for (Item item : bottomsItemMap.values()) {
            itemMap.put(item.getItemId(), item);
        }
        // Populate the item map with shoes
        for(Item item: shoesMap.values()){
            itemMap.put(item.getItemId(), item);
        }
    }

    public static void populateTopsMap(String[] parts){
        String name = parts[0];
        String size = parts[1].trim();
        String topType = parts[2];
        int chestSize = Integer.parseInt(parts[3].trim());
        int hemSize = Integer.parseInt(parts[4].trim());
        int sleeveLength = Integer.parseInt(parts[5].trim());
        double price = Double.parseDouble(parts[6].trim());
        String color = parts[7];
        String description = parts[8];
        String imagePath = parts[9].trim();
        String itemId = parts[10].trim();
        String brandId = parts[11].trim();

        Tops tops = new Tops(name, size, topType, chestSize, hemSize, sleeveLength, price, color, description, imagePath, itemId, brandId);
        topsItemMap.put(itemId, tops);


        // Add Item to Brand Account
        Brand brand = brandMap.get(getBrandUsernameById(brandId));
        brand.addItem(tops);
    }

    public static void populateBottomsMap(String[] parts){
        String name = parts[0];
        String size = parts[1].trim();
        String bottomsType = parts[2];
        int waistSize = Integer.parseInt(parts[3].trim());
        int inseam = Integer.parseInt(parts[4].trim());
        int rise = Integer.parseInt(parts[5].trim());
        int length = Integer.parseInt(parts[6].trim());
        double price = Double.parseDouble(parts[7].trim());
        String color = parts[8];
        String description = parts[9];
        String imagePath = parts[10].trim();
        String itemId = parts[11].trim();
        String brandId = parts[12].trim();

        Bottoms bottoms = new Bottoms(name, size, bottomsType, waistSize, inseam, rise, length, price, color, description, imagePath, itemId, brandId);
        bottomsItemMap.put(itemId, bottoms);

        // Add Bottoms to Brand Item Arraylist
        Brand brand = brandMap.get(getBrandUsernameById(brandId));
        brand.addItem(bottoms);
    }

    public static void populateShoesMap(String[] parts){
        String name = parts[0];
        String size = parts[1].trim();
        String shoeType = parts[2];
        double price = Double.parseDouble(parts[3].trim());
        String color = parts[4];
        String description = parts[5];
        String imagePath = parts[6].trim();
        String itemId = parts[7].trim();
        String brandId = parts[8].trim();

        Shoes shoes = new Shoes(name, size, shoeType, price, color, description, imagePath, itemId, brandId);
        shoesMap.put(itemId, shoes);

        // Add Shoes to Brand Item ArrayList
        Brand brand = brandMap.get(getBrandUsernameById(brandId));
        brand.addItem(shoes);
    }

    public static void populateFollowersMap(String[] parts) {
        String brandId = parts[0];

        for(int i = 1; i < parts.length; i++){
            Customer customer = customerMap.getOrDefault(parts[i], null);
            if(customer != null){
                customer.addToFollowedBrand(brandId);
            }
        }
    }

    public static void addToItemMap(String key, Item item) {
        itemMap.put(key, item);
        System.out.print("Item added to the Item Map");
    }

}


