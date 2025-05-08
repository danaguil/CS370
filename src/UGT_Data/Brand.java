package UGT_Data;

import UGT_Controllers.IDGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import static UGT_Controllers.populateProgram.brandMap;

public class Brand extends User{

    private String brand_name;
    private String brand_description;
    private String brand_image_path;
    private String instagram_name;
    private String tiktok_name;
    ArrayList<Item> brandItems; // Will hold item objects

    public Brand(String email, String username, String password, String brand_name, String brand_description,
                 String brand_image_path, String instagram_name, String tiktok_name, String id) {
        super(email, username, password, id);
        this.brand_name = brand_name;
        this.brand_description = brand_description;
        this.brand_image_path = brand_image_path;
        this.instagram_name = instagram_name;
        this.tiktok_name = tiktok_name;

        this.brandItems = new ArrayList<>();
    }


    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_description() {
        return brand_description;
    }

    public void setBrand_description(String brand_description) {
        this.brand_description = brand_description;
    }

    public String getBrand_image() {
        return brand_image_path;
    }

    public void setBrand_image(String brand_image) {
        // Check if the new brand_image is a PNG or JPEG / JPG
        if(brand_image.endsWith(".jpg") || brand_image.endsWith(".png") || brand_image.endsWith(".jpeg"))
        {
            System.out.println("Accepted new brand image " + brand_image);
            this.brand_image_path = brand_image;
        }
        else
        {
            System.out.println("Invalid image format selected.");
        }
    }

    public String getInstagram_name() {
        return instagram_name;
    }

    public void setInstagram_name(String instagram_name) {
        this.instagram_name = instagram_name;
    }

    public String getTiktok_name() {
        return tiktok_name;
    }

    public void setTiktok_name(String tiktok_name) {
        this.tiktok_name = tiktok_name;
    }

    // Getter for brand items
    public ArrayList<Item> getBrandItems() {
        return brandItems;
    }

    public void addItem(Item item){
       brandItems.add(item);
    }

    public static String getBrandUsernameById(String brandId) {
        for (Map.Entry<String, Brand> entry : brandMap.entrySet()) {
            if (entry.getValue().getId().equals(brandId)) {
                return entry.getKey(); // the username
            }
        }
        return null;
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // calls User's displayInfo()
        System.out.println("Brand Name: " + brand_name);
        System.out.println("About Brand: " + brand_description);
        System.out.println("Logo Location: " + brand_image_path);
        System.out.println("Instagram Handle: " + instagram_name);
        System.out.println("TikTok Handle: " + tiktok_name);
        System.out.println("Brand Items: " + brandItems);
        System.out.println("ID: " + getId());
        System.out.println("---------------------------");
    }

}
