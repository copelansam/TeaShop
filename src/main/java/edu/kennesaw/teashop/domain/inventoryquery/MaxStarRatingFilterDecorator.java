package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class MaxStarRatingFilterDecorator extends InventoryQueryDecoratorBase {

    private int starRating;

    public MaxStarRatingFilterDecorator(IInventoryQuery query, int starRating){
        super(query);
        this.starRating = starRating;
    }

    public List<InventoryItem> getItems(){
        // code to filter based on max star rating
    }

}
