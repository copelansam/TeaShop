package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class NameContainsFilterDecorator extends InventoryQueryDecoratorBase {

    private String name;

    public NameContainsFilterDecorator(IInventoryQuery query, String name){
        super(query);
        this.name = name;
    }

    public List<InventoryItem> getItems(){
        // logic for retrieving object based on the name contents
    }
}
