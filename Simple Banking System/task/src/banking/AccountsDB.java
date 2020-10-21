package banking;

import java.util.ArrayList;
import java.util.List;

public class AccountsDB {

    List<BankAccount> accounts = new ArrayList<BankAccount>();

    private static int counter = 0;

    public void addAccount(BankAccount bankAccount) {
        this.accounts.add(bankAccount);
        counter++;
    }
}
