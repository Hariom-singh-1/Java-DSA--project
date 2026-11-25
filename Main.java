
import java.util.*;

class Ticket {
    int id;
    String name, issue;

    Ticket(int id, String name, String issue) {
        this.id = id;
        this.name = name;
        this.issue = issue;
    }

    void display() {
        System.out.println("  Ticket ID : " + id);
        System.out.println("  Customer  : " + name);
        System.out.println("  Issue     : " + issue);
        System.out.println("  Status    : Waiting");
        System.out.println("  --------------------------");
    }
}

public class Main {
    static Queue<Ticket> q = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    static int id = 101;

    static void line() {
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        int choice;

        do {
            line();
            System.out.println("       SIMPLE TICKET QUEUE SYSTEM");
            line();
            System.out.println("  1. Add New Ticket");
            System.out.println("  2. Process Ticket");
            System.out.println("  3. Display All Tickets");
            System.out.println("  4. Count Pending Tickets");
            System.out.println("  5. Exit");
            line();
            System.out.print("  Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("  Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("  Enter Issue: ");
                    String issue = sc.nextLine();

                    q.add(new Ticket(id++, name, issue));
                    System.out.println("\n  Ticket Added Successfully!");
                    break;

                case 2:
                    if (q.isEmpty()) {
                        System.out.println("  No Pending Tickets!");
                    } else {
                        Ticket t = q.poll();
                        System.out.println("\n  TICKET PROCESSED SUCCESSFULLY");
                        t.display();
                    }
                    break;

                case 3:
                    if (q.isEmpty()) {
                        System.out.println("  Queue is Empty!");
                    } else {
                        System.out.println("\n       PENDING TICKETS");
                        for (Ticket t : q) {
                            t.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("  Pending Tickets: " + q.size());
                    break;

                case 5:
                    System.out.println("\n  Thank You for Using Our System!");
                    break;

                default:
                    System.out.println("  Invalid Choice! Try Again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
