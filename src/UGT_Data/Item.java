package UGT_Data;

import UGT_Controllers.IDGenerator;

public class Item {

    private String name;
    private final String itemId;
    private final String brandId;
    private double price;
    private int quantity;
    private String description;
    private String tag_1;
    private String tag_2;
    private String tag_3;
    private String color;
    private String material_1;
    private String material_2;
    private String material_3;
    String[] materialsList;
    String[] tagsList;
    private String imagePath;

    public Item(String name, double price, int quantity, String description,
                String material_1, String material_2, String material_3,
                String color, String tag_1, String tag_2, String tag_3, String imagePath, String itemId, String brandId) {
        this.itemId = itemId;
        this.brandId = brandId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.color = color;
        this.material_1 = material_1;
        this.material_2 = material_2;
        this.material_3 = material_3;
        this.tag_1 = tag_1;
        this.tag_2 = tag_2;
        this.tag_3 = tag_3;
        this.imagePath = imagePath;

        // Populate the materials list
        materialsList = new String[3];
        materialsList[0] = this.material_1;
        materialsList[1] = this.material_2;
        materialsList[2] = this.material_3;

        // Populate the tags list
        tagsList = new String[3];
        tagsList[0] = this.tag_1;
        tagsList[1] = this.tag_2;
        tagsList[2] = this.tag_3;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getMaterial_1() {
        return material_1;
    }

    public void setMaterial_1(String material_1) {
        this.material_1 = material_1;
        materialsList[0] = this.material_1;
    }

    public String getMaterial_2() {
        return material_2;
    }

    public void setMaterial_2(String material_2) {
        this.material_2 = material_2;
        materialsList[1] = this.material_2;
    }

    public String getMaterial_3() {
        return material_3;
    }

    public void setMaterial_3(String material_3) {
        this.material_3 = material_3;
        materialsList[2] = this.material_3;
    }

    public String getTag_1() {
        return tag_1;
    }

    public void setTag_1(String tag_1) {
        this.tag_1 = tag_1;
        tagsList[0] = this.tag_1;
    }

    public String getTag_2() {
        return tag_2;
    }

    public void setTag_2(String tag_2) {
        this.tag_2 = tag_2;
        tagsList[1] = this.tag_1;
    }

    public String getTag_3() {
        return tag_3;
    }

    public void setTag_3(String tag_3) {
        this.tag_3 = tag_3;
        tagsList[2] = this.tag_3;
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
