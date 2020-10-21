package banking;

import java.util.Random;

public class BankAccount {
    private final String BIN = "400000";

    Random random = new Random();

    String accountNumber;
    int pin;
    double balance;


    private String accountIdentifier;
    private String checksum;

    public BankAccount() {
        this.accountNumber = accountNumberGenerator(BIN);
        this.pin = generatePin();
        this.balance = 0;
    }

    private String accountNumberGenerator(String BIN) {
        String accountNumber;
        this.accountIdentifier = generateAccIdent();

        accountNumber = BIN + this.accountIdentifier + checkSum(BIN, this.accountIdentifier);

        return accountNumber;
    }

    private String generateAccIdent() {
        String accIdent = "";
        for (int i = 0; i < 9; i++) {
            accIdent = accIdent + Integer.toString(random.nextInt(9) + 1);
        }

        return accIdent;
    }

    private int generatePin() {
        String pinString = "";
        int pin;
        for (int i = 0; i < 4; i++) {
            pinString = pinString + Integer.toString(random.nextInt(9) + 1);
        }
        pin = Integer.parseInt(pinString);

        return pin;
    }

    private String checkSum(String BIN, String accountIdentifier) {
        int sum=0;
        int checkSum=0;
        String number = BIN + accountIdentifier;
        String[] numberStringArr = number.split("");

        int[] numberIntArr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            numberIntArr[i]=Integer.parseInt((numberStringArr[i]));
        }

        //Luhn algorithm
        for (int i = 0; i < numberIntArr.length; i++) {

            if(i==0 || i%2==0){
                numberIntArr[i]=numberIntArr[i]*2;
                if (numberIntArr[i]>9){
                    numberIntArr[i]=numberIntArr[i]-9;
                }
            }

        }

        //sum of digits
        for (int i = 0; i < numberIntArr.length; i++) {
            sum=sum+numberIntArr[i];
        }

        while (true){
            if((sum+checkSum)%10==0){
                break;
            }else{
                checkSum++;
            }
        }

        this.checksum=Integer.toString(checkSum);
        return this.checksum;
    }
}
