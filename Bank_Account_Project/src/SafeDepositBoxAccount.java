
/**
 *
 * Bank Account.java
 * TCSS-143 - Summer 2019
 * Assignment 4
 * Create a safe deposit Box for a customer
 * Implement NamedAccount interface to implement the two methods get/set owner name
 * Take a look of BankAccoun.java class for the entire details
 */

 /**
  * @author  Adam Shandi
  * @version  July 28 2019
  * @University of Washington
  * */
public class SafeDepositBoxAccount  implements  NamedAccount{

     /**
      * Private String owner's name
      */
    private String myOwnerName;

     /**
      * CONSTRUCTOR - set the owner's name who they are willing to open a bank box
      *
      * @param  theOwnerName
      */
    public SafeDepositBoxAccount(String theOwnerName){
        this.myOwnerName= theOwnerName;
    }

     /**
      *  Set the Box holder's name
      * @param String  theOwner name
      */
    @Override
    public void setAccountHolderName(String theOwner) {
        this.myOwnerName=theOwner;

    }

     /**
      *
      * @return String account holder name
      */
    @Override
    public String getAccountHolderName(){

        return myOwnerName;
    }

     /**
      *
      * Print a statement that a customer   has requested   to open a box
      * @return Void
      */
    public void createBoxAccount(){
        System.out.println("Creating a safe deposit box account"+getAccountHolderName());

    }

     /**
      * This class implements its own toString() method to print the customer's info if they have a box
      *
      * @return String of the customer's  info
      */
    @Override
    public String toString(){
        StringBuilder myStr = new StringBuilder();
        myStr.append(this.getClass().getName()+ "[owner :"+ this.myOwnerName+"]");
        return myStr.toString();



    }
}
