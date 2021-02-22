import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int sum = 0;
        int currDiff, endDiff;
        int mediumValue;
        int resultNumber;
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        mediumValue = sum / arr.length;
        endDiff = mediumValue - arr[0];

        if (endDiff < 0) {
            endDiff *= -1;
        }

        resultNumber = arr[0];

        for (int i = 0; i < arr.length; i++) {
            currDiff = mediumValue - arr[i];
            if (currDiff < 0) {
                currDiff *= -1;
            }

            if (endDiff > currDiff) {
                endDiff = currDiff;
                resultNumber = arr[i];
            }
        }

        System.out.println("Average value: " + mediumValue);
        System.out.println("Closest value from array: " + resultNumber);
    }
}
