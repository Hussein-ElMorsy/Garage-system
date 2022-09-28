import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TotalFeesCalculator extends Calculator {
    private double time;

    TotalFeesCalculator() {
        super();
        time = 0;
    }

    public double calculation(LocalTime t1, LocalTime t2) {
        this.time = ChronoUnit.SECONDS.between(t1, t2);
        this.result = Math.ceil(this.time/3600) * 5;
        return this.result;
    }
}
