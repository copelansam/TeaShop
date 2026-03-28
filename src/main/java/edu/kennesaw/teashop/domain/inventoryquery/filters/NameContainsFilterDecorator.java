package edu.kennesaw.teashop.domain.inventoryquery.filters;

import edu.kennesaw.teashop.domain.inventoryquery.IInventoryQuery;
import edu.kennesaw.teashop.domain.inventoryquery.InventoryQueryDecoratorBase;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Will filter out inventory items based on whether their name matches what the user inputs
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
