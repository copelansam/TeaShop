package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public interface IInventoryQuery {


    // This function will retrieve items based on whatever criteria each concrete class defines
    public List<QueriedInventoryItem> getItems();
}
