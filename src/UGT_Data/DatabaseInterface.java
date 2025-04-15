package UGT_Data;

public interface DatabaseInterface {

    void addItem(Item item);
    Item retrieveItem(int itemId);
    void updateItem(int itemId, Item itemToUpdate);
    int deleteItem();

}
