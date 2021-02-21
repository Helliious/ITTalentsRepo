import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        int arrSize;
        int equalElemPosition = 0;
        int countEqualEl = 1;
        int maxRowOfEqualEl = 1;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            arrSize = sc.nextInt();
        } while (arrSize < 1);

        arr = new int[arrSize];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                countEqualEl++;
            } else {
                countEqualEl = 1;
            }

            if (maxRowOfEqualEl < countEqualEl) {
                maxRowOfEqualEl = countEqualEl;
                equalElemPosition = (i + 2) - maxRowOfEqualEl;
            }
        }

        System.out.println();
        System.out.println("Max row of equal elements count: " + maxRowOfEqualEl);
        System.out.println("The row is: ");

        for (int i = equalElemPosition; i < equalElemPosition + maxRowOfEqualEl; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
