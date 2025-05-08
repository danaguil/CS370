package UGT_Data;

/**
 * Bottoms class that extends Item class
 * waistSize: e.g. "34", "35", "36"
 */
public class Bottoms extends Item {

    private String bottomType;
    private int waistSize;
    private int inseam;
    private int rise;
    private int length;

    public Bottoms(String name, String size, String bottomType, int waistSize, int inseam,
                   int rise, int length, double price, String description,
                   String color, String imagePath, String itemId, String brandId) {

        super(name, size, price, description, color, imagePath, itemId, brandId);
        this.bottomType = bottomType;
        this.waistSize = waistSize;
        this.inseam = inseam;
        this.rise = rise;
        this.length = length;

    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public String getBottomType() {
        return bottomType;
    }

    public void setBottomType(String bottomType) {
        this.bottomType = bottomType;
    }

    public int getInseam() {
        return inseam;
    }

    public void setInseam(int inseam) {
        this.inseam = inseam;
    }

    public int getRise() {
        return rise;
    }

    public void setRise(int rise) {
        this.rise = rise;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
