import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    // constructor for the deposit object
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //requires:
    //modifies:
    //effects: this returns the deposit object parameters
    public String toString(){
        //your code here
        return "Deposit of:"+" "+"$"+amount+" "+"Date:"+" "+date+" "+"into account:"+" "+account;
    }
}