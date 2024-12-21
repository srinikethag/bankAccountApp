package bankAccountApp;

public interface IBaseRate {

    // method to define the base rate
    default double getBaseRate(){
        return 2.5;
    }
}
