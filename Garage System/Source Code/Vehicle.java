public class Vehicle {
  private String Model_Name;
  private int Model_Year;
  private String License_Plate;
  private int ID;
  private double width;
  private double depth;
  static public int incrementer=1;

  Vehicle(){
    this.Model_Name="";
    this.Model_Year=2022;
    this.License_Plate="";
    this.depth=0.0;
    this.width=0.0;
  }
  Vehicle(String Model_Name , int Model_Year,String License_Plate,double width,double depth){
    this.Model_Name=Model_Name;
    this.Model_Year=Model_Year;
    this.License_Plate=License_Plate;
    this.depth=depth;
    this.width=width;
  }
  public String GetModelName(){
    return this.Model_Name;
  }
  public int GetModelYear(){
    return this.Model_Year;
  }
  public String GetLicense_Plate(){
    return this.License_Plate;
  }
  public double GetDepth(){
    return this.depth;
  }
  public double Getwidth(){
    return this.width;
  }
  public int Get_ID(){
    return this.ID;
  }
  public void Generate_ID (){
    this.ID=incrementer;
    incrementer++;
  }
}
