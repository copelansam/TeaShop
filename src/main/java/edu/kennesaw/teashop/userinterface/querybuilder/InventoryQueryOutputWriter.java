package edu.kennesaw.teashop.userinterface.querybuilder;

public class InventoryQueryOutputWriter {

    public void writeOutputToScreen(InventoryQueryOutput queryOutput){

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
        System.out.println("Filter: Price between $" + queryOutput.getMinPrice().doubleValue() + " and $" + queryOutput.getMaxPrice().doubleValue());

        // Star rating range filter
        System.out.println("Filter: Star Rating between " + queryOutput.getMinRating().getRating() + " and " + queryOutput.getMaxRating().getRating());

        // Price sort direction
        System.out.println("Sort: price (" + queryOutput.getPriceSortDirection().getDisplayName()+")");

        // Rating sort direction
        System.out.println("Sort rating (" + queryOutput.getRatingSortDirection().getDisplayName() + ")");



    }
}
