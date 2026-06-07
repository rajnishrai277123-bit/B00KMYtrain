import java.util.List;
import java.util.Scanner;

//import static sun.java2d.loops.CustomComponent.register;
//import static sun.security.jgss.GSSUtil.login;


public class IRCTCAPP {
    private final Scanner scanner=new Scanner(System.in);
    private final UserService userService=new UserService();
    private final BookingService bookingService=new BookingService();

    public static void main(String[] args) {
        new IRCTCAPP().start();
    }
    public void start()
    {
        while (true){
            System.out.println(" \n...welcome   to   IRCTC......");
            if(!userService.isloggenIn())
            {
                System.out.println("1. Register:");
                System.out.println("2. login:");
                System.out.println("3. Exit");
                System.out.println("Enter choice");

                int choice=scanner.nextInt();
                //scanner.nextLine();


                switch (choice)
                {
                    case 1-> register();
                    case 2-> login();
                    case 3-> exist();
                    default -> System.out.println("Invalid choice.");
                }
            }
            else {
                showUserMenu();
            }
        }
    }

   // private void exist() {
  //  }

    public void  register()
    {
        System.out.println("Enter username");
        String username=scanner.next();
        System.out.println("Enter password");
        String password=scanner.next();
        System.out.println("Enter full name");
        //scanner.nextInt();
        String fullName=scanner.nextLine();
        System.out.println("Enter contact: ");
        String contact=scanner.next();
        userService.registerUser(username,password,fullName,contact);

    }
    public void login()
    {
        System.out.println("Enter username");
        String username=scanner.next();
        System.out.println("Enter password :");
        String password=scanner.next();
        userService.loginUser(username,password);
    }
    private void  showUserMenu()
    {
        while (userService.isloggenIn())
        {
            System.out.println("\n----user menu---");
            System.out.println("1. search trains");
            System.out.println("2.book ticket");
            System.out.println("3.view my ticket");
            System.out.println("4.cancel ticket");
            System.out.println("5.view all train");
            System.out.println("6.logout");
            System.out.println("enter choice");
            int choice=scanner.nextInt();
            switch (choice)
            {
                case 1 ->searchTrain();
                case 2 ->bookTicket();
                case 3 ->viewMyTicket();
                case 4 ->cancelTicket();
                case 5 ->bookingService.listAllTrains();
                case 6 ->userService.logOutUser();
                default -> System.out.println("Invalid choice");
            }
        }
    }
    private void searchTrain()
    {
        System.out.println("Enter source station");
        String source=scanner.next();
        System.out.println("Enter destination station:");
        String destination=scanner.next();

        List<Train> trains=bookingService.searchTrain(source,destination);
        if(trains.isEmpty())
        {
            System.out.println("no trains found"+source +"and" +destination);
            return;
        }
        System.out.println("trains Found");
        for (Train train:trains)
        {
            System.out.println(train);
        }
        System.out.println("Do you want to book ticket ?(yes/no):");
        String choice=scanner.next();
        if(choice.equalsIgnoreCase("yes"))
        {
            System.out.println("Enter Train Id to book:");
            int trainID=scanner.nextInt();
            System.out.println("Enter number of seats book:");
            int seats=scanner.nextInt();
            Ticket ticket=bookingService.bookTicket(userService.getCurrentUser(),trainID,seats);
            if(ticket!=null){
                System.out.println("Booking successfully!");
                System.out.println(ticket);
            }
        }
        else{
            System.out.println("returning to user menu...");
        }
    }
private void bookTicket(){

    System.out.println("Enter source station");
    String source=scanner.next();
    System.out.println("Enter destination station:");
    String destination=scanner.next();
    List<Train> trains=bookingService.searchTrain(source,destination);
    if(trains.isEmpty())
    {
        System.out.println("no trains available for booking");
        return;
    }
    System.out.println("Available Trains:");
    for (Train train:trains)
    {
        System.out.println(train);
    }
    System.out.println("Enter Train Id to book:");
    int trainID=scanner.nextInt();
    System.out.println("Enter number of seats book:");
    int seats=scanner.nextInt();
    Ticket ticket=bookingService.bookTicket(userService.getCurrentUser(),trainID,seats);
    if(ticket!=null){
        System.out.println("Booking successfully!");
        System.out.println(ticket);
    }
}
private void viewMyTicket()
{
    List<Ticket> ticketByUser=bookingService.getTicketByUser(userService.getCurrentUser());
    if (ticketByUser.isEmpty())
    {
        System.out.println("no ticket booked yet");
    }
    else{
        System.out.println("your tickets:");
        for (Ticket ticket:ticketByUser)
        {
            System.out.println(ticket);
        }
    }
}
private void cancelTicket()
{
    System.out.println("Enter ticket Id to cancel:");
    int ticketID=scanner.nextInt();
    bookingService.cancelTicket(ticketID,userService.getCurrentUser());
}

    private void exist()
    {
        System.out.println("thank you for IRCTCAPP");
        System.exit(0);
    }

}
