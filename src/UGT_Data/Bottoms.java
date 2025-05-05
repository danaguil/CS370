package UGT_Data;

/**
 * Bottoms class that extends Item class
 * waistSize: e.g. "34", "35", "36"
 */
public class Bottoms extends Item {

    private double waistSize;

    public Bottoms(String name, String size, double waistSize, double price, String description, String color,
                   String imagePath, String itemId, String brandId) {

        super(name, size, price, description, color, imagePath, itemId, brandId);

        this.waistSize = waistSize;
    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(double waistSize) {
        this.waistSize = waistSize;
    }
}
