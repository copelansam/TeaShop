package edu.kennesaw.teashop.domain.inventory.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.math.BigDecimal;
import java.util.List;

public class MaxPriceFilter extends InventoryQueryDecoratorBase {

    private BigDecimal maximumPrice;

    public MaxPriceFilter(IInventoryQuery query, BigDecimal maximumPrice){
        super(query);
        this.maximumPrice = maximumPrice;
    }

    public List<InventoryItem> getItems(){
        // code to filter based on the maximum price
    }
}
