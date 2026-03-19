package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.util.ScannerSingleton;

import java.util.Scanner;

// I don't know what kind of fields would be necessary for a crypto wallet, so I am just making it up
public class CryptoCurrencyPaymentBuilder implements IPaymentBuilder{

    private String walletOwnerName;
    private String walletAddress;
    private String cryptoType;

    public void setWalletOwnerName(String walletOwnerName) {
        this.walletOwnerName = walletOwnerName;
    }

    public String getWalletOwnerName() {
        return walletOwnerName;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setCryptoType(String cryptoType) {
        this.cryptoType = cryptoType;
    }

    public String getCryptoType() {
        return cryptoType;
    }

    @Override
    public void collectInfo() {
        Scanner scan = ScannerSingleton.getInstance();

        System.out.print("Enter the name of the owner of the crypto wallet: ");
        setWalletOwnerName(scan.nextLine());

        while (true) {

            System.out.print("Enter the wallet address (series of 10 characters): ");
            String addressInput = scan.nextLine();

            if (addressInput.length() != 10){

                System.out.println("The wallet address must be 10 characters. Try again.");
            }
            else{

                setWalletAddress(addressInput);
                break;
            }
        }

        System.out.print("Enter the crypto currency type (Bitcoin, Etherium, Dogecoin, etc.): ");
        setCryptoType(scan.nextLine());
    }
}
