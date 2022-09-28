import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

///display available slots
///park-in
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>>Welcome To Our Application<<<");
        System.out.println("Please enter your choice: ");
        System.out.println("0) First in First Serve.");
        System.out.println("1) Best Fit Approach.");
        System.out.println("---------------------------------------------------------");
        int x;
        x = scanner.nextInt();
        boolean choice;
        if(x==0){
            choice=false;
        }else{
            choice=true;
        }
        int size;
        System.out.println("Please enter the sizes of the slots: ");
        size = scanner.nextInt();
        Garage g1 = new Garage(size,choice);

        while(true)
        {
            System.out.println("Please enter your Choice: ");
            System.out.println("1) Park-In .");
            System.out.println("2) Park-Out (Not Available Now) .");
            System.out.println("3) Display Available Slots .");
            System.out.println("0) Exit Program .");
            int y;
            y = scanner.nextInt();
            if(y==0){
                System.out.println(">> You Exit from the program <<");
                System.exit(0);
            }else if(y==1){
                System.out.println("-> Please enter the model Name of your vehicle: ");
                String m_name;
                m_name = scanner.next();
                System.out.println("-> Please enter the model Year of your vehicle: ");
                int m_year;
                m_year = scanner.nextInt();
                System.out.println("-> Please enter the License Plate of your vehicle: ");
                String l_plate;
                l_plate = scanner.next();
                System.out.println("-> Please enter the width of your vehicle: ");
                double i_width;
                i_width = scanner.nextDouble();
                System.out.println("-> Please enter the depth of your vehicle: ");
                double i_depth;
                i_depth = scanner.nextDouble();
                Vehicle vv = new Vehicle(m_name, m_year,l_plate, i_width, i_depth);
                g1.vehicleDetails(vv);
                g1.park_In(vv);
                System.out.println("---------------------------------------------------------");
            }else if(y==3){
                System.out.println("------The Available Slots------");
                g1.request_Avail_Slots();
            }

        }








    }
}

