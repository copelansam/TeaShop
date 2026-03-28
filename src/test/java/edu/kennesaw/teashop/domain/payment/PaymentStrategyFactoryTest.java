package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.userinterface.paymentbuilder.ApplePayPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.CreditCardPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.CryptoCurrencyPaymentBuilder;
import edu.kennesaw.teashop.userinterface.paymentbuilder.IPaymentBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentStrategyFactoryTest {

    PaymentStrategyFactory testFactory = new PaymentStrategyFactory();

    @Test
    public void testCreateStrategy(){

        // Test creating a credit card builder
        edu.kennesaw.teashop.userinterface.paymentbuilder.IPaymentBuilder testBuilder = testFactory.createPaymentBuilder(PaymentOption.CREDITCARD);
        assertInstanceOf(CreditCardPaymentBuilder.class,testBuilder);

        // Test creating an apple pay builder
        testBuilder = testFactory.createPaymentBuilder(PaymentOption.APPLEPAY);
        assertInstanceOf(ApplePayPaymentBuilder.class, testBuilder);

        // Test creating a crypto currency builder
        testBuilder = testFactory.createPaymentBuilder(PaymentOption.CRYPTOCURRENCY);
        assertInstanceOf(CryptoCurrencyPaymentBuilder.class, testBuilder);

        assertThrows(NullPointerException.class, () -> testFactory.createPaymentBuilder(null));
    }

}