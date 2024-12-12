/* Group 1
 * Members:
 * - Fatin Aimi Ayuni Binti Affindy
 * - Bilkis Musa
 * - Rehnuma Tahsin
 * 
 * MESSAGE TO USER:
 * - Please refer to the login method in Customer class to enter as a member
 * 
 */

package CinemaSystem;

public class Payment {
    private double pay;
    private double amount;
    private double balance;
    public void setValue(double a, double p) // to set the values inside the variables
    {
        amount = a;
        pay = p;
        balance = p - a;
    }
		
    // to return the values in the variables
    public double getAmount() { return amount; }
    public double getPay() { return pay; }
    public double getBalance() { return balance; }
}
