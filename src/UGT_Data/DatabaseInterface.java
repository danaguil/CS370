package UGT_Data;

/*
 * This interface defines a contract for CRUD operations on items in a database.
 */
public interface DatabaseInterface {

    // Adds an item to the database
    void addItem(Item item);

    // Retrieves an item using its unique ID, return objects
    Item retrieveItem(String itemId);

    // updates details of existing item identified by itemID
    void updateItem(int itemId, Item itemToUpdate);

    // deletes an item from database
    int deleteItem();

}
