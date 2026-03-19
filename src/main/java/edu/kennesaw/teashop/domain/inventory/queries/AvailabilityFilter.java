package edu.kennesaw.teashop.domain.inventory.queries;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class AvailabilityFilter extends QueryDecorator{

    private boolean avialable;

    AvailabilityFilter(IItemQuery query, boolean available){
        super(query);
        this.avialable = available;
    }

    public List<InventoryItem> getItems(){
        // code for filtering based on availability
    }

}
