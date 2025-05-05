package UGT_Data;

/**
 * Shoes class that extends Item class
 * shoeType: e.g. "running", "sneakers", "high heels"
 */
public class Shoes extends Item {
    private String shoeType;

    public Shoes(String name, String size, String shoeType, double price, String color,
                 String description, String imagePath, String itemId, String brandId) {
        super(name, size, price, description, color, imagePath, itemId, brandId);

        this.shoeType = shoeType;
    }

    public String getshoesType() {
        return shoeType;
    }

    public void getshoesType(String shoeType) {
        this.shoeType = shoeType;
    }
}
