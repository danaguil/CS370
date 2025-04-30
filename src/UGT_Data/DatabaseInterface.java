package UGT_Data;

/*
 * This interface defines a contract for CRUD operations on items in a database.
 */
public interface DatabaseInterface {

    // Adds an brandItems.txt to the database
    void addItem(Item item);

    // Retrieves an brandItems.txt using its unique ID, return objects
    Item retrieveItem(String itemId);

    // updates details of existing brandItems.txt identified by itemID
    void updateItem(int itemId, Item itemToUpdate);

    // deletes an brandItems.txt from database
    int deleteItem();

}
