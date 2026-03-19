package edu.kennesaw.teashop.domain.inventoryquery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Will filter out inventory items by whether their price falls between the user specified minimum and maximum prices
public class PriceRangeFilterDecorator extends InventoryQueryDecoratorBase{

    private final BigDecimal minimumPrice;
    private final BigDecimal maximumPrice;

    public PriceRangeFilterDecorator(IInventoryQuery query, BigDecimal minimumPrice, BigDecimal maximumPrice){
        super(query);
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
    }

    @Override
    public List<QueriedInventoryItem> getItems(){

        List<QueriedInventoryItem> filteredByPrice = new ArrayList<>();
        List<QueriedInventoryItem> items = wrappedQuery.getItems();

        for (QueriedInventoryItem item : items) {

            if (item.getPrice().compareTo(minimumPrice) >= 0
                    && item.getPrice().compareTo(maximumPrice) <= 0) {
                filteredByPrice.add(item);
            }
        }
        return Collections.unmodifiableList(filteredByPrice);
    }
}
