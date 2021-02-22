import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int numberOfElements;
        int smallestDivThree;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number of elements:");
            numberOfElements = sc.nextInt();
        } while (numberOfElements < 1);

        arr = new int[numberOfElements];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        smallestDivThree = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                if (arr[i] < smallestDivThree) {
                    smallestDivThree = arr[i];
                }
            }
        }

        System.out.println("Smallest number divided by 3 is: " + smallestDivThree);
    }
}
