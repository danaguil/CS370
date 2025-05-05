package UGT_Data;
import java.util.HashMap;
import java.util.Map;

public class Item {

    private String name;
    private final String itemId;
    private final String brandId;
    private double price;
    private String description;
    private String color;
    private String imagePath;
    private String size;

    public Item(String name, String size,double price, String description,
                String color, String imagePath, String itemId, String brandId) {
        this.itemId = itemId;
        this.brandId = brandId;

        this.name = name;
        this.size = size;
        this.price = price;
        this.description = description;
        this.color = color;
        this.imagePath = imagePath;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void listToString(String[] givenList){
        for (String s : givenList) {
            System.out.print(s + " ");
        }
    }

    public String getItemId() {
        return itemId;
    }

    public String getBrandId() {
        return brandId;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Id: " + getItemId());
    }
}
