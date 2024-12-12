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
import java.util.Vector;
import javax.swing.JOptionPane;

abstract class Customer { // Abstraction
    protected Order order = new Order(); // Composition
    protected String name;
    protected String address;
    protected String email;
    protected String phone;

    public void setName(String n) { this.name = n; }
    public void setAddress(String a) { this.address = a; }
    public void setEmail(String e) { this.email = e; }
    public void setPhone(String p) { this.phone = p; }
    public void addOrder(Movie m, int t) {order.addOrder(m, t);}
    public void viewOrder() {order.viewOrder();}
    public void checkOut(Payment p) { order.checkout(p); }
    public double getAmount() { return order.getAmount(); }

    public abstract void login(); // Polymorphism 
    public abstract void displayInfo(); // Polymorphism
}

class Member extends Customer{ // Inheritance
    private String username;
    private String password;

    public Member(){}

    public Member(String username, String password, String name, String address, String email, String phone){
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    
    public void setUsername(String u) { this.username = u; }
    public void setPassword(String ps) { this.password = ps; }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    

    public void login() {
        Member[] mem = {
            new Member("Alili", "Ali1234", "Ali Bin Zakaria",
                        "Kajang, Selangor", "Alili@gmail.com", "0114578193"),

            new Member("Abubo", "Abu5678", "Abu Bin Zulkifli",
                        "Senai, Johor", "Abubo@gmail.com", "0163988872"),

            new Member("Lunaeo", "Luna3456", "Luna Swift",
                        "Kuala Lumpur", "Lunaeo@gmail.com",  "0163321974")
        };

        String u = JOptionPane.showInputDialog("Please enter the following details: \n Username: ");
        String pass = JOptionPane.showInputDialog("Password: ");            
        
        if((u.equals(mem[0].username)) && (pass.equals(mem[0].password))){
            JOptionPane.showMessageDialog(null,"Login Successful");
            setName(mem[0].name);
            setAddress(mem[0].address);
            setEmail(mem[0].email);
            setPhone(mem[0].phone);
            setUsername(mem[0].username);
            setPassword(mem[0].password);
            displayInfo();
        }
        else if((u.equals(mem[1].username)) && (pass.equals(mem[1].password))){
            JOptionPane.showMessageDialog(null,"Login Successful");
            setName(mem[1].name);
            setAddress(mem[1].address);
            setEmail(mem[1].email);
            setPhone(mem[1].phone);
            setUsername(mem[1].username);
            setPassword(mem[1].password);
            displayInfo();
        }
        else if((u.equals(mem[2].username)) && (pass.equals(mem[2].password))){
            JOptionPane.showMessageDialog(null,"Login Successful");
            setName(mem[2].name);
            setAddress(mem[2].address);
            setEmail(mem[2].email);
            setPhone(mem[2].phone);
            setUsername(mem[2].username);
            setPassword(mem[2].password);
            displayInfo();
        } 
        else{
            throw new ArithmeticException("Login failed! Please try again next time!"); //exception
        }   
            
    }

    public void displayInfo(){
        JOptionPane.showMessageDialog(null,"The following are your details\nName: "
                                      + name+"\nAddress: "+address+"\nEmail: "+email+"\nPhone: "+phone); 
    }
}

class NonMember extends Customer{ // Inheritance
    public void login(){
        JOptionPane.showMessageDialog(null,"Please enter the following details");
        setName(JOptionPane.showInputDialog("Name: "));
        setAddress(JOptionPane.showInputDialog("Address: "));
        setEmail(JOptionPane.showInputDialog("Email: ")); 
        setPhone(JOptionPane.showInputDialog("Phone no: ")); 
        displayInfo();
    }

    public void displayInfo(){
        JOptionPane.showMessageDialog(null,"The following are your details\nName: "
                                      + name+"\nAddress: "+address+"\nEmail: "+email+"\nPhone: "+phone); 
    }
}

