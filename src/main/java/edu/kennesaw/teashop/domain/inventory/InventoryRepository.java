package edu.kennesaw.teashop.domain.inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    private List<InventoryItem> items;

    public InventoryRepository(){
        items = new ArrayList<>(InventoryDataSeeder.createSeedData());
    }

}
