package UGT_Data;

/**
 * Tops class that extends Item class
 * Sleeve length: e.g. "short", "medium", "long"
 */
public class Tops extends Item {

    private String sleeveLength;

    public Tops(String name, String size, String sleeveLength, double price, String color, String description,
                String imagePath, String itemId, String brandId) {

        super(name, size, price, description, color, imagePath, itemId, brandId);

        this.sleeveLength = sleeveLength;
    }

    public String getsleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(String sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

}

