package banking;

public class Options {

    String mmCreateAccount, mmLogIntoAccount, mmExit;
    String inBalance, inLogout, inExit;

    public static void mainMenu(){
        System.out.println("1. Create an account \n2. Log into account\n0. Exit");
    }

    public static void exit(){
        System.exit(0);
    }

    public static void loggedMenu(){
        System.out.println("1. Balance");
        System.out.println("2. Log out");
        System.out.println("0. Exit");
    }

}
