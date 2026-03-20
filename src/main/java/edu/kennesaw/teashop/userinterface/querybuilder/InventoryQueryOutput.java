package edu.kennesaw.teashop.userinterface.querybuilder;

import edu.kennesaw.teashop.domain.inventory.StarRating;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import edu.kennesaw.teashop.domain.inventoryquery.SortDirection;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class InventoryQueryOutput {

    private final List<QueriedInventoryItem> queriedItems;
    private final String nameFilter;
    private final boolean availabilityFilter;
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;
    private final StarRating minRating;
    private final StarRating maxRating;
    private final SortDirection priceSortDirection;
    private final SortDirection ratingSortDirection;

    public InventoryQueryOutput(List<QueriedInventoryItem> queriedItems,
                                String nameFilter,
                                boolean availabilityFilter,
                                BigDecimal minPrice,
                                BigDecimal maxPrice,
                                StarRating minRating,
                                StarRating maxRating,
                                SortDirection priceSortDirection,
                                SortDirection ratingSortDirection){

        this.queriedItems = queriedItems;
        this.nameFilter = nameFilter;
        this.availabilityFilter = availabilityFilter;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minRating = minRating;
        this.maxRating = maxRating;
        this.priceSortDirection = priceSortDirection;
        this.ratingSortDirection = ratingSortDirection;
    }

    public List<QueriedInventoryItem> getQueriedItems() {
        return Collections.unmodifiableList(queriedItems);
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
