import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        int n;
        int count = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        while (n > 0) {
            n -= 2;
            count++;
        }

        System.out.println("COUNT: " + count);

//        for (int i = n; i > 0; i--) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(i + " ");
//            }
//
//            System.out.println();
//        }
    }
}
