public class TotalIncomeCalculator extends Calculator {

    public int carCounter;

    public void add(double fee) {
        this.result += fee;
    }

    public void incrementCarCounter() {
        this.carCounter++;
    }

    public int getCarCounter() {
        return this.carCounter;
    }

    public double getResult() {
        return this.result;
    }
}
