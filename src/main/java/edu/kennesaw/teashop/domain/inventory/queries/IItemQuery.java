package edu.kennesaw.teashop.domain.inventory.queries;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public interface IItemQuery {


    // This function will retrieve items based on whatever criteria each concrete class defines
    public List<InventoryItem> getItems();
}
