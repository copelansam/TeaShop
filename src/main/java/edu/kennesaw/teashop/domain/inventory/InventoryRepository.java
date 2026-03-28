package edu.kennesaw.teashop.domain.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class InventoryRepository {

    private List<InventoryItem> items;

    public InventoryRepository(){
        items = new ArrayList<>(InventoryDataSeeder.createSeedData());
    }

    public List<InventoryItem> getAllItems(){
        return Collections.unmodifiableList(items);
    }


    // Leaving the logic open to support the ability to add or subtract the amount available
    public void updateQuantity(UUID uuid, int amount){
        InventoryItem changing = getItemById(uuid);

        if (changing == null){
            throw new IllegalArgumentException("No inventory item with UUID: " + uuid);
        }

        changing.changeAvailableQuantity(amount);
    }

    public InventoryItem getItemById(UUID uuid){
        for (InventoryItem item: items){
            if (item.getUuid().equals(uuid)){
                return item;
            }
        }
        return null;
    }

    // Allows for the addition of a new item. Will not be used in this application but would be useful if
    // I wanted to expand the program to allow inventory creation.
    public void createNewItem(InventoryItem item){
        items.add(item);
    }
}
