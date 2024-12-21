package bankAccountApp;

public class checkingAccount extends account{
    // List properties specific to checking account
    private int debitCardNumber;
    private int debitCardPin;

    // constructor to initialize settings for the checking properties
    public checkingAccount(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        this.accountNumber = '2' + this.accountNumber;
        setDebitCardNumber();
    }

    @Override
    protected void setRate(){
        rate = getBaseRate() * 0.15;
    }

    private void setDebitCardNumber(){
        debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
        debitCardPin = (int)(Math.random() * Math.pow(10, 4));
    }

    // List methods specific to checking account
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Account Type: CHECKING");
        System.out.println("Your Checking account features: " +
                "\n - Debit Card Number: "+ debitCardNumber +
                "\n - Debit Card Pin: "+ debitCardPin);
    }
}
