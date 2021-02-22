import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        int n;
        int result = 1;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}
