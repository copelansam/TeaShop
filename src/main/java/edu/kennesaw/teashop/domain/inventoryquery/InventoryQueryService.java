package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryRepository;
import edu.kennesaw.teashop.userinterface.querybuilder.InventoryQueryBuilder;

import java.util.List;

// This class will orchestrate the query building and execution process
public class InventoryQueryService {

    private final InventoryRepository repository;

    public InventoryQueryService(InventoryRepository repository){
        this.repository = repository;
    }

    // Builds the query and stores what the user selects so that we can display it
    public InventorySearchSession buildQuery(){

        // Build the query. Uses decorator chain to wrap it based on user choices
        InventoryQueryBuilder queryBuilder = new InventoryQueryBuilder(repository);

        return queryBuilder.build();
    }

    public List<QueriedInventoryItem> executeQuery(InventorySearchSession querySession){

        // Executes the query and stores the result
        List<QueriedInventoryItem> items = querySession.getQuery().getItems();

        // Adds the queried items to the session
        querySession.setQueriedItems(items);

        // returns the queried items
        return items;

    }
}
