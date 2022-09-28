import java.time.LocalTime;
import java.util.ArrayList;

public class Garage {
    public ArrayList<Slot> slots = new ArrayList<Slot>();
    private final int size;
    private final Form form;
    private ParkIn park;
    TotalFeesCalculator feesCalc;
    TotalIncomeCalculator incomeCalc;

    //Default constructor
    Garage() {
        this.form = new Form();
        this.feesCalc = new TotalFeesCalculator();
        this.incomeCalc = new TotalIncomeCalculator();
        this.size = form.integer("Enter number of slots: ");
        form.Msg("============| ENTER THE SLOTS INFO |===============");
        for (int i = 0; i < this.size; i++) {
            form.Msg(">> Please Enter the size of Slot no. " + (i + 1));
            double width = form.Double(">> Please enter the Width: ");
            double depth = form.Double(">> Please enter the Depth: ");
            Slot s = new Slot(depth, width);
            slots.add(s);
        }
        this.selectSlotConfiguration();
    }

    //park-Out function
    public void parkOut() {
//        Slot parkedOut = new Slot();
        int vehicleId = this.form.integer("Enter your vehicle ID: ");
        boolean done = false;
        for (int i = 0; i < this.size; i++) {
            if (slots.get(i).getVehicleId() == vehicleId) {
                slots.get(i).setVehicleId(0);
                slots.get(i).setStatus(false);
                slots.get(i).setDepartureTime(LocalTime.now());
//                parkedOut = slots.get(i);
                double fees = feesCalc.calculation(slots.get(i).getArrivingTime(), slots.get(i).getDepartureTime());
                form.Msg("Total fees: " + fees);
                this.incomeCalc.add(fees);
                done = true;
                break;
            }
        }
        if (!done) form.Msg("No vehicle parked with such ID");

//        return parkedOut;
    }

    public void showTotalIncome() {
        this.form.Msg("Total number of vehicles: " + this.incomeCalc.getCarCounter());
        this.form.Msg("Total income " + this.incomeCalc.getResult());
    }

    public void showAvailableSlot() {
        for (int i = 0; i < this.size; i++) {
            if (slots.get(i).getStatus() == false) {
                form.Msg("=================| SLOTS INFORMATION |====================");
                form.Msg("| Slot Number " + i + " is Available");
                form.Msg("| Slot's Width = " + slots.get(i).getWidth());
                form.Msg("| Slot's Depth = " + slots.get(i).getDepth());
                form.Msg("=========================================================");
            }
        }

    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void selectSlotConfiguration() {
        form.Msg("Select slot configuration:\n1.FIRST come first served\n2.Best fit approach");
        int choice = form.integer("Select a slot configuration: ");
        if (choice == 1) {
            park = new FirstServe();
        }
        if (choice == 2) {
            park = new BestFit();
        }
    }

    public void parkIn() {
        Vehicle vehicle = new Vehicle(form.Double("Enter depth of the vehicle"),
                form.Double("Enter width of the vehicle"),
                form.word("Enter model name:"),
                form.integer("Enter model year:"));
        this.form.Msg("Your vehicle ID: " + vehicle.getVehicleId());
        int slotId = park.parkIn(slots, vehicle);
        if (slotId == -1) {
            this.form.Msg("There is no available slot");
        } else {
            this.form.Msg("Parked at slot " + slotId);
            this.incomeCalc.incrementCarCounter();
        }

    }

    public void start() {
        while (true) {
            int choice = this.form.menu();
            switch (choice) {
                case 1 -> {
                    this.parkIn();
                }
                case 2 -> {
                    this.parkOut();
                }
                case 3 -> {
                    this.showAvailableSlot();
                }
                case 4 -> {
                    this.showTotalIncome();
                }
                default -> {

                }
            }
        }
    }
}

