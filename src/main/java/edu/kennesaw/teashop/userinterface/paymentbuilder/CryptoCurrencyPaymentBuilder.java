package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.CryptoType;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

// I don't know what kind of fields would be necessary for a crypto wallet, so I am just making it up
public class CryptoCurrencyPaymentBuilder implements IPaymentBuilder{

    private String walletOwnerName;
    private String walletAddress;
    private CryptoType cryptoType;

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

    public void setCryptoType(CryptoType cryptoType) {
        this.cryptoType = cryptoType;
    }

    public CryptoType getCryptoType() {
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

        System.out.print("Select a Crypto Currency Type: ");
        List<CryptoType> cryptoOptions = List.of(CryptoType.values());
        int counter = 1;
        for (CryptoType type : cryptoOptions){
            System.out.println(counter + ". " + type.getDisplayName());
        }

        int userChoice;
        while (true) {
            try {

                System.out.print("Enter an option: ");
                userChoice = scan.nextInt();

                if (userChoice < 1 || userChoice > cryptoOptions.size()) {
                    throw new IndexOutOfBoundsException();
                }
                else{
                    break;
                }

            } catch (Exception e) {
                System.out.println("Please enter a number between 1 and " + cryptoOptions.size());
            }
        }

        setCryptoType(cryptoOptions.get(userChoice - 1)); // subtract 1 from index to account for 0 indexed collection
    }
}
