import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int number;
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        number = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            if (i <= 1) {
                arr[i] = number;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
