import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int numberOfElements;
        int[] arr;
        int[] result;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number of elements:");
            numberOfElements = sc.nextInt();
        } while (numberOfElements < 1);

        arr = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        result = new int[2 * numberOfElements];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }

        for (int i = numberOfElements; i < result.length; i++) {
            result[i] = arr[--numberOfElements];
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
