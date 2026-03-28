package edu.kennesaw.teashop.domain.inventoryquery.sorts;

// This enum will store the different sorting directions, to make selection easier
public enum SortDirection {
    ASCENDING("ascending"),
    DESCENDING("descending");

    private final String displayName;

    SortDirection(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
