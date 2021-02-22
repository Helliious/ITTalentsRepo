import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        double time;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter time:");
        time = sc.nextDouble();

        if (time >= 0 && time <= 24) {
            if (time >= 18 || (time >= 0 && time <= 4)) {
                System.out.println("Good Evening!");
            } else if (time > 4 && time <= 9) {
                System.out.println("Good Morning!");
            } else {
                System.out.println("Good Day!");
            }
        } else {
            System.out.println("Wrong input! Time must be between 0 and 24!");
        }
    }
}
