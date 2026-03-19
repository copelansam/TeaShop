package edu.kennesaw.teashop.userinterface.paymentbuilder;

import edu.kennesaw.teashop.util.ScannerSingleton;

import java.time.YearMonth;
import java.util.Scanner;

// I'm allowing users to input anything into the cardNumber and securityCode fields.
// For this test project, it isn't important enough to implement proper checks
public class CreditCardPaymentBuilder implements IPaymentBuilder{

    private String cardName;
    private String cardNumber;
    private String securityCode;
    private YearMonth expiration;

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

    public void setExpiration(int year, int month) {
        this.expiration = YearMonth.of(year, month);
    }

    @Override
    public void collectInfo(){
        Scanner scan = ScannerSingleton.getInstance();

        System.out.print("Enter the name on your credit card: ");
        setCardName(scan.nextLine());

        System.out.print("Enter the number on your credit card: ");
        setCardNumber(scan.nextLine());

        System.out.print("Enter the security code on the back of your credit card: ");
        setSecurityCode(scan.nextLine());

        int expirationMonth;
        while(true) {

            System.out.print("Enter the expiration month of your credit card: ");

            try {
                expirationMonth = Integer.parseInt(scan.nextLine());
                if (expirationMonth < 1 || expirationMonth > 12) {
                    System.out.println("Expiration month must be between 1 and 12. Try again");
                } else {
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input. Try again.");
            }
        }

        int expirationYear;
        while(true) {

            System.out.print("Enter the expiration year of your credit card: ");

            try {
                expirationYear = Integer.parseInt(scan.nextLine());

                if (expirationYear < YearMonth.now().getYear()) {
                    System.out.println("Expiration year cannot be in the past. Try again.");
                } else {
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input. Try Again");
            }

        }
        setExpiration(expirationYear,expirationMonth);
    }
}
