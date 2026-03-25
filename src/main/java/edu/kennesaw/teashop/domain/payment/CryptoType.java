package edu.kennesaw.teashop.domain.payment;

public enum CryptoType {
    ETHEREUM("Ethereum"),
    BITCOIN("Bitcoin"),
    DOGECOIN("Dogecoin");

    private final  String displayName;

    CryptoType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return this.displayName;
    }
}
