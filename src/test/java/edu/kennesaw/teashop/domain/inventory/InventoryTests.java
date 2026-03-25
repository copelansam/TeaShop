package edu.kennesaw.teashop.domain.inventory;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryTests {

    // Tests that InventoryItems are properly initialized
    @Test
    public void testItemInitialization() {
        UUID id = UUID.randomUUID();
        String name = "testObject";
        BigDecimal price = new BigDecimal(12.45);
        int availableQuantity = 17;
        StarRating rating = new StarRating(4);

        InventoryItem testItem = new InventoryItem(id,name,price,availableQuantity,rating);

        assertEquals(id, testItem.getUuid());
        assertEquals(name, testItem.getName());
        assertEquals(price, testItem.getPrice());
        assertEquals(availableQuantity, testItem.getAvailableQuantity());
        assertEquals(rating, testItem.getStarRating());

    }

    @Test
    public void testUpdateQuantity(){}


}
