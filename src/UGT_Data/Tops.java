package UGT_Data;

public class Tops extends Item {

    private String size;
    private double chestSize;
    private double hemSize;
    private double sleeveSize;
    private double length;
    private String type;

    public Tops(String id, String name, double price, int quantity, String description, String material_1, String material_2,
                String material_3, String color, String tag_1, String tag_2, String tag_3, String size,
                double chestSize, double hemSize, double sleeveSize, double length , String type) {

        super(id, name, price, quantity, description, material_1, material_2, material_3, color, tag_1, tag_2, tag_3);

        this.size = size;
        this.chestSize = chestSize;
        this.hemSize = hemSize;
        this.sleeveSize = sleeveSize;
        this.length = length;
        this.type = type;

    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getChestSize() {
        return chestSize;
    }

    public void setChestSize(double chestSize) {
        this.chestSize = chestSize;
    }

    public double getHemSize() {
        return hemSize;
    }

    public void setHemSize(double hemSize) {
        this.hemSize = hemSize;
    }

    public double getSleeveSize() {
        return sleeveSize;
    }

    public void setSleeveSize(double sleeveSize) {
        this.sleeveSize = sleeveSize;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
