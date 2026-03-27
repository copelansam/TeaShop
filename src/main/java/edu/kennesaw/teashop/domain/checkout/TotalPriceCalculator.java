package edu.kennesaw.teashop.domain.checkout;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TotalPriceCalculator {

    // Calculates the total of purchasing the selected quantity of a given item
    public BigDecimal getOrderTotal(QueriedInventoryItem itemToPurchase, int quantityToPurchase){

        BigDecimal amount = new BigDecimal(itemToPurchase.getPrice().doubleValue() * quantityToPurchase).setScale(2, RoundingMode.HALF_UP);
        return amount;
    }
}
