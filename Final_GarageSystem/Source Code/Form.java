import java.util.Scanner;

public class Form {
    Scanner scanner;

    public Form() {
        this.scanner = new Scanner(System.in);
    }

    public int menu() {
        System.out.println("1. Park in");
        System.out.println("2. Park out");
        System.out.println("3. Display available parking slots");
        System.out.println("4. Display total income and number of vehicle");
//        System.out.println("5. Select slot ");
        return this.integer("Enter your choice: ");
    }

    public void Msg(String s) {
        System.out.println(s);
    }

    public String word(String s) {
        System.out.println(s);
        return scanner.next();
    }

    public int integer(String s) {
        System.out.println(s);
        int number = scanner.nextInt();
        return number;
    }

    public double Double(String s) {
        System.out.println(s);
        double decimal = scanner.nextDouble();
        return decimal;
    }
}
