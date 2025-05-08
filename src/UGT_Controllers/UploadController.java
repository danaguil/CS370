package UGT_Controllers;
import UGT_Data.*;
import UGT_UI.*;

// imported the hashmaps with the classes
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static UGT_Controllers.populateProgram.brandFile;
import static UGT_Controllers.populateProgram.itemMap;
import static UGT_UI.Buyer_Pages.getDiscoverPage;
import static UGT_UI.UploadPage.*;

/**
 * Controller for the upload page, going to be used to upload items to the database.
 */
public class UploadController {

    /**
     * Uploads an item to the database.
     * @throws IOException If an error occurs while writing to the item file.
     */
//    public static void uploadItem() throws IOException {
//        Brand currentBrand = programSession.getLoggedInBrand();
//
//        if (currentBrand == null) {
//            System.out.println("Please log in as a brand to upload an item.");
//        } else {
//            System.out.println("Uploading item for BRAND:");
//            System.out.println("Brand Name: " + currentBrand.getBrand_name());
//        }
//
//
//
//        // Basic components of an item
//
//        String itemType = getItemTypes();
//        String itemName = UploadPage.getItemName();
//        String size = getSelected(size_combo);
//        String color = getSelected(color_combo);
//        double price = Double.parseDouble(UploadPage.getPrice());
//        String imagePath = UploadPage.getPost_photo();
//        String description = UploadPage.getDescription();
//
//        String itemID = IDGenerator.generateID();
//        String brandId = currentBrand.getId();
//
//        String sleeveLength = "";
//        String shoeType = "";
//
//        int waistSize = 0;
//        Item item = null;
//
//        switch (itemType) {
//            case "Tops" -> {
//                System.out.println("Going to make class");
//                sleeveLength = getSelected(sleeve_length_combo);
//                item = new Tops(itemName, size, sleeveLength, price, color, description,
//                        imagePath, itemID, brandId);
//            }
//            case "Bottoms" -> {
//                waistSize = Integer.parseInt(getSelected(waist_size_combo));item = new Bottoms(itemName, size, waistSize, price, color, description,
//                      imagePath, itemID, brandId);
//            }
//            case "Shoes" -> {
//                shoeType = getSelected(shoes_type_combo);
//                item = new Shoes(itemName, size, shoeType, price, color, description,
//                        imagePath, itemID, brandId);
//            }
//        }
//        System.out.println(sleeveLength);
//        itemMap.put(itemID,item);
//        currentBrand.addItem(item); // add to brand class
//
//        System.out.println("Uploaded item: " + itemName);
//        System.out.println("Item ID: " + itemID);
//        System.out.println("↳ Uploaded by brand ID: " + brandId);
//
//        writeItemtoTextFile(itemName, size, color, price,
//                imagePath, description, itemID, brandId,
//                sleeveLength, waistSize, shoeType, itemType);
//    }

    public void uploadTop(String itemName, String topType, String color, String size, String chestSize,
                                 String hemSize, String sleeveLength, String price, String description, String imagePath) throws IOException {
        // Parse the price to a double
        double priceDouble = Double.parseDouble(price);
        int chestSizeInt = Integer.parseInt(chestSize);
        int hemSizeInt = Integer.parseInt(hemSize);
        int sleeveLengthInt = Integer.parseInt(sleeveLength);
        Brand currentBrand = programSession.getLoggedInBrand();
        String itemID = IDGenerator.generateID();
        Tops top = new Tops(itemName, size, topType, chestSizeInt, hemSizeInt, sleeveLengthInt, priceDouble, color, description, imagePath, itemID, currentBrand.getId());

        populateProgram.addToItemMap(itemID, top);
        populateProgram.topsItemMap.put(itemID, top);
        writeTopToTextFile(itemName, size, topType, chestSize, hemSize, sleeveLength, priceDouble, color, description, imagePath, itemID, currentBrand.getId());
        currentBrand.addItem(top);

        getDiscoverPage().refreshDiscoverPage();

    }

