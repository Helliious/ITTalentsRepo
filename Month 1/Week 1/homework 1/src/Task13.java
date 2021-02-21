import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        byte temp;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperature:");
        temp = sc.nextByte();

        if (temp >= -100 && temp <= 100) {
            if (temp < -20) {
                System.out.println("Ice cold!");
            } else if (temp >= -20 && temp < 0) {
                System.out.println("Cold!");
            } else if (temp >= 0 && temp < 15) {
                System.out.println("Cool!");
            } else if (temp >= 15 && temp < 25) {
                System.out.println("Warm!");
            } else {
                System.out.println("Hot");
            }
        } else {
            System.out.println("Wrong input! Temp must be between -100 and 100!");
        }
    }
}
