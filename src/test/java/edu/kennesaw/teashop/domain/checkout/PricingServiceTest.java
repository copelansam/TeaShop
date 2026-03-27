package edu.kennesaw.teashop.domain.checkout;

import edu.kennesaw.teashop.domain.inventory.InventoryItem;
import edu.kennesaw.teashop.domain.inventory.StarRating;
import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    TotalPriceCalculator testPricingService = new TotalPriceCalculator();

    // Tests that the order total is properly calculated by multiplying the price by quantity
    @Test
    public void testOrderTotal(){

        QueriedInventoryItem testItem = new QueriedInventoryItem(
                new InventoryItem(UUID.fromString("11111111-1111-1111-1111-111111111111"),"name",
                        new BigDecimal(12.45).setScale(2, RoundingMode.HALF_UP),15,
                        new StarRating(4)));


        assertEquals(62.25,testPricingService.getOrderTotal(testItem, 5).doubleValue());

    }
}