    public void uploadBottom(String itemName, String bottomType, String color, String size, String waistSize,
                                    String length, String inseam, String rise, String price, String description,
                                    String imagePath) throws IOException {

        // Parse the price to a double
        double priceDouble = Double.parseDouble(price);
        int waistSizeInt = Integer.parseInt(waistSize);
        int lengthInt = Integer.parseInt(length);
        int inseamInt = Integer.parseInt(inseam);
        int riseInt = Integer.parseInt(rise);
        Brand currentBrand = programSession.getLoggedInBrand();
        String itemID = IDGenerator.generateID();
        Bottoms bottom = new Bottoms(itemName, size, bottomType, waistSizeInt, inseamInt, riseInt, lengthInt, priceDouble, description, color, imagePath, itemID, currentBrand.getId());

        populateProgram.addToItemMap(itemID, bottom);
        populateProgram.bottomsItemMap.put(itemID, bottom);
        writeBottomToTextFile(itemName, size, bottomType, waistSizeInt, inseamInt, riseInt,lengthInt, priceDouble, color, description, imagePath,
                itemID, currentBrand.getId());
        currentBrand.addItem(bottom);

        getDiscoverPage().refreshDiscoverPage();

    }

    public void uploadShoe(String itemName, String shoeType, String size, String price, String color, String description, String imagePath) throws IOException {

        // Parse the price to a double
        double priceDouble = Double.parseDouble(price);
        Brand currentBrand = programSession.getLoggedInBrand();
        String itemID = IDGenerator.generateID();
        Shoes shoe = new Shoes(itemName, size, shoeType, priceDouble, color, description, imagePath, itemID, currentBrand.getId());

        populateProgram.addToItemMap(itemID, shoe);
        populateProgram.shoesMap.put(itemID, shoe);
        writeShoesToTextFile(itemName, size, shoeType, priceDouble, color, description, imagePath, itemID, currentBrand.getId());
        currentBrand.addItem(shoe);

        getDiscoverPage().refreshDiscoverPage();

    }


    public static void writeTopToTextFile(String itemName, String size, String topType, String chest_size, String hemSize,
                                          String sleeveLength, double price, String color, String description, String imagePath,
                                          String itemId, String brandId) throws IOException{

        FileWriter fw = new FileWriter(populateProgram.topsFile, true);
        PrintWriter out = new PrintWriter(fw);

        out.println(itemName + "," + size + "," + topType + "," + chest_size + "," + hemSize + "," + sleeveLength + ","
                + price + "," + color + "," + description + "," + imagePath + "," + itemId + "," + brandId);

        out.close();

    }

    public static void writeBottomToTextFile(String itemName, String size, String bottomType, int waistSize,
                                             int inseam, int rise, int length, double price, String color, String description, String imagePath,
                                             String itemID, String brandID) throws IOException {

        FileWriter fw = new FileWriter(populateProgram.bottomsFile, true);
        PrintWriter out = new PrintWriter(fw);

        out.println(itemName + "," + size + "," + bottomType + "," + waistSize + "," + inseam + ","
                + rise + "," + length + "," + price + "," + color + "," + description + "," + imagePath + "," +
                itemID + "," + brandID);

        out.close();
    }

    public static void writeShoesToTextFile(String itemName, String size, String shoeType, double price, String color, String description, String imagePath, String itemID, String brandID) throws IOException {

        FileWriter fw = new FileWriter(populateProgram.shoesFile, true);
        PrintWriter out = new PrintWriter(fw);

        out.println(itemName + "," + size + "," + shoeType + "," + price + "," + color + "," + description
                + "," + imagePath + "," + itemID + "," + brandID);

        out.close();
    }

    public boolean verifyPrice(String price){
        boolean result = true;
        try{
            Double.parseDouble(price);
        } catch (NumberFormatException e) {
            System.out.println("Price must be a number.");
            result = false;
        }
        return result;
    }

    public boolean verifyDescription(String description){
        boolean result = true;
        if(description.length() > 100){
            result = false;
            System.out.println("Description must be less than 100 characters.");
        }
        return result;
    }

    public boolean verifyName(String itemName){
        boolean result = true;
        if(itemName.length() > 30){
            result = false;
            System.out.println("Name must be less than 30 characters.");
        }
        return result;
    }





}
