import com.sun.tools.internal.xjc.runtime.ZeroOneBooleanAdapter;

/**
 *
 * Bank Account.java
 * TCSS 143 - Summer 2019
 * Assignment 4
 * Super class that implements named account and supers saving account
 */

/**
 * This class is implements and run by driver class : AccountTester.java
 * This class is a super class for SavingsAccount.java
 * This class implements NamedAccount.java interface
 * This class makes deposit/withdraw and calculate balance and the interest
 *
 * @author  Adam Shandi
 * @version  July 28 2019
 * @University of Washington
 */
public class BankAccount  implements  NamedAccount{


    /**
     * @field String -myName- stores customer's name
     */
    private  String myName;
    /**
     * @field double myBalance - stores the amount of money in the BankAccount
     */
     private double myBalance;
    /**
     * @field double myInterestRate - stores the interest rate
     */
    private  double myInterestRate;
    /**
     * @field  integer myMonthlyWithdrawCount - stores the number of each withdrawal activity
     *
     */
     protected int myMonthlyWithdrawCount;
    /**
     * @field double myMonthlyServiceCharges - calculate the monthly service charge
     */
    protected double myMonthlyServiceCharges;




    /**
     * Final Constant field of number zero
     */
    private static final int ZERO = 0;

    /**
     * CONSTRUCTOR BankAccount constructor with two parameters
     * @param final double theNameOfOwner - name of owner
     * @param final double the interestRate  interest rate
     */
    public BankAccount(final String theNameOfOwner, final double theInterestRate){

        this.myName = theNameOfOwner;
        this.myInterestRate=theInterestRate;
        this.myBalance=0.0;
        this.myMonthlyServiceCharges=0.0;
        this.myMonthlyWithdrawCount=0;

    }

    /**
     *
     * @return  double getBalance - return the balance of the Bank account
     */
    public double getBalance(){
        return myBalance;
    }

    /**
     *  Deposit into the Bank account
     * @param  final double theAmount - amount to be deposited
     * @return boolean flag if deposit is valid
     */
    public boolean processDeposit(final double theAmount) {
        boolean flag = false;
        if (theAmount <= ZERO) {
            flag = false;
        }
        else{
            myBalance += theAmount;
            flag = true;
        }
        return flag;
    }

    /**
     * Processed withdraw activity in the bank account
     * @param final double theAmount - amount to be withdrawed
     * @return boolean flag if withdrawal processes is valid
     */
    public boolean processWithdrawal(final double theAmount){
        boolean flag;

        if(theAmount <= ZERO || getBalance() < theAmount){
            flag =false ;
        }
        else{
            this.myBalance-=theAmount;
            flag= true;
            myMonthlyWithdrawCount++;
        }
        return flag;
    }

    /**
     * Calculate the interest rate
     * @return double interest rate/12.0 (12 months)
     */
    public double calculateInterest(){
        double interest = myBalance*(myInterestRate/12.0);

        return interest;
    }

    /**
     * Perform monthly processes - service charge/ add interest / checks service count
     *
     * @return void
     */
    public void performMonthlyProcess(){
        this.myBalance-= this.myMonthlyServiceCharges;
        this.myBalance+=this.calculateInterest();
        this.myMonthlyServiceCharges=0;
        this.myMonthlyWithdrawCount=0;

    }

    /**
     *
     * @param  final String received  to set customer name - theNewName
     */
    public void setAccountHolderName(final String theNewName){
        this.myName= theNewName;

    }

    /**
     * Get customer's name
     *
     * @return String customer's  name
     */
    public String getAccountHolderName(){

        return  myName;

    }

    /**
     * a Sting representation of the Bank Object
     * @return String representation for the customer's info
     */
    @Override
    public String toString(){

        String stringFormat= String.format("%.2f", this.myInterestRate);
        String balanceFormat= String.format("%.2f", this.getBalance());
         StringBuilder myStr = new StringBuilder();
        myStr.append(this.getClass().getName()+"[owner: "+this.myName+
                ","+ " balance: "+ balanceFormat+
                ", "+"interest rate "+stringFormat+", \n"+"number of withdrawals this month: "+this.myMonthlyWithdrawCount+
                ", service charge for this month: "+this.myMonthlyServiceCharges);

        return myStr.toString();
    }
}
