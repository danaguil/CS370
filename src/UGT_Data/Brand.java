package UGT_Data;

import java.io.File;

public class Brand extends User{

    private String brand_name;
    private String brand_description;
    private File brand_image;
    private String instagram_name;
    private String tiktok_name;

    public Brand(String email, String username, String password, String brand_name, String brand_description,
                 File brand_image, String instagram_name, String tiktok_name) {
        super(email, username, password);
        this.brand_name = brand_name;
        this.brand_description = brand_description;
        this.brand_image = brand_image;
        this.instagram_name = instagram_name;
        this.tiktok_name = tiktok_name;
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

    public File getBrand_image() {
        return brand_image;
    }

    public void setBrand_image(File brand_image) {
        // Check if the new brand_image is a PNG or JPEG / JPG
        if(brand_image.getName().endsWith(".jpg") || brand_image.getName().endsWith(".png") || brand_image.getName().endsWith(".jpeg"))
        {
            System.out.println("Accepted new brand image " + brand_image.getName());
            this.brand_image = brand_image;
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
}
