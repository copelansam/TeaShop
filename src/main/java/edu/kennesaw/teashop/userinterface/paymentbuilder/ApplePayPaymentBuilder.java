package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.domain.payment.ApplePayPayment;
import edu.kennesaw.teashop.domain.payment.PaymentStrategyBase;
import edu.kennesaw.teashop.util.ScannerSingleton;

import java.math.BigDecimal;
import java.util.Scanner;

// I don't know what sort of fields would be necessary for a real ApplePay application, so I am just making it up.
public class ApplePayPaymentBuilder implements IPaymentBuilder{

    private String walletOwnerName;
    private String deviceId;
    private String applePayToken;


    public void setWalletOwnerName(String walletOwnerName) {
        this.walletOwnerName = walletOwnerName;
    }

    public String getWalletOwnerName(){
        return walletOwnerName;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setApplePayToken(String applePayToken) {
        this.applePayToken = applePayToken;
    }

    public String getApplePayToken() {
        return applePayToken;
    }

    @Override
    public void collectInfo() {
        Scanner scan = ScannerSingleton.getInstance();

        System.out.print("Enter the name of the Apple Wallet Owner: ");
        setWalletOwnerName(scan.nextLine());

        while (true) {
            System.out.print("Enter the device ID (series of 10 characters): ");
            String deviceInput = scan.nextLine();
            if ( deviceInput.length() != 10){
                System.out.println("The device ID should be 10 characters long. Try Again");
            }
            else{
                setDeviceId(deviceInput);
                break;
            }
        }

        while (true) {
            System.out.print("Enter the ApplePayToken (series of 10 characters): ");
            String tokenInput = scan.nextLine();

            if (tokenInput.length() != 10){
                System.out.println("The wallet token should be 10 characters. Try again.");
            }
            else{
                setApplePayToken(tokenInput);
                break;
            }
        }
    }

    // Creates apple pay payment
    public PaymentStrategyBase buildPayment(BigDecimal amount, int quantityToPurchase){

        return new ApplePayPayment(amount, quantityToPurchase, walletOwnerName, deviceId, applePayToken);

    }
}
