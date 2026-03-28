package edu.kennesaw.teashop.domain.inventoryquery.sorts;

import edu.kennesaw.teashop.domain.inventoryquery.IInventoryQuery;
import edu.kennesaw.teashop.domain.inventoryquery.InventoryQueryDecoratorBase;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Sorts inventory items by price in the user specified direction
public class SortByPriceDecorator extends InventoryQueryDecoratorBase {

    private final SortDirection direction;

    public SortByPriceDecorator(IInventoryQuery query, SortDirection direction){
        super(query);
        this.direction = direction;
    }

    public List<QueriedInventoryItem> getItems(){

        List<QueriedInventoryItem> items = wrappedQuery.getItems();
        List<QueriedInventoryItem> sortedByPrice = new ArrayList<>(items);

        if (direction == SortDirection.ASCENDING){ // Sort by ascending price
            sortedByPrice.sort(Comparator.comparing(QueriedInventoryItem::getPrice));
        }
        else if (direction == SortDirection.DESCENDING){ // Sort by descending price
            sortedByPrice.sort(Comparator.comparing(QueriedInventoryItem::getPrice).reversed());
        }
        return Collections.unmodifiableList(sortedByPrice);
    }
}
