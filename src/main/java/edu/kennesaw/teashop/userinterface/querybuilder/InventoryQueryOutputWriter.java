package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

public class InventoryQueryOutputWriter {

    public void writeOutputToScreen(InventorySearchSession querySession){



        System.out.println("======== Query Results ===========\n");

        // Filters applied
        System.out.println("These are the filters that were applied:\n");

        // Name filter
        if (!querySession.getNameFilter().isEmpty()){ // If the user specified a name filter, show it, otherwise don't show this line
            System.out.println("Filter: Name contains: " + querySession.getNameFilter());
        }

        // Availability filter
        if (querySession.getAvailableFilter()){
            System.out.println("Filter: In Stock (Quantity > 0)");
        }
        else{
            System.out.println("Filter: Out Of Stock (Quantity = 0)");
        }

        // Price range filter
        System.out.println("Filter: Price between $" + querySession.getMinPrice() + " and $" + querySession.getMaxPrice());

        // Star rating range filter
        System.out.println("Filter: Star Rating between " + querySession.getMinRating().getRating() + " and " + querySession.getMaxRating().getRating());

        // Price sort direction
        System.out.println("Sort: price (" + querySession.getPriceSortDirection().getDisplayName()+")");

        // Rating sort direction
        System.out.println("Sort: rating (" + querySession.getRatingSortDirection().getDisplayName() + ")");

        // Results

        if (querySession.getQueriedItems().isEmpty()){ // If no items were found
            System.out.println("\nNo items found with the filters you applied.");
        }
        else{
            System.out.println("\n" + querySession.getNumberOfItems() + " item(s) matched your query: ");
            int counter = 1;
            for (QueriedInventoryItem item : querySession.getQueriedItems()){

                System.out.println(counter + ". Name: " +item.getName()
                        + "   $" + item.getPrice().toPlainString()
                        + "  Qty: " + item.getAvailableQuantity()
                        + (item.getAvailableQuantity() == 0 ? " (Out of Stock)" : "") // If the item is out of stock, print a message saying so
                        + " " + item.getStarRating());

                counter++;
            }
        }
    }
}
