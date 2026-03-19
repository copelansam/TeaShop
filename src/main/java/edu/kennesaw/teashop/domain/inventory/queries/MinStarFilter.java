package edu.kennesaw.teashop.domain.inventory.queries;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class MinStarFilter extends QueryDecorator{

    private int starRating;

    public MinStarFilter(IItemQuery query, int starRating){
        super(query);
        this.starRating = starRating;
    }

    public List<InventoryItem> getItems(){
        // code to filter based on minimum star rating
    }
}
