public class Task7 {
    public static void main(String[] args) {
        int col = 0;
        int row = 0;
        int lineSum = 0;
        int overallSum = 0;
        int[][] arr = {
                {11, 12, 13, 14, 15, 16},
                {21, 22, 23, 24, 25, 26},
                {31, 32, 33, 34, 35, 36},
                {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56},
                {61, 62, 63, 64, 65, 66}
        };

        for (int i = 0; i < arr.length * arr[0].length; i++) {
            if ((row + col) % 2 == 0) {
                System.out.print(arr[row][col] + ", ");
                lineSum += arr[row][col];
            }

            col++;

            if (col == arr[0].length) {
                col = 0;
                row++;
                overallSum += lineSum;
                System.out.println("sum of the elements for this line: " + lineSum);
                lineSum = 0;
            }
        }

        System.out.println("Sum of the elements: " + overallSum);
    }
}
