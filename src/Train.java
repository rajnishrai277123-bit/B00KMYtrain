public class Train {
    private int trainId;
    private String name;
    private String source;
    private String destination;
    private int totalSeats;
    private  int availableSeats;
    private double departureTime;
    private double arrivalTime;



    public Train(int trainId , String name , String source, String destination, int totalSeats,double departureTime,double arrivalTime) {
        this.trainId = trainId;
        this.name =name;
        this.source=source;
        this.destination=destination;
        this.totalSeats=totalSeats;
        this.availableSeats=totalSeats;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;

    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(double departureTime) {
        this.departureTime = departureTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean bookSeats(int count)
    {
        if (count<=availableSeats){
            availableSeats-=count;
        }
        return false;
    }
    public void cancelSeats(int count){
        availableSeats+=count;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }


}