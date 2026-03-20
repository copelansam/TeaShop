package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

public class InventoryQueryOutputWriter {

    public void writeOutputToScreen(InventorySearchSession queryOutput){



        System.out.println("======== Query Results ===========\n");

        // Filters applied
        System.out.println("\nThese are the filters that were applied:");

        // Name filter
        if (!queryOutput.getNameFilter().isEmpty()){ // If the user specified a name filter, show it, otherwise don't show this line
            System.out.println("Filter: Name contains: " + queryOutput.getNameFilter());
        }

        // Availability filter
        if (queryOutput.getAvailableFilter()){
            System.out.println("Filter: In Stock (Quantity > 0)");
        }
        else{
            System.out.println("Filter: Out Of Stock (Quantity = 0)");
        }

        // Price range filter
        System.out.println("Filter: Price between $" + queryOutput.getMinPrice() + " and $" + queryOutput.getMaxPrice());

        // Star rating range filter
        System.out.println("Filter: Star Rating between " + queryOutput.getMinRating().getRating() + " and " + queryOutput.getMaxRating().getRating());

        // Price sort direction
        System.out.println("Sort: price (" + queryOutput.getPriceSortDirection().getDisplayName()+")");

        // Rating sort direction
        System.out.println("Sort: rating (" + queryOutput.getRatingSortDirection().getDisplayName() + ")");

        // Results

        if (queryOutput.getQueriedItems().isEmpty()){ // If no items were found
            System.out.println("No items found with the filters you applied.");
        }
        else{
            System.out.println(queryOutput.getNumberOfItems() + " item(s) matched your query: ");
            int counter = 1;
            for (QueriedInventoryItem item : queryOutput.getQueriedItems()){

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
