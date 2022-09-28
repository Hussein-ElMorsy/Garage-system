public class Slot {
    private double width;
    private double depth;
    private boolean status;
    private int number;
    static private int incrementer=1;

    Slot(){
        this.width=0.0;
        this.depth=0.0;
        this.status=false;
        this.number=incrementer;
        incrementer++;
    }

    Slot(double width,double depth){
        this.width=width;
        this.depth=depth;
        this.status=false;
        this.number=incrementer;
        incrementer++;
    }

    public double GetDepth(){
        return this.depth;
    }
    public double Getwidth(){
        return this.width;
    }
    public int GetNumber(){
        return this.number;
    }
    public boolean GetStatus(){
        return this.status;
    }
    public void SetStatus(boolean status){
        this.status=status;
    }

}
