package edu.kennesaw.teashop.domain.inventory.queries;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class RatingSort extends QueryDecorator{

    private boolean ascending;

    public RatingSort(IItemQuery query, boolean ascending){
        super(query);
        this.ascending = ascending;
    }

    public List<InventoryItem> getItems(){
        // code to sort the items by star rating
    }
}
