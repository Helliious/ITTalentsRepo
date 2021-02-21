import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        int nextNumber = 1;
        double[] arr = new double[10];
        double[] resultArr = new double[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < -0.231) {
                resultArr[i] = (nextNumber * nextNumber) + 41.25;
            } else {
                resultArr[i] = arr[i] * nextNumber;
            }

            nextNumber++;
        }

        System.out.println("Starting array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i != resultArr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("Result array:");
        for (int i = 0; i < resultArr.length; i++) {
            System.out.printf("%.2f", resultArr[i]);

            if (i != resultArr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
