

public class Vehicle {
  private String ModelName;
  private int ModelYear;
  private double depth;
  private double width;
  static int num = 1;
  private int vehicleId;







  //parameterized Constructor
  Vehicle(double depth,double width,String ModelName,int ModelYear)
  {
      this.width = width;
      this.depth = depth;
      this.vehicleId = num;
      this.ModelName = ModelName;
      this.ModelYear = ModelYear;
      num++;
  }

    //getters
  double getDepth(){
        return this.depth;
  }
  double getWidth(){
        return this.width;
  }
  int getVehicleId(){
        return this.vehicleId;
  }


}
