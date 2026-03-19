package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class SortByStarRatingDecorator extends InventoryQueryDecoratorBase {

    private boolean ascending;

    public SortByStarRatingDecorator(IInventoryQuery query, boolean ascending){
        super(query);
        this.ascending = ascending;
    }

    public List<InventoryItem> getItems(){
        // code to sort the items by star rating
    }
}
