import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        int a, b;
        int sum = 0;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter A:");
            a = sc.nextInt();
            System.out.println("Enter B:");
            b = sc.nextInt();
        } while (a > b);

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                System.out.print("skip " + i);
                if (i != b) {
                    System.out.print(", ");
                }
            } else {
                sum += i*i;

                if (sum > 200) {
                    break;
                } else {
                    System.out.print(i * i);
                    if (i != b) {
                        System.out.print(", ");
                    }
                }
            }
        }
    }
}
