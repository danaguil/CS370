package UGT_Controllers;
import UGT_Data.*;
import UGT_UI.*;

// imported the hashmaps with the classes
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static UGT_Controllers.populateProgram.itemMap;
import static UGT_UI.UploadPage.*;

/**
 * Controller for the upload page, going to be used to upload items to the database.
 */
public class UploadController {

    /**
     * Uploads an item to the database.
     * @throws IOException If an error occurs while writing to the item file.
     */
    public static void uploadItem() throws IOException {
        Brand currentBrand = programSession.getLoggedInBrand();

        if (currentBrand == null) {
            System.out.println("Please log in as a brand to upload an item.");
        }
        System.out.println("Uploading item for BRAND:");
        System.out.println("Brand Name: " + currentBrand.getBrand_name());


        // Basic components of an item

        String itemType = getItemTypes();
        String itemName = UploadPage.getItemName();
        String size = getSelected(size_combo);
        String color = getSelected(color_combo);
        double price = Double.parseDouble(UploadPage.getPrice());
        String imagePath = UploadPage.getPost_photo();
        String description = UploadPage.getDescription();

        String itemID = IDGenerator.generateID();
        String brandId = currentBrand.getId();

        String sleeveLength = "";
        String shoeType = "";

        int waistSize = 0;
        Item item = null;

        switch (itemType) {
            case "Tops" -> {
                System.out.println("Going to make class");
                sleeveLength = getSelected(sleeve_length_combo);
                item = new Tops(itemName, size, sleeveLength, price, color, description,
                        imagePath, itemID, brandId);
            }
            case "Bottoms" -> {
                waistSize = Integer.parseInt(getSelected(waist_size_combo));item = new Bottoms(itemName, size, waistSize, price, color, description,
                      imagePath, itemID, brandId);
            }
            case "Shoes" -> {
                shoeType = getSelected(shoes_type_combo);
                item = new Shoes(itemName, size, shoeType, price, color, description,
                        imagePath, itemID, brandId);
            }
        }
        System.out.println(sleeveLength);
        itemMap.put(itemID,item);
        currentBrand.addItem(item); // add to brand class

        System.out.println("Uploaded item: " + itemName);
        System.out.println("Item ID: " + itemID);
        System.out.println("↳ Uploaded by brand ID: " + brandId);

        writeItemtoTextFile(itemName, size, color, price,
                imagePath, description, itemID, brandId,
                sleeveLength, waistSize, shoeType, itemType);
    }


    public static void writeItemtoTextFile(String itemName, String size, String color, double price,
                                            String imagePath, String description, String itemID, String brandID,
                                           String sleeveLength, int waistSize, String shoeType, String itemType) throws IOException {
        FileWriter fw = new FileWriter(populateProgram.itemsFile, true);
        PrintWriter out = new PrintWriter(fw);

        System.out.println(sleeveLength);

        if(itemType.equals("Tops")) {
            out.println(itemName + "," + size + "," + sleeveLength + "," + price + "," + description + "," + color +
                    "," + imagePath + "," + itemID + "," + itemType + ',' + brandID);
        } else if(itemType.equals("Bottoms")){
            out.println(itemName + "," + size + "," + waistSize + "," + price + "," + description + "," + color +
                    "," + imagePath + "," + itemID + "," + itemType + ',' + brandID);
        } else if(itemType.equals("Shoes")){
            out.println(itemName + "," + size + "," + shoeType + "," + price + "," + description + "," + color +
                    "," + imagePath + "," + itemID + "," + itemType + ',' + brandID);
        } else {
            System.out.println("Unknown item type: " + itemType);
        }

        out.close();
    }







}
