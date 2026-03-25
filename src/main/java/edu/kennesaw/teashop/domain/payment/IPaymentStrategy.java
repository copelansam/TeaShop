package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;

public interface IPaymentStrategy {

    public void pay(QueriedInventoryItem item);
}
