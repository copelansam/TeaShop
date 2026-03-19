package edu.kennesaw.teashop.domain.inventoryquery;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.StarRating;

import java.math.BigDecimal;
import java.util.UUID;

public class QueriedInventoryItem {

    private UUID uuid;
    private String name;
    private BigDecimal price;
    private int availableQuantity;
    private StarRating starRating;

    public QueriedInventoryItem(InventoryItem item){
        setUuid(item.getUuid());
        setName(item.getName());
        setPrice(item.getPrice());
        setAvailableQuantity(item.getAvailableQuantity());
        setStarRating(item.getStarRating());
    }

    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setAvailableQuantity(int availableQuantity){
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public StarRating getStarRating() {
        return starRating;
    }
}
