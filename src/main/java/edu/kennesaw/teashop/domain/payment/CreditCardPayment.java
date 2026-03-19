package edu.kennesaw.teashop.domain.payment;

import java.math.BigDecimal;
import java.time.YearMonth;

public class CreditCardPayment extends PaymentStrategyBase {

    private String cardName;
    private String cardNumber;
    private String securityCode;
    private YearMonth expiration;


    public CreditCardPayment(BigDecimal amount, String cardName, String cardNumber, String securityCode, YearMonth expiration){
        super(amount);
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
    public void pay() {
        // code to implement paying with a credit card
    }
}
