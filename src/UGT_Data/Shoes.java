package UGT_Data;

public class Shoes extends Item {

    private int size;


    public Shoes(String id, String name, double price, int quantity, String description, String material_1, String material_2,
                 String material_3, String color, String tag_1, String tag_2, String tag_3, int size) {
        super(id, name, price, quantity, description, material_1, material_2, material_3, color, tag_1, tag_2, tag_3);

        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
