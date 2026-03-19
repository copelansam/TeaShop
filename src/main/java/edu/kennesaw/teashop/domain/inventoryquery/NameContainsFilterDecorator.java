package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameContainsFilterDecorator extends InventoryQueryDecoratorBase {

    private final String searchName;

    public NameContainsFilterDecorator(IInventoryQuery query, String searchName){
        super(query);
        this.searchName = searchName.toLowerCase();
    }

    public List<QueriedInventoryItem> getItems(){
        List<QueriedInventoryItem> filteredByName = new ArrayList<>();
        List<QueriedInventoryItem> items = wrappedQuery.getItems();

        for (QueriedInventoryItem item : items){
            if (item.getName().toLowerCase().contains(searchName)){
                filteredByName.add(item);
            }
        }
        return Collections.unmodifiableList(filteredByName);
    }
}
