package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class MinStarRatingFilterDecorator extends InventoryQueryDecoratorBase {

    private int starRating;

    public MinStarRatingFilterDecorator(IInventoryQuery query, int starRating){
        super(query);
        this.starRating = starRating;
    }

    public List<InventoryItem> getItems(){
        // code to filter based on minimum star rating
    }
}
