package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class bankAccountApp {
    public static void main(String[] args) {

        List<account> accounts = new LinkedList<account>();
        String file = "./data/NewBankAccounts.csv";

        // read csv file then create new accounts based on that data
        List<String[]> newAccounts = utilities.csvUtilities.read(file);

        for(String[] newAccount : newAccounts){
            String name = newAccount[0];
            String ssn = newAccount[1];
            String accountType = newAccount[2];
            double initDeposit = Double.parseDouble(newAccount[3]);
            System.out.println("Processing bank account for " + newAccount[0]);
            if(accountType.equals("Savings")){
                accounts.add(new savingsAccount(name, ssn, initDeposit));
            } else if(accountType.equals("Checking")){
                accounts.add(new checkingAccount(name, ssn, initDeposit));
            } else {
                System.out.println("Invalid Account type");
            }

        }

        for(account acc: accounts){
            System.out.println("************************");
            acc.showInfo();
        }
        System.out.println("************************");
    }
}
