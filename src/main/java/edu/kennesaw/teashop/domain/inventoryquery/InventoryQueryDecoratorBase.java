package edu.kennesaw.teashop.domain.inventoryquery;

public abstract class InventoryQueryDecoratorBase implements IInventoryQuery {

    protected IInventoryQuery wrappedQuery;

    public InventoryQueryDecoratorBase(IInventoryQuery wrappedQuery){
        this.wrappedQuery = wrappedQuery;
    }
}
