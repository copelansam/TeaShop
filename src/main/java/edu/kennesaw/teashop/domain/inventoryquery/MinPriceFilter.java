package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.math.BigDecimal;
import java.util.List;

public class MinPriceFilter extends InventoryQueryDecoratorBase {

    private BigDecimal minimunPrice;

    public MinPriceFilter(IInventoryQuery query, BigDecimal minimunPrice){
        super(query);
        this.minimunPrice = minimunPrice;
    }

    public List<InventoryItem> getItems(){
        // code to filter items based on minimum price
    }
}
