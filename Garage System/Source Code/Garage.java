import java.util.ArrayList;
import java.util.Scanner;

public class Garage {
    Scanner scanner = new Scanner(System.in);
    public int size;
    public ArrayList<Slot>arr_slots = new ArrayList<Slot>();
    public ArrayList<Vehicle> arr_vehicles = new ArrayList<Vehicle>();
    public boolean Config_flag;
    static int index =0;
    public int Income;
    public int num_vehicles;
    //-------------------------------------------------------
    Garage(){
        this.size=0;
        this.Income=0;
        this.num_vehicles=0;
    }
    Garage(int size,boolean choice){
        this.Config_flag=choice;
        this.size=size;


        for(int i=0;i<this.size;i++){
            System.out.println("please enter width of slot no. "+ (i+1));
            double x;
            x = scanner.nextDouble();
            System.out.println("please enter depth of slot no. "+ (i+1));
            double y;
            y = scanner.nextDouble();
            Slot s1 = new Slot(x,y);
            arr_slots.add(s1);
        }
    }
    public void vehicleDetails(Vehicle v){
     //   Vehicle v1= new Vehicle(modelName,modelYear,licensePlate,width,depth);
        arr_vehicles.add(v);
        v.Generate_ID();
    }
    public int  Best_Fit_Config(Vehicle v1){
        double x=1000000000;
        double y=1000000000;
        int ind=-1;
        for(int i=0;i<this.size;i++)
        {
           if(arr_slots.get(i).Getwidth()>=v1.Getwidth() && arr_slots.get(i).GetDepth()>=v1.GetDepth() && arr_slots.get(i).GetStatus()==false)
           {
              x = Math.min(x,arr_slots.get(i).Getwidth());
              y = Math.min(y,arr_slots.get(i).GetDepth());
              ind = i;
           }
        }
        if(ind==-1) {
            System.out.println("No available slots");
         //   System.exit(0);
        }else{
            arr_slots.get(ind).SetStatus(true);
            System.out.println("Vehicle No. "+v1.Get_ID()+ " Parked in Slot no.: " +  arr_slots.get(ind).GetNumber());
        }
        return 1;
    }


    public int First_in_First_Serve(Vehicle v1){
        int ind=-1;
        for(int i=0;i<this.size;i++)
        {
            if(arr_slots.get(i).Getwidth()>=v1.Getwidth() && arr_slots.get(i).GetDepth()>=v1.GetDepth() && arr_slots.get(i).GetStatus()==false)
            {
                ind = i;
                break;
            }
        }
        if(ind==-1)
        {
            System.out.println("No available slots");
       //     System.exit(0);
        }else{
            arr_slots.get(ind).SetStatus(true);
            System.out.println("Vehicle No. "+v1.Get_ID()+ " Parked in Slot no.: " +  arr_slots.get(ind).GetNumber());
        }
        return 1;
    }


    public void park_In(Vehicle v1) {
        int result;
        if(this.Config_flag){
           Best_Fit_Config(v1);
        }else{
            First_in_First_Serve(v1);
        }
       // return result;
    }
    public void request_Avail_Slots(){
        for(int i=0;i<this.size;i++)
        {
            if(arr_slots.get(i).GetStatus()==false)
            {
                System.out.println("The Information of Slot no." + (i+1) + " : ");
                System.out.println("The Width equals "+ arr_slots.get(i).Getwidth());
                System.out.println("The Depth equals "+ arr_slots.get(i).GetDepth());
                System.out.println("The Number of Solt is "+arr_slots.get(i).GetDepth());
                System.out.println("------------------------------------------------------------");
            }
        }
    }
}
