package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.StarRating;
import edu.kennesaw.teashop.domain.inventoryquery.sorts.SortDirection;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

// This class will serve as a DTO that will store the query that a user creates, the items that the query returns,
// and the choices that the user made to create the query. Will be used by the query builder and writer
public class InventorySearchSession {

    private List<QueriedInventoryItem> queriedItems;
    private final IInventoryQuery query;
    private final String nameFilter;
    private final boolean availabilityFilter;
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    private final StarRating minRating;
    private final StarRating maxRating;
    private final SortDirection priceSortDirection;
    private final SortDirection ratingSortDirection;

    // When the object is first created, the query will not have been run yet. Once the query is run we can use a setter to set the list of items
    public InventorySearchSession(IInventoryQuery query,
                                  String nameFilter,
                                  boolean availabilityFilter,
                                  BigDecimal minPrice,
                                  BigDecimal maxPrice,
                                  StarRating minRating,
                                  StarRating maxRating,
                                  SortDirection priceSortDirection,
                                  SortDirection ratingSortDirection){

        this.queriedItems = null;
        this.query = query;
        this.nameFilter = nameFilter;
        this.availabilityFilter = availabilityFilter;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minRating = minRating;
        this.maxRating = maxRating;
        this.priceSortDirection = priceSortDirection;
        this.ratingSortDirection = ratingSortDirection;
    }

    public void setQueriedItems(List<QueriedInventoryItem> queriedItems){
        this.queriedItems = queriedItems;
    }

    public List<QueriedInventoryItem> getQueriedItems() {
        return Collections.unmodifiableList(queriedItems);
    }

    public IInventoryQuery getQuery(){
        return query;
    }

    public String getNameFilter(){
        return nameFilter;
    }

    public boolean getAvailableFilter() {
        return availabilityFilter;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public StarRating getMinRating() {
        return minRating;
    }

    public StarRating getMaxRating() {
        return maxRating;
    }

    public SortDirection getPriceSortDirection() {
        return priceSortDirection;
    }

    public SortDirection getRatingSortDirection() {
        return ratingSortDirection;
    }

    public boolean isEmpty(){
        return queriedItems.isEmpty();
    }

    public int getNumberOfItems(){
        return queriedItems.size();
    }
}
