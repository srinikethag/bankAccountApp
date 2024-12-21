package bankAccountApp;

public class savingsAccount extends account{
    // List properties specific to savings account
    private int safetyDepositBoxId;
    private int getSafetyDepositBoxKey;

    // constructor to initialize settings for the savings properties
    public savingsAccount(String name, String ssn, double initDeposit){
        super(name, ssn, initDeposit);
        this.accountNumber = '1' + this.accountNumber;
        setSafetyDepositBox();
    }

    @Override
    protected void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxId = (int)(Math.random() * Math.pow(10, 3));
        getSafetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
    }

    // List methods specific to saving account
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Account Type: SAVINGS");
        System.out.println("Your savings account features: " +
                "\n - Safety Deposit box Id: "+ safetyDepositBoxId +
                "\n - Safety deposit box key: "+ getSafetyDepositBoxKey);
    }


}
