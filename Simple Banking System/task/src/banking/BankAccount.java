package banking;

import java.util.Random;

public class BankAccount {
    private final String BIN = "400000";

    Random random = new Random();

    String accountNumber;
    int pin;
    double balance;
    boolean logged = false;


    private String accountIdentifier;
    private String checksum = Integer.toString(random.nextInt(9)+1);

    public BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.accountNumber=accountNumberGenerator(BIN);
        bankAccount.pin = generatePin();
        bankAccount.balance=0;
        return bankAccount;
    }

    private String accountNumberGenerator(String BIN) {
        String accountNumber;
        this.accountIdentifier = generateAccIdent();

        accountNumber = BIN + this.accountIdentifier + this.checksum;

        return accountNumber;
    }

    private String generateAccIdent() {
        String accIdent = "";
        for (int i = 0; i < 9; i++) {
            accIdent = accIdent + Integer.toString(random.nextInt(9) + 1);
        }

        return accIdent;
    }
    private int generatePin(){
        String pinString="";
        int pin;
        for (int i = 0; i < 4; i++) {
            pinString = pinString + Integer.toString(random.nextInt(9)+1);
        }
        pin= Integer.parseInt(pinString);

        return pin;
    }
}
