
/**
 *
 * Bank Account.java
 * TCSS 143 - Summer 2019
 * Assignment 4
 * Named account interface
 */

/**
 * @return void  abstract method to set the customer's name
 * @return Steing of the account holder name
 * @author  Adam Shandi
 * @version  July 28 2019
 * @University of Washington
 */
public interface NamedAccount {
     /**
      *
      * @param Abstract method must be implemented by the inherited class -String theNewName of the customer's name
      */
     void setAccountHolderName(final String theNewName);

     /**
      *
      * @return String the account holder name
      */
     String getAccountHolderName();


}
