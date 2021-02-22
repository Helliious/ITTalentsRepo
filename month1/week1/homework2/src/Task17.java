import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        int b;
        char c;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter square size:");
            b = sc.nextInt();
        } while (b < 3 || b > 20);

        System.out.println("Enter symbol:");
        c = sc.next().charAt(0);

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || i == b-1) {
                    System.out.print("*");
                } else {
                    if (j == 0 || j == b-1) {
                        System.out.print("*");
                    } else {
                        System.out.print(c);
                    }
                }
            }

            System.out.println();
        }

    }
}
