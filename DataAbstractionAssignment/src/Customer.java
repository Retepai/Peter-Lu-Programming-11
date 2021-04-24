
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>(); //this holds the all the deposit logs
    private ArrayList<Withdraw> withdraws =new ArrayList<>();// this holds all the withdrawal logs
    private double checkBalance; //this is the check balance
    public double getCheckBalance() {
        return checkBalance;
    }
    public double getSavingBalance() {
        return savingBalance;
    }
    private double savingBalance; //this is the savings balance
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //this is the default customer constructor with no parameters (this is the one I will be using for the tests)
    Customer(){
        name="Guest"; //the default name would just be guest since there is no name given
        accountNumber=1; //sets the account number to the default one
        checkBalance=100; // sets the check balance to 100
        savingBalance=200; // sets savings balance to 200

    }

    //this is the customer constructor with parameters and it takes in the customer info through the parameters
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name=name; // the name of the customer would be the name entered upon creation of the customer object
        this.accountNumber=accountNumber;//same with others
        this.checkBalance=checkDeposit;
        this.savingBalance=savingDeposit;
    }
    //Requires:amt>=0
    //Modifies:this,checkbalance,savingBalance
    //Effect:deposits amt into the checking account or the savings account
    public double deposit(double amt, Date date, String account){
        Deposit deposit = new Deposit(amt,date,account);// creates a deposit object from the deposit class with the amt,date and account passed through the parameters
        deposits.add(deposit);// this adds the object object to the deposit arraylist
        if(account.equals(CHECKING)){
            checkBalance+=amt; // if the account selected is checking then the amt would be added to the check balance
        }else{
            savingBalance+=amt; // if the account selected is not checking (savings) then the amt would be added to the saving balance
        }

        return amt;
    }
    //Requires:amt>0
    //Modifies:this,check balance, savings balance
    //Effect:the program will check for overdraft and if it detects none it would proceed to withdraw from the checking or savings account
    public double withdraw(double amt, Date date, String account){

        if(checkOverdraft(amt, account)){ //this uses the check overdraft methode and it will return a boolean
            // if it's true then overdraft is detected
            return 0; // in this case it would just return a zero and not allow the code to proceed
        }else {
            // if the if statement turns out to be false then overdraft is not present and the following code will run
            // this will create a withdrawal object from the withdrawal class with the amt, date and account passed in through parameters
            Withdraw withdraw = new Withdraw(amt, date, account);
            withdraws.add(withdraw); // this adds the withdrawal object to the withdrawal array list
            if(account.equals(CHECKING)){ // if checking is selected then the code below will run
                checkBalance-=amt; // this takes the amt and subtracts it from the checkBalance
            }else{// if the saving account is selected then the code below will run
                savingBalance-=amt;// this takes the amt and subtracts it from the savings balance
            }
            return amt;// the amt withdrawn will be returned
        }

    }
    //Requires:
    //Modifies:
    //Effect: this checks for overdraft for checking and savings account and returns true or false
    private boolean checkOverdraft(double amt, String account){
        if(account.equals(CHECKING)){ // if the account select is checking
            if(checkBalance<amt){
                // if the amt about to be withdrawn is more than the balance in the checking account it would return true since overdraft is detected
                return true;
            }else{
                // otherwise if the amt is not greater than the balance in the account then there is no overdraft so false would be returned
                return false;
            }
        }else{ // if the account selected is savings
            if(savingBalance<amt){
                // if amt withdrawn is bigger than savings balance then it would return true
                return true;
            }else{
                // else if amt is smaller than savings balance it would return false
                return false;
            }
        }

    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}