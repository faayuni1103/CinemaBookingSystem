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
import java.util.*;

public class Order {
    private Payment payment; // Aggregation
    private String orderId;
    private String status;
    private double amount;
    private Movie[] mov;
    static int count = 0;
    Scanner in = new Scanner(System.in);
		
	public Order()
    {
        orderId = "A200012";
        status = "Paid";
        amount = 0.0;
        payment = new Payment();
        mov = new Movie[10];
    }
		
    public void checkout(Payment pay) // to proceed with checkout and calculate payment
    {
        double p;
        payment = pay;
    
        System.out.print("\nPlease enter payment amount: RM ");
        p = in.nextDouble();

        payment.setValue(amount, p);
        
        if(p>amount)
        {
            System.out.printf("Your balance: RM %.2f\n", payment.getBalance());
            System.out.println("Your balance will be credited to your account!");
            System.out.println("Thank you for using this system!");
        }
        else if (p==amount) {
            System.out.println("Your order is successful!") ;
            System.out.println("Thank you for using this system!");
        }
        else
        {
            System.out.println("You enter the wrong amount! You will be terminated from this program\nThank you!");
            
        }
        System.exit(0);
    }
    
    public void addOrder(Movie m, int t) {
        mov[count] = new Movie(m);
        mov[count].setTicket(t);
        count++;
    }

    public void viewOrder() {
        amount = 0.0;
        System.out.println("These are your tickets: \n\n");
        for(int i=0; i<count; i++) {
            System.out.println("Movie ID        : " + mov[i].getMovieID());
            System.out.println("Title           : " + mov[i].getTitle());
            System.out.println("Quantity        : " + mov[i].getTicket());
            System.out.printf("Price           : RM %.2f\n", mov[i].getPrice());
            System.out.printf("Amount          : RM %.2f\n\n", mov[i].getPrice()*mov[i].getTicket());
            amount += mov[i].getPrice()*mov[i].getTicket();
        }
    }

    // to return the values in the variables		
    public String getId() { return orderId; }
    public String getStatus() { return status; }
    public double getAmount() { return amount; }
}
