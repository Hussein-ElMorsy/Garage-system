import java.time.LocalTime;
import java.util.ArrayList;

public class FirstServe implements ParkIn {
    @Override
    public int parkIn(ArrayList<Slot> slots, Vehicle vehicle) {
        int ind = -1;
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).getWidth() >= vehicle.getWidth() &&
                    slots.get(i).getDepth() >= vehicle.getDepth() &&
                    slots.get(i).getStatus() == false) {
                ind = i;
                break;
            }
        }
        if (ind != -1) {
            slots.get(ind).setStatus(true);
            slots.get(ind).setVehicleId(vehicle.getVehicleId());
            slots.get(ind).setArrivingTime(LocalTime.now());
        }
        return ind;
    }
}