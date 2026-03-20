package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventory.StarRating;
import edu.kennesaw.teashop.domain.inventoryquery.*;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InventoryQueryBuilder {

    private final Scanner scan = ScannerSingleton.getInstance();
    private String nameFilter;
    private boolean availabilityFilter;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private StarRating minRating;
    private StarRating maxRating;
    private SortDirection priceSort;
    private SortDirection ratingSort;

    public IInventoryQuery build(AllInventoryQuery baseQuery){

        IInventoryQuery query = baseQuery;

        query = buildNameQuery(query);
        query = buildAvailabilityQuery(query);
        query = buildPriceRangeQuery(query);
        query = buildStarRangeQuery(query);
        query = buildPriceSortQuery(query);
        query = buildStarRatingSortQuery(query);


        return query;
    }

    public IInventoryQuery buildNameQuery(IInventoryQuery query){

        System.out.print("* Tea name contains (leave blank for all names): ");
        String nameSearch = scan.nextLine();

        if (!nameSearch.isEmpty()){ // if the user input something, wrap the query with that term,
            // otherwise don't wrap the query to keep all names.
            query = new NameContainsFilterDecorator(query,nameSearch);
        }

        // Store what the input to recall later
        this.nameFilter = nameSearch;
        return query;
    }

    public IInventoryQuery buildAvailabilityQuery(IInventoryQuery query){

        System.out.print("* Is available? (Y/N, default Y): ");
        String availableSearchInput = scan.nextLine().toUpperCase();
        boolean availability = true;

        if (availableSearchInput.isEmpty()){ // If the user inputs nothing, use the default: in stock items
            availability = true;
        }
        else if (availableSearchInput.charAt(0) == 'N'){ // If the user says no, then search for out of stock items
            availability = false;
        }
        else{ // Otherwise use the default: in stock items
            availability = true;
        }

        this.availabilityFilter = availability;
        query = new AvailabilityFilterDecorator(query, availability);
        return query;
    }

    public IInventoryQuery buildPriceRangeQuery(IInventoryQuery query){

        BigDecimal minimumPriceSearch = null;
        System.out.print("* Price minimum (default $0): ");

        while (minimumPriceSearch == null) {
            String minimumPriceInput = scan.nextLine();

            if (minimumPriceInput.isEmpty()) { // If the user doesn't put anything in, then set the minimum to 0
                minimumPriceSearch = new BigDecimal(0);
            }
            else {
                try { // Try to convert the user input to a valid money value, if you can't, catch the error and tell the use rot try again.
                    minimumPriceSearch = new BigDecimal(minimumPriceInput).setScale(2, RoundingMode.HALF_UP);

                    if (minimumPriceSearch.doubleValue() < 0) {
                        System.out.println("Price has to be greater than or equal to $0. Try again.");
                        minimumPriceSearch = null;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid price!");
                }
            }
        }

        BigDecimal maximumPriceSearch = null;
        System.out.print("* Price maximum (default $1000): ");

        while (maximumPriceSearch == null){
            String maximumPriceInput = scan.nextLine();

            if (maximumPriceInput.isEmpty()){
                maximumPriceSearch = new BigDecimal(1000);
            }
            else{
                try{

                    maximumPriceSearch = new BigDecimal(maximumPriceInput).setScale(2, RoundingMode.HALF_UP);;

                    if (minimumPriceSearch.compareTo(maximumPriceSearch) > 0){
                        System.out.println("You entered a maximum that is less than the minimum. Enter a maximum value greater than the minimum.");
                        maximumPriceSearch = null;
                    }

                }
                catch (NumberFormatException e){
                    System.out.println("Enter a valid price!");
                    maximumPriceSearch = null;
                }
            }
        }

        query = new PriceRangeFilterDecorator(query, minimumPriceSearch, maximumPriceSearch);

        // Store what the user input to recall later
        this.minPrice = minimumPriceSearch;
        this.maxPrice = maximumPriceSearch;

        return query;
    }

    public IInventoryQuery buildStarRangeQuery(IInventoryQuery query){

        System.out.print("* Star rating minimum (1-5, default 3): ");
        StarRating minimumRatingSearch = null;

        while (minimumRatingSearch == null) {

            String minimumRatingInput = scan.nextLine();

            try {

                if (minimumRatingInput.isEmpty()) { // If the user doesn't put anything in, use the default: 3.
                    minimumRatingSearch = new StarRating(3);
                }
                else if (Integer.parseInt(minimumRatingInput) < 1
                        || Integer.parseInt(minimumRatingInput) > 5) { // If the user did not put a number between 1 and 5, tell them to try again
                    throw new NumberFormatException();
                }
                else{ // If the user put in a valid number, make it the minimum search value
                    minimumRatingSearch = new StarRating(Integer.parseInt(minimumRatingInput));
                }
            }
            catch(NumberFormatException e){
                System.out.println("Enter a number between 1 and 5.");
            }
        }

        System.out.print("* Star rating maximum (1-5, default 5): ");
        StarRating maximumRatingSearch = null;

        while(maximumRatingSearch == null){

            String maximumRatingInput = scan.nextLine();

            try{

                if (maximumRatingInput.isEmpty()){ // If the user enters nothing, use the default value: 5
                    maximumRatingSearch = new StarRating(5);
                }
                else if (Integer.parseInt(maximumRatingInput) > 5  // If the user input something greater than 5, or less than the minimum, have them try again
                        || Integer.parseInt(maximumRatingInput) < minimumRatingSearch.getRating()){
                    throw new NumberFormatException();
                }
                else {
                    maximumRatingSearch = new StarRating(Integer.parseInt(maximumRatingInput));
                }
            }
            catch (NumberFormatException e){
                System.out.println("Enter a number between " + minimumRatingSearch.getRating() + " and 5");
            }
        }

        query = new StarRatingRangeFilterDecorator(query, minimumRatingSearch, maximumRatingSearch);

        // Store what the user input to recall later.
        this.minRating = minimumRatingSearch;
        this.maxRating = maximumRatingSearch;

        return query;
    }

    public IInventoryQuery buildPriceSortQuery(IInventoryQuery query){

        System.out.print("* Sort by Price (A/D, default A): ");
        String priceSortInput = scan.nextLine().toUpperCase();
        SortDirection direction;

        if (priceSortInput.isEmpty()){ // If the user inputs nothing, due the default: ascending
            direction = SortDirection.ASCENDING;
        }
        else if (priceSortInput.charAt(0) == 'D'){ // If the user inputs that they want descending, make the query descending
            direction = SortDirection.DESCENDING;
        }
        else{ // Otherwise use the default value: Ascending
            direction = SortDirection.ASCENDING;
        }

        // Store user input for later
        this.priceSort = direction;

        // Wrap query
        query = new SortByPriceDecorator(query, direction);
        return query;
    }

    public IInventoryQuery buildStarRatingSortQuery(IInventoryQuery query){

        System.out.println("* Sort by Star rating (A/D, default D): ");
        String ratingSortInput = scan.nextLine().toUpperCase();
        SortDirection direction;


        if (ratingSortInput.isEmpty()){ // If the user inputs nothing, use the default: descending.
            direction = SortDirection.DESCENDING;
        }
        else if (ratingSortInput.charAt(0) == 'A') { // otherwise, if the user explicitly states that they want ascending, use ascending.
            direction = SortDirection.ASCENDING;
        } else { // If the user does not explicitly want ascending, use the default: descending.
            direction = SortDirection.DESCENDING;
        }

        query = new SortByStarRatingDecorator(query, direction);

        this.ratingSort = direction;

        return query;
    }
}
