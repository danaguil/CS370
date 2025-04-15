package UGT_Data;

public class Bottoms extends Item {

    private int size;
    private double waistSize;
    private double inseam;
    private double rise;
    private String type;


    public Bottoms(String name, double price, int quantity, String description, String material_1, String material_2,
                   String material_3, String color, String tag_1, String tag_2, String tag_3, int size,
                   double waistSize, double inseam, double rise, String type) {

        super(name, price, quantity, description, material_1, material_2, material_3, color, tag_1, tag_2, tag_3);

        this.size = size;
        this.waistSize = waistSize;
        this.inseam = inseam;
        this.rise = rise;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(double waistSize) {
        this.waistSize = waistSize;
    }

    public double getInseam() {
        return inseam;
    }

    public void setInseam(double inseam) {
        this.inseam = inseam;
    }

    public double getRise() {
        return rise;
    }

    public void setRise(double rise) {
        this.rise = rise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
