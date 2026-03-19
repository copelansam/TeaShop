package edu.kennesaw.teashop.domain.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InventoryRepository {

    private List<InventoryItem> items;

    public InventoryRepository(){
        items = new ArrayList<>(InventoryDataSeeder.createSeedData());
    }


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
}
