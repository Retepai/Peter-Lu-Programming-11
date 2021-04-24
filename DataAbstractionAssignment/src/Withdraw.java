import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    // constructor for the withdrawal object
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //requires:
    //modifies:
    //effects: this returns the withdrawal object parameters
    public String toString(){
        //your code here
        return "Withdraw of:"+" "+"$"+amount+" "+"Date:"+" "+date+" "+"into account:"+" "+account;
    }
}
