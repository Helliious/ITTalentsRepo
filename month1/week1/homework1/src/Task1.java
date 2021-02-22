import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        double a, b, c;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter A:");
        a = sc.nextDouble();
        System.out.println("Enter B:");
        b = sc.nextDouble();
        System.out.println("Enter C:");
        c = sc.nextDouble();

        if (c >= a && c <= b) {
            System.out.println("The number " + c + " is between " + a + " and " + b);
        } else {
            System.out.println("The number " + c + " is NOT between " + a + " and " + b);
        }
    }
}
