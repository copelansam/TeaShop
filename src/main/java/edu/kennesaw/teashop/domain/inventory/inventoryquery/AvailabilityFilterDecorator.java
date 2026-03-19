package edu.kennesaw.teashop.domain.inventory.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class AvailabilityFilterDecorator extends InventoryQueryDecoratorBase {

    private boolean avialable;

    AvailabilityFilterDecorator(IInventoryQuery query, boolean available){
        super(query);
        this.avialable = available;
    }

    public List<InventoryItem> getItems(){
        // code for filtering based on availability
    }

}
