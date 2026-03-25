package edu.kennesaw.teashop.domain.payment;

import edu.kennesaw.teashop.domain.inventoryquery.QueriedInventoryItem;

import java.math.BigDecimal;
import java.time.YearMonth;

public class CreditCardPayment extends PaymentStrategyBase {

    private String cardName;
    private String cardNumber;
    private String securityCode;
    private YearMonth expiration;


    public CreditCardPayment(BigDecimal amount,int quantityToPurchase, String cardName, String cardNumber, String securityCode, YearMonth expiration){
        super(amount , quantityToPurchase);
        setCardName(cardName);
        setCardNumber(cardNumber);
        setSecurityCode(securityCode);
        setExpiration(expiration);
    }

    public String getCardName(){
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode(){
        return securityCode;
    }

    public void setSecurityCode(String securityCode){
        this.securityCode = securityCode;
    }

    public YearMonth getExpiration(){
        return expiration;
    }

    public void setExpiration(YearMonth expiration) {
        this.expiration = expiration;
    }


    @Override
    public void pay(QueriedInventoryItem item) {
       System.out.println("*** Purchase complete. Your " +  quantityToPurchase + " " + item.getName() + " packages " +
               "for $" + amount.toPlainString() + " using the card with number " + getCardNumber() + " is on the way ***");
    }
}
