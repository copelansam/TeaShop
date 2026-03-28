package edu.kennesaw.teashop.domain.inventoryquery;

import java.util.List;

public interface IInventoryQuery {


    // This function will retrieve items based on whatever criteria each concrete class defines
    public List<QueriedInventoryItem> getItems();
}
