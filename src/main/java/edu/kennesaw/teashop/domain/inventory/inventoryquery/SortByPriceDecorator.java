package edu.kennesaw.teashop.domain.inventory.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class SortByPriceDecorator extends InventoryQueryDecoratorBase {

    private boolean ascending;

    public SortByPriceDecorator(IInventoryQuery query, boolean ascending){
        super(query);
        this.ascending = ascending;
    }

    public List<InventoryItem> getItems(){
        // code to sort the items by price
    }
}
