import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter n:");
            n = sc.nextInt();
        } while (n < 10 || n > 200);

        for (int i = n - 1; i > 0; i--) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }
}
