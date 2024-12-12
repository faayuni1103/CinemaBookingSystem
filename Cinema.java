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
import javax.swing.JOptionPane;
import java.util.*;

public class Cinema {
    static Scanner in = new Scanner(System.in);
    public static void welcome() {
        System.out.println("\n------------------------------------");
        System.out.println("    CINEMA TICKET BOOKING SYSTEM    ");
        System.out.println("------------------------------------\n");
    }

    public static int menu() {
        int c;
        welcome();
        System.out.println("[1] Choose Movie");
        System.out.println("[2] View Order");
        System.out.println("[3] Checkout");
        System.out.println("[4] Exit");
        System.out.print("\nEnter your choice: ");
        c = in.nextInt();
        return c;
    }

    public static void chooseMovie(Movie[] movie, Customer c, Payment p) {
        int choice, id, tx;
        Movie temp;
        do {
            do {
                choice = menu();

                switch(choice) {
                    case 1:
                        System.out.println("\nMovie ID       "
                            + "Title                    "
                            + "Price(RM)");
                        for(int i=0; i<10; i++)
                            movie[i].displayMovie();
                        
                        System.out.print("\nEnter movie ID you chose: ");
                        id = in.nextInt();
                        System.out.print("The number of tickets: ");
                        tx = in.nextInt();
                        for(int i=0; i<10; i++) {
                            if(id == movie[i].getMovieID()) {
                                temp = new Movie(movie[i]);
                                c.addOrder(temp, tx);
                            }
                        }
                        break;

                    case 2:
                        c.viewOrder();
                        break;

                    case 3:
                        c.viewOrder();
                        System.out.printf("\nTotal           : RM %.2f\n", c.getAmount());
                        c.checkOut(p);
                        break;

                    case 4:
                        System.out.println("Thank you for using this system!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid input. Please enter your choice again.");
                        break;
                }
            } while(choice != 1 && choice != 2 && choice != 3 && choice != 4);
        } while(choice != 4);
    }

    public static void main(String [] args) {
        Payment pay = new Payment(); 
        Customer c;
        Movie[] movie = {
            new Movie("Secret Life of Pet\t", 142, 13.00),
            new Movie("Upin & Ipin\t\t", 134, 14.00),
            new Movie("Minion\t\t\t", 534, 15.00),
            new Movie("Zootopia\t\t\t", 123, 12.00),
            new Movie("Thor\t\t\t", 256, 13.00),
            new Movie("Agen Ali\t\t\t", 578, 15.00),
            new Movie("The Suicide Squad\t", 542, 12.00),
            new Movie("Angel Has Fallen\t\t", 764, 13.00),
            new Movie("Descendents\t\t", 431, 13.00),
            new Movie("Jumanji\t\t\t", 221, 15.00)
        };

        JOptionPane.showMessageDialog(null, ">> WELCOME TO CINEMA BOOKING SYSTEM <<\nYou are?\n[1] Member\n[2] Non Member\n");
        String choice;
        choice = JOptionPane.showInputDialog("Enter your choice: ");
        int ch = Integer.parseInt(choice); // Wrapper
        if(ch == 1) {
            c = new Member();
            c.login();
            chooseMovie(movie, c, pay);
        }
        else if(ch == 2) {
            c = new NonMember();
            c.login();
            chooseMovie(movie, c, pay);
        }
        else 
            JOptionPane.showMessageDialog(null,"Please choose [1] or [2] only");
        
    }
}