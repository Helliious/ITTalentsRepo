import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        int a, b;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter A:");
            a = sc.nextInt();
            System.out.println("Enter B:");
            b = sc.nextInt();
        } while ((a < 1 || a > 9) || (b < 1 || b > 9));

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }
}
