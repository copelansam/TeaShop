package edu.kennesaw.teashop.domain.inventory;


import java.util.UUID;
import java.math.BigDecimal;

public class InventoryItem{

    private UUID uuid;
    private String name;
    private BigDecimal price;
    private int availableQuantity;
    private StarRating starRating;

    public InventoryItem(UUID uuid, String name, BigDecimal price, int availableQuantity,  StarRating starRating){
        setUuid(uuid);
        setName(name);
        setPrice(price);
        setAvailableQuantity(availableQuantity);
        setStarRating(starRating);
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