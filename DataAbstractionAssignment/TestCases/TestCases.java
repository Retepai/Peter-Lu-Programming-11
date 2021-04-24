import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCases {
    @Test
    public void testDepositToString() throws ParseException { //this tests the tostring methode in the deposit class
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // this creates a date formatter
        Date date= formatter.parse("04/11/2018"); //the date is created here and values are entered for the date
        Deposit deposit = new Deposit(100,date,"Checking"); // this makes a deposit object in the Deposit class
        assertEquals("Deposit of: $100.0 Date: Sun Nov 04 00:00:00 PDT 2018 into account: Checking",deposit.toString());
        //this assert equals will see if tostring methode returns what's expected, if it does then the test is passed
    }
    @Test
    public void testWithdrawToString() throws ParseException { // this tests the  Withdrawal class's tostring methode
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date= formatter.parse("04/12/2019"); // a date is created here
        Withdraw withdraw = new Withdraw(100, date,"Saving"); // this creates a withdrawal object in the withdraw class
        assertEquals("Withdraw of: $100.0 Date: Wed Dec 04 00:00:00 PST 2019 into account: Saving",withdraw.toString());
        // this assert equals checks to see if the tostring methode returns the expected sentence with the correct spacing/values, if it does the test is passed
    }
    @Test
    public void testCustomerDeposit() throws ParseException { // this tests the deposit methode in the customer class
        Customer customer = new Customer(); //first a customer has to be created for this I used the default constructor
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date= formatter.parse("04/12/2019");// a date then is created
        customer.deposit(100,date,"Checking"); // this creates a deposit in the customer class
        assertEquals(200,customer.getCheckBalance());
        /* this assert equals checks if the check balance in the customer class is updated after the amt has been withdrawn, if it has then that means the
         * deposit methode works and the test will pass*/
    }
    @Test
    public void testCustomerWithdraw() throws ParseException {
        Customer customer = new Customer();// a new customer is created
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date= formatter.parse("04/12/2019");// a date is created
        assertEquals(0,customer.withdraw(500, date,"Saving"));
        // this test will overdraft methode in the customer class, the expected value would be 0 since the withdrawal should not have been made
        customer.withdraw(100,date,"Checking"); // this creates another customer withdrawal but this time there is no overdraft
        assertEquals(0,customer.getCheckBalance());
        // this assert equals checks if the check balance in the customer class is updated after amt has been withdrawn to see if the methode works

    }


}
