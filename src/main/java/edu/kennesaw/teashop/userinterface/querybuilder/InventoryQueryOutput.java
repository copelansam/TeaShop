package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.util.List;

public class InventoryQueryOutput {

    private final List<QueriedInventoryItem> queriedItems;

    public InventoryQueryOutput(List<QueriedInventoryItem> queriedItems){

        this.queriedItems = queriedItems;
    }
}
