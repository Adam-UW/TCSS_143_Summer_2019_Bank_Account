
/**
 *
 * Bank Account.java
 * TCSS-143 - Summer 2019
 * Assignment 4
 * Subclass for BankAccount.java
 */

/**
 * This class is a subclass of BankAccount.java super class: AccountTester.java
 * The class do different implementations similar to the bankaccount class
 * This class  sets a new  boolean filed myStatusActivity - which shall be true when balance greater than 25$
 * This class makes deposit/withdraw and calculate balance as the BankAccount.java does
 *
 * @author  Adam Shandi
 * @version  July 28 2019
 * @university of Washington
 */
public class SavingsAccount extends  BankAccount{

    /** Private boolean field myStatusIsActive - false by default*/
    private boolean myStatusIsActive;
    /** final int filed of number 25**/
    private static final int TWENTY_FIVE_NUMBER=25;
    /** final int filed of number 5 **/
    private static final int FIVE =5;

    /**
     *
     * CONSTRUCTOR - SavingsAccount constructor that takes two arguments
     *
     * @param final String name of the owner - theOwnerName
     * @param theInterestRate  double - the interest rate
     */
    public SavingsAccount(final String theOwnerName, final double theInterestRate){
        super(theOwnerName, theInterestRate);
       if(getBalance()<25){
           this.myStatusIsActive=false;
       }
    }

    /**
     *
     * Processes deposit into saving account
     * @param double the amount of money to be deposited - theAmount
     * @return boolean flag true or false depends on the deposit activity
     */
    @Override
    public boolean processDeposit(final double theAmount){
        boolean flag=super.processDeposit(theAmount);

        if(getBalance()>TWENTY_FIVE_NUMBER){
            this.myStatusIsActive=true;
        }
        return flag;

    }

    /**
     *
     * Processes   withdrawal into saving account
     * @param doouble theAmount of money to be withdrawed
     * @return boolean flag true or false depends on the on  the withdrawal   processes
     */
    @Override
    public boolean processWithdrawal(final double theAmount) {
        boolean flag=false;
        if (this.myStatusIsActive) {
             flag = super.processWithdrawal(theAmount);


            if  (myMonthlyWithdrawCount >= 5) {
                myMonthlyServiceCharges++;
        }
             if (getBalance() < TWENTY_FIVE_NUMBER) {
              this.myStatusIsActive = false;
            }

         }
        return flag;
    }

    /**
     *
     * Perform the monthly Processes
     * @super BankAccount.Java
     * See the BankAccount class for the details
     * @return void
     */
    public void performMonthlyProcess( ){
        super.performMonthlyProcess();
        if(getBalance() >= TWENTY_FIVE_NUMBER) {
            this.myStatusIsActive = true;
        }
        else{
            this.myStatusIsActive=false;
        }
    }

    /**
     * @super toString() method in the bacnkAccount class
     * see BankAccount.java class for the detailed information
     * @return String info for the customer the SavingsAccount class objecet
     */
    @Override
    public String toString(){
        return super.toString()+", myStatusIsActive: "+this.myStatusIsActive;



    }








}
