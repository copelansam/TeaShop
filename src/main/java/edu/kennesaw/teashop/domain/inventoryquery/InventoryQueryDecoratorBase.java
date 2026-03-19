package edu.kennesaw.teashop.domain.inventoryquery;

import java.util.List;

public abstract class InventoryQueryDecoratorBase implements IInventoryQuery {

    protected IInventoryQuery wrappedQuery;

    public InventoryQueryDecoratorBase(IInventoryQuery wrappedQuery){
        this.wrappedQuery = wrappedQuery;
    }

    @Override
    public List<QueriedInventoryItem> getItems(){
        return wrappedQuery.getItems();
    }
}
