package edu.kennesaw.teashop.domain.inventory;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.util.UUID;

public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository){
        this.repository = repository;
    }

    public void updateQuantity(UUID uuid, int quantity){
        repository.updateQuantity(uuid, quantity);
    }
}
