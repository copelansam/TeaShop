package edu.kennesaw.teashop;

import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import edu.kennesaw.teashop.domain.inventory.InventoryService;
import edu.kennesaw.teashop.domain.inventoryquery.InventoryQueryService;
import edu.kennesaw.teashop.userinterface.Application;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryOutputWriter;

public class Main{
    public static void main(String[] args){

        InventoryRepository repository = new InventoryRepository();
        InventoryService inventoryService = new InventoryService(repository);
        InventoryQueryService queryService = new InventoryQueryService(repository);
        InventoryQueryOutputWriter outputWriter = new InventoryQueryOutputWriter();

        Application application = new Application(outputWriter, inventoryService, queryService);
        application.run();
    }
}