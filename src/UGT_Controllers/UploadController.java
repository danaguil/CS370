package UGT_Controllers;
import UGT_Data.*;
import UGT_UI.*;

import java.util.HashMap;
import java.util.Objects;

// imported the hasmaps with the classes
import static UGT_Controllers.populateProgram.brandMap;
import static UGT_Controllers.populateProgram.itemMap;
public class UploadController {

    public static void uploadItem(String itemType) {
        Brand currentBrand = programSession.getLoggedInBrand();
        if (itemType == null) {
            System.out.println("error");
            return;
        }

        if(currentBrand == null){
            return;
        }

        System.out.println("Uploading item for BRAND:");
        System.out.println("Brand Name: " + currentBrand.getBrand_name());
        System.out.println("Brand ID: " + currentBrand.getId());

        String itemID = IDGenerator.generateID();
        String name = UploadPage.getItemName();
        double price = Double.parseDouble(UploadPage.getPrice());
        //int quantity = Integer.parseInt(UploadPage.getQuantity());
        int quantity = 1;
        String description = UploadPage.getDescription();

        String material1 = Objects.requireNonNull(UploadPage.material_1_combo.getSelectedItem()).toString();
        String material2 = Objects.requireNonNull(UploadPage.material_2_combo.getSelectedItem()).toString();
        String material3 = Objects.requireNonNull(UploadPage.material_3_combo.getSelectedItem()).toString();
        String color = Objects.requireNonNull(UploadPage.color_combo.getSelectedItem()).toString();

        // Tags based on item type (example)
        String tag1 = "idk";
        String tag2 = "Clothing";
        String tag3 = "UGThreads";

        String imagePath = UploadPage.getPost_photo();

        Item item = new Item(name, price, quantity, description,
                material1, material2, material3, color,
                tag1, tag2, tag3, imagePath, itemID, currentBrand.getId()); // assuming current brand

        itemMap.put(item.getItemId(), item);
        currentBrand.addItem(item); // add to brand class

        System.out.println("Uploaded item: " + name);
        System.out.println("Item ID: " + item.getItemId());
        System.out.println("↳ Uploaded by brand ID: " + item.getBrandId());

        item.displayInfo();
    }






}
