import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int sizeArr;
        int cols = 0;
        int[][] arr;
        int[][] swapArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter array size: ");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new int[sizeArr][sizeArr];
        swapArr = new int[sizeArr][sizeArr];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                do {
                    System.out.print("Enter element [" + i + "][" + j + "]: ");
                    arr[i][j] = sc.nextInt();
                } while (arr[i][j] < 0 || arr[i][j] > 100);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1; j >= 0; j--) {
                swapArr[i][cols] = arr[j][i];
                cols++;
            }

            cols = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
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
