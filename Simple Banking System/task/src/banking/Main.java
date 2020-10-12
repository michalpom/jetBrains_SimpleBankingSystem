package banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AccountsDB accountsDB = new AccountsDB();
        boolean logged = false;

        while (true) {
            Options.mainMenu();
            String input = scanner.nextLine();
            int position = 0;
            if (Integer.parseInt(input) == 1) {
                BankAccount bankAccount = new BankAccount();
                accountsDB.addAccount(bankAccount);
                System.out.println("Your card has been created");
                System.out.println("Your card number:");
                System.out.println(bankAccount.accountNumber);
                System.out.println("Your card PIN:");
                System.out.println(bankAccount.pin);
            } else if (Integer.parseInt(input) == 2) {
                System.out.println("Enter your card number:");
                input = scanner.nextLine();
                boolean validAccNumber = false;
                for (int i = 0; i < accountsDB.accounts.size(); i++) {
                    if (input.equals(accountsDB.accounts.get(i).accountNumber)) {
                        position = i;

                        validAccNumber = true;
                        break;
                    }
                }
                System.out.println("Enter your PIN:");
                input = scanner.nextLine();
                if (accountsDB.accounts.get(position).pin == Integer.parseInt(input) && (validAccNumber==true)) {
                    logged = true;

                } else
                    System.out.println("Wrong card number or PIN!");

            } else if (Integer.parseInt(input) == 0) {
                Options.exit();
            }

            if (logged == true) {
                System.out.println("You have successfully logged in!");
                while (true) {
                    Options.loggedMenu();
                    input = scanner.nextLine();
                    if (Integer.parseInt(input) == 1) {
                        System.out.println("Balance: " + accountsDB.accounts.get(position).balance);
                    } else if (Integer.parseInt(input) == 2) {
                        logged = false;
                        System.out.println("You have successfully logged out!");
                        break;
                    } else if (Integer.parseInt(input) == 0) {
                        Options.exit();
                    }
                }

            }
        }
    }
}