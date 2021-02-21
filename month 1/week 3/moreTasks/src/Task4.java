import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        int cols, rows;
        int[][] arr;
        int[][] resultArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter array rows: ");
            rows = sc.nextInt();
            System.out.print("Enter array cols: ");
            cols = sc.nextInt();
        } while (rows < 3 || rows > 10 || cols < 3 || cols > 10);

        arr = new int[rows][cols];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                do {
                    System.out.print("Enter element [" + i + "][" + j + "]: ");
                    arr[i][j] = sc.nextInt();
                } while (arr[i][j] < 1 || arr[i][j] > 30);
            }
        }

        if (cols > rows) {
            rows = cols;
        } else {
            cols = rows;
        }

        resultArr = new int[rows][cols];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                resultArr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr[i].length; j++) {
                System.out.print(resultArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
