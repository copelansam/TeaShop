package edu.kennesaw.teashop.domain.inventory;

import edu.kennesaw.teashop.domain.inventoryquery.InventorySearchSession;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryBuilder;

import java.util.UUID;

// This class will orchestrate actions related to the inventory including query building, updating available quantities, and adding new items
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository){
        this.repository = repository;
    }

    public void updateQuantity(UUID uuid, int quantity){
        repository.updateQuantity(uuid, quantity);
    }

    public void addNewItem(InventoryItem item){
        repository.createNewItem(item);
    }
}
