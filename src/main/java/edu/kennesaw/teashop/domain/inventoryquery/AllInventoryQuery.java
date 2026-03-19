package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.InventoryRepository;

import java.util.ArrayList;
import java.util.List;

public class AllInventoryQuery implements IInventoryQuery {

    private final InventoryRepository repository;

    public AllInventoryQuery(InventoryRepository repository){
        this.repository = repository;
    }

    @Override
    public List<QueriedInventoryItem> getItems(){

        List<QueriedInventoryItem> queriedItems = new ArrayList<>();

        for (InventoryItem item : repository.getAllItems()){
            queriedItems.add(new QueriedInventoryItem(item));
        }
        return queriedItems;
    }
}
