import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int sizeArr;
        int currSumRows = 0;
        int currSumCols = 0;
        int maxSumRows = 0;
        int maxSumCols = 0;
        int[][] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter array size: ");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new int[sizeArr][sizeArr];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                do {
                    System.out.print("Enter element [" + i + "][" + j + "]: ");
                    arr[i][j] = sc.nextInt();
                } while (arr[i][j] < 0 || arr[i][j] > 100);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            maxSumCols += arr[i][0];
            maxSumRows += arr[0][i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                currSumRows += arr[i][j];
                currSumCols += arr[j][i];
            }

            if (currSumRows > maxSumRows) {
                maxSumRows = currSumRows;
            }

            if (currSumCols > maxSumCols) {
                maxSumCols = currSumCols;
            }

            currSumCols = 0;
            currSumRows = 0;
        }

        System.out.println("Max sum by rows: " + maxSumRows);
        System.out.println("Max sum by cols: " + maxSumCols);

        System.out.print("Max sum by rows is ");
        if (maxSumRows > maxSumCols) {
            System.out.print("> then ");
        } else if (maxSumCols > maxSumRows) {
            System.out.print("< then ");
        } else {
            System.out.print("= to ");
        }

        System.out.println("max sum by cols!");
    }
}
