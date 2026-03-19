package edu.kennesaw.teashop.domain.inventory.queries;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;

import java.util.List;

public class NameFilter extends QueryDecorator{

    private String name;

    public NameFilter(IItemQuery query, String name){
        super(query);
        this.name = name;
    }

    public List<InventoryItem> getItems(){
        // logic for retrieving object based on the name contents
    }
}
