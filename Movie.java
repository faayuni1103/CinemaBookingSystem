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

public class Movie {
    private String title;
    private int movieid;
    private double price;
    private int ticket;

    public Movie() {}
    public Movie(String title, int id, double p) {
        this.title = title;
        this.movieid = id;
        this.price = p;
    }
    public Movie(Movie m) {
        this.title = m.title;
        this.movieid = m.movieid;
        this.price = m.price;
    }

    public void setTicket(int s) { this.ticket = s; }
    public String getTitle() { return title; }
    public int getMovieID() { return movieid; }
    public double getPrice() { return price; }
    public int getTicket() { return ticket; }

    public void displayMovie() {
        System.out.print("  " + movieid + "       ");
        System.out.print("   " + title);
        System.out.printf("  %.2f\n", price);
    }
}
