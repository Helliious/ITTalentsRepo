import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int sizeRows;
        int sizeCols;
        int cols = 0;
        int[][] arr;
        int[][] swapArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter array row's size: ");
            sizeRows = sc.nextInt();
            System.out.print("Enter array col's size: ");
            sizeCols = sc.nextInt();
        } while (sizeRows < 1 || sizeCols < 1);

        arr = new int[sizeRows][sizeCols];
        swapArr = new int[sizeCols][sizeRows];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                do {
                    System.out.print("Enter element [" + i + "][" + j + "]: ");
                    arr[i][j] = sc.nextInt();
                } while (arr[i][j] < 0 || arr[i][j] > 100);
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                swapArr[i][cols] = arr[j][i];
                cols++;
            }

            cols = 0;
        }

        arr = new int[sizeCols][sizeRows];

        for (int i = 0; i < swapArr.length; i++) {
            for (int j = 0; j < swapArr[i].length; j++) {
                arr[i][j] = swapArr[i][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
