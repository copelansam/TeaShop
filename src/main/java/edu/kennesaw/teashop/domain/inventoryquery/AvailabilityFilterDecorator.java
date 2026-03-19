package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Will filter out the inventory objects by whether they are or are not in stock as chosen by the user
public class AvailabilityFilterDecorator extends InventoryQueryDecoratorBase {

    private final boolean available;

    public AvailabilityFilterDecorator(IInventoryQuery query, boolean available){
        super(query);
        this.available = available;
    }

    @Override
    public List<QueriedInventoryItem> getItems(){


        List<QueriedInventoryItem> filteredByAvailability = new ArrayList<>();
        List<QueriedInventoryItem> items = wrappedQuery.getItems();

        for (QueriedInventoryItem item : items){

            if((available && item.getAvailableQuantity() > 0)
                    || (!available && item.getAvailableQuantity() == 0)){
                filteredByAvailability.add(item);
            }
        }
        return Collections.unmodifiableList(filteredByAvailability);
    }

}
