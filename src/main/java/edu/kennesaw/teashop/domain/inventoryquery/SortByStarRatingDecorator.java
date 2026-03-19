package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByStarRatingDecorator extends InventoryQueryDecoratorBase {

    private final SortDirection direction;

    public SortByStarRatingDecorator(IInventoryQuery query, SortDirection direction){
        super(query);
        this.direction = direction;
    }

    public List<QueriedInventoryItem> getItems(){

        // Create a copy of the query that we can sort
        List<QueriedInventoryItem> sortByRating = new ArrayList<>(wrappedQuery.getItems());

        if (direction == SortDirection.ASCENDING){ // Sort by ascending star ratings
            sortByRating.sort(Comparator.comparing((QueriedInventoryItem item )-> item.getStarRating().getRating()));
        }
        else if (direction == SortDirection.DESCENDING){ // Sort by descending star ratings
            sortByRating.sort(Comparator.comparing((QueriedInventoryItem item) -> item.getStarRating().getRating()).reversed());
        }

        return Collections.unmodifiableList(sortByRating);
    }
}
