package edu.kennesaw.teashop.domain.inventory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class InventoryDataSeeder {

    public static List<InventoryItem> createSeedData(){

        List<InventoryItem> items = List.of(
                new InventoryItem(UUID.randomUUID(), "Green Tea", new BigDecimal(15.99).setScale(2, RoundingMode.HALF_UP), 50, new StarRating(4)),
                new InventoryItem(UUID.randomUUID(), "Black Tea", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP), 75, new StarRating(5)),
                new InventoryItem(UUID.randomUUID(), "Herbal Tea", new BigDecimal(14.29).setScale(2, RoundingMode.HALF_UP), 30, new StarRating(3)),
                new InventoryItem(UUID.randomUUID(), "Oolong Tea", new BigDecimal(18.00).setScale(2, RoundingMode.HALF_UP), 10, new StarRating(5)),
                new InventoryItem(UUID.randomUUID(), "Matcha", new BigDecimal(29.99).setScale(2, RoundingMode.HALF_UP), 0, new StarRating(4)),
                new InventoryItem(UUID.randomUUID(), "White Tea", new BigDecimal(22.50).setScale(2, RoundingMode.HALF_UP), 25, new StarRating(4)),
                new InventoryItem(UUID.randomUUID(), "Chai Tea", new BigDecimal(10.99).setScale(2, RoundingMode.HALF_UP), 60, new StarRating(3)),
                new InventoryItem(UUID.randomUUID(), "Earl Grey", new BigDecimal(13.99).setScale(2, RoundingMode.HALF_UP), 45, new StarRating(5)),
                new InventoryItem(UUID.randomUUID(), "Rooibos", new BigDecimal(17.10).setScale(2, RoundingMode.HALF_UP), 0, new StarRating(5)),
                new InventoryItem(UUID.randomUUID(), "Mint Tea", new BigDecimal(11.89).setScale(2, RoundingMode.HALF_UP), 80, new StarRating(1)),
                new InventoryItem(UUID.randomUUID(), "Jasmine Green", new BigDecimal(16.75).setScale(2, RoundingMode.HALF_UP), 35, new StarRating(4)),
                new InventoryItem(UUID.randomUUID(), "Darjeeling", new BigDecimal(21.60).setScale(2, RoundingMode.HALF_UP), 18, new StarRating(5))
        );

        return items;

    }
}
