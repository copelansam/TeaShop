package edu.kennesaw.teashop.domain.inventory;

import java.util.UUID;

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
