package bankAccountApp;

public abstract class account implements IBaseRate {
    // Common properties for savings and checking accounts
    private final String name;
    private final String ssn;
    private double balance;
    protected String accountNumber;
    protected double rate;
    static int index = 10000;

    // Constructor to set the base properties and initialize the account
    public account(String name, String ssn, double initBalance){
        this.name = name;
        this.ssn = ssn;
        this.balance = initBalance;

        // increment the static index to get a unique number
        index++;

        //set account number
        this.accountNumber = setAccountNumber();

        setRate();

    }

    protected abstract void setRate();

    private String setAccountNumber(){
        String lastTwoSSN = ssn.substring(ssn.length()-2);
        int uniqueId = index;
        double randomNum = Math.random() * Math.pow(10, 3);
        return lastTwoSSN + uniqueId + (int)(randomNum);
    }

    public void deposit(double amount){
        this.balance = this.balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toAccount, double amount){
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + toAccount);
        printBalance();
    }

    private void printBalance(){
        System.out.println("Your current balance is $" + this.balance);
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Earned interest is $" + accruedInterest);
        printBalance();
    }

    public void showInfo(){
        System.out.println(
                "Name: " + this.name +
                        "\nAccount Number: " + accountNumber +
                        "\nBalance: " + balance +
                        "\nRate: " + rate + "%"
        );
    }
}
