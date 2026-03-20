package edu.kennesaw.teashop.domain.payment;

public enum PaymentOption {
    CREDITCARD("Credit Card"),
    APPLEPAY("Apple Pay"),
    CRYPTOCURRENCY("Crypto Currency");

    private final String displayString;

    PaymentOption(String displayString){
        this.displayString = displayString;
    }

    public String getDisplayString(){
        return displayString;
    }
}
