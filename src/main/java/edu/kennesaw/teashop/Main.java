package edu.kennesaw.teashop;

import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import edu.kennesaw.teashop.userinterface.Application;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryBuilder;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryOutputWriter;

public class Main{
    public static void main(String[] args){

        InventoryRepository repository = new InventoryRepository();
        InventoryQueryBuilder queryBuilder = new InventoryQueryBuilder(repository);
        InventoryQueryOutputWriter outputWriter = new InventoryQueryOutputWriter();

        Application application = new Application(queryBuilder, outputWriter);
        application.run();
    }
}