package edu.kennesaw.teashop.domain.inventoryquery.filters;

import edu.kennesaw.teashop.domain.inventory.StarRating;
import edu.kennesaw.teashop.domain.inventoryquery.IInventoryQuery;
import edu.kennesaw.teashop.domain.inventoryquery.InventoryQueryDecoratorBase;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Will filter out inventory object by whether their star rating is between the minimum and maximum chosen by the user
public class StarRatingRangeFilterDecorator extends InventoryQueryDecoratorBase {

    private final StarRating minimumStars;
    private final StarRating maximumStars;

    public StarRatingRangeFilterDecorator(IInventoryQuery query, StarRating minimumStars, StarRating maximumStars){
        super(query);
        this.minimumStars = minimumStars;
        this.maximumStars = maximumStars;
    }

    @Override
    public List<QueriedInventoryItem> getItems(){

        List<QueriedInventoryItem> filteredByRating = new ArrayList<>();
        List<QueriedInventoryItem> items = wrappedQuery.getItems();

        for (QueriedInventoryItem item : items){
            if (item.getStarRating().getRating() >= minimumStars.getRating()
                    && item.getStarRating().getRating() <= maximumStars.getRating()){
                filteredByRating.add(item);
            }
        }

        return Collections.unmodifiableList(filteredByRating);
    }
}
