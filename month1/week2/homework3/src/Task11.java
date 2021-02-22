import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        int countNumbers = 0;
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0 && arr[i] > 5) {
                System.out.print(arr[i] + " ");
                countNumbers++;
            }
        }

        System.out.print("- " + countNumbers + " numbers");
    }
}
