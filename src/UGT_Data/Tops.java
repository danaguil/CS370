package UGT_Data;

/**
 * Tops class that extends Item class
 * Sleeve length: e.g. "short", "medium", "long"
 */
public class Tops extends Item {

    private String topType;
    private int chest_size;
    private int hemSize;
    private int sleeveLength;

    public Tops(String name, String size,String topType, int chest_size, int hemSize, int sleeveLength, double price, String color, String description,
                String imagePath, String itemId, String brandId) {

        super(name, size, price, description, color, imagePath, itemId, brandId);

        this.topType = topType;
        this.chest_size = chest_size;
        this.hemSize = hemSize;
        this.sleeveLength = sleeveLength;


    }

    public int getsleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(int sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public int getChest_size() {
        return chest_size;
    }

    public void setChest_size(int chest_size) {
        this.chest_size = chest_size;
    }

    public int getHemSize() {
        return hemSize;
    }

    public void setHemSize(int hemSize) {
        this.hemSize = hemSize;
    }
}

