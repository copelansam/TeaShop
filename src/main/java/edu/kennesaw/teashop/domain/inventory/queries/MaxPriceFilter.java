package edu.kennesaw.teashop.domain.inventory.queries;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.math.BigDecimal;
import java.util.List;

public class MaxPriceFilter extends QueryDecorator{

    private BigDecimal maximumPrice;

    public MaxPriceFilter(IItemQuery query, BigDecimal maximumPrice){
        super(query);
        this.maximumPrice = maximumPrice;
    }

    public List<InventoryItem> getItems(){
        // code to filter based on the maximum price
    }
}
