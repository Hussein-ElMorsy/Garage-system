import java.util.ArrayList;
import java.time.LocalTime;

public class BestFit implements ParkIn {
    @Override
    public int parkIn(ArrayList<Slot> slots, Vehicle vehicle) {
        double x = 1000000000;
        double y = 1000000000;
        int ind = -1;
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).getWidth() >= vehicle.getWidth() && slots.get(i).getDepth() >= vehicle.getDepth() && slots.get(i).getStatus() == false) {
                x = Math.min(x, slots.get(i).getWidth());
                y = Math.min(y, slots.get(i).getDepth());
                ind = i;
            }
        }
        if (ind != -1) {
            slots.get(ind).setStatus(true);
            slots.get(ind).setVehicleId(vehicle.getVehicleId());
            slots.get(ind).setArrivingTime(LocalTime.now());
        }
        return  ind;
    }
}