public class Task5 {
    public static void main(String[] args) {
        int currSumRows = 0, maxSumRows;
        int currSumCols = 0, maxSumCols;
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        maxSumRows = arr[0][0];
        maxSumCols = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                currSumRows += arr[i][j];
            }

            if (maxSumRows < currSumRows) {
                maxSumRows = currSumRows;
            }

            currSumRows = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                currSumCols += arr[j][i];
            }

            if (maxSumCols < currSumCols) {
                maxSumCols = currSumCols;
            }

            currSumCols = 0;
        }

        System.out.println("Най-голяма сума по редове: " + maxSumRows);
        System.out.println("Най-голяма сума по колони: " + maxSumCols);

        System.out.print("Максималната сума по редове е ");

        if (maxSumRows > maxSumCols) {
            System.out.print("> от");
        } else if (maxSumRows == maxSumCols) {
            System.out.print("= на");
        } else {
            System.out.print("< от");
        }

        System.out.println(" максималната сума по колони!");
    }
}
