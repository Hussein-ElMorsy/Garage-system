import java.time.LocalTime;

public class Slot {
    private double depth;
    private double width;
    private boolean status;
    private int vehicleId;
    private LocalTime arrivingTime;
    private LocalTime departureTime;


    //default constructor
    Slot() {
        this.status = false;
        this.depth = 0.0;
        this.width = 0.0;
    }

    //parameterized constructor
    Slot(double depth, double width) {
        this.status = false;
        this.depth = depth;
        this.width = width;
    }

    /// setters
    void setStatus(boolean status) {
        this.status = status;
    }

    void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setArrivingTime(LocalTime arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivingTime() {
        return arrivingTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }
    ///getters
    double getDepth() {
        return this.depth;
    }

    double getWidth() {
        return this.width;
    }

    boolean getStatus() {
        return this.status;
    }

    int getVehicleId() {
        return this.vehicleId;
    }

}
