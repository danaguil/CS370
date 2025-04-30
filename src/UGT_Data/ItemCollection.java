package UGT_Data;

import java.util.ArrayList;
import java.util.Objects;

public class ItemCollection implements DatabaseInterface {

    private final ArrayList<Item> itemCollection;

    public ItemCollection() {
        itemCollection = new ArrayList<>();
    }

    @Override
    public void addItem(Item itemToAdd) {
        itemCollection.add(itemToAdd);
        System.out.println("UGTData.Item added to collection.");
    }

    @Override
    public Item retrieveItem(String itemId) {
        // Base Case
        if(itemCollection.isEmpty()){
            return null;
        }

        for(Item item: itemCollection) {
            if(Objects.equals(item.getItemId(), itemId)) {
                return item;
            }
        }
        System.out.println("UGTData.Item not found.");
        return null;
    }

    @Override
    public void updateItem(int itemId, Item itemToUpdate) {
        // Base Case
        if(itemCollection.isEmpty()){
            System.out.println("UGTData.Item collection is empty.");
            return;
        }


    }

    @Override
    public int deleteItem() {
        return 0;
    }
}
