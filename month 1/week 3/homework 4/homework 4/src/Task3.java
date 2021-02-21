import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int rowsCount, colsCount;
        int sumElements = 0;
        int[][] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter rows count: ");
            rowsCount = sc.nextInt();
            System.out.print("Enter cols count: ");
            colsCount = sc.nextInt();
        } while (rowsCount < 1 || colsCount < 1);

        arr = new int[rowsCount][colsCount];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sumElements += arr[i][j];
            }
        }

        System.out.println("Array's sum: " + sumElements);
        System.out.println("Average: " + (sumElements / (rowsCount * colsCount)));
    }
}
