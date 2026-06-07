import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();


    public BookingService() {
        trainList.add(new Train(101, "shuldev express", "ballia", "gaziyabad", 108,17.50,4.30));
        trainList.add(new Train(102, "kapila express", "siwan", "ratsar", 100,13.45,11.20));
        trainList.add(new Train(103, "rajdhani express", "amadariya", "srilanka", 98,14.20,3.20));
        trainList.add(new Train(104, "teju express", "chatwa", "anandvihar", 19,11.07,15.11));
        trainList.add(new Train(105, "harshit express", "ghazipur", "chandani chok", 78,14.34,18.34));
        trainList.add(new Train(106, "kali express", "ballia", "mumbai", 68,14.35,11.00));
        trainList.add(new Train(107, "sadbhawna express", "gorkhpur", "delhi", 58,11.00,12.00));
        trainList.add(new Train(108, "new delhi express", "patna", "pakistan", 88,11.00,15.23));
        trainList.add(new Train(109, "rajnish express", "patna", "kanpur central", 68,12.00,11.00));

    }

    public List<Train> searchTrain(String source, String destination) {
        List<Train> res = new ArrayList<>();
        for (Train train : trainList) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)) {
                res.add(train);
            }
        }
        return res;
    }

    public Ticket bookTicket(User user, int trainId, int seatCount) {
        for (Train train : trainList) {
            if (train.getTrainId() == trainId) {
                if (train.bookSeats(seatCount)) {
                    Ticket ticket = new Ticket(user, train, seatCount);
                    ticketList.add(ticket);
                    return ticket;
                } else {
                    System.out.println("no enough seat available");
                    return null;
                }
            }
        }
        System.out.println("train id not found");
        return null;
    }
    public List<Ticket> getTicketByUser(User user)
    {
        List<Ticket> res=new ArrayList<>();
        for (Ticket ticket:ticketList)
        {
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                res.add(ticket);
            }
        }
        return res;
    }
    public boolean cancelTicket(int ticketId,User user)
    {
        Iterator<Ticket> iterator=ticketList.listIterator();
        while (iterator.hasNext()){
            Ticket ticket=iterator.next();
            if (ticket.getTicketId()==ticketId &&
            ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                Train train=ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket"+ticketId +"cancel successfully");
                return true;
            }
        }
        System.out.println("ticket not found or does not belong to current user");
        return false;
    }
    public void listAllTrains()
    {
        System.out.println("list of all trains");
        for (Train train:trainList)
        {
            System.out.println(train);
        }
    }
}



