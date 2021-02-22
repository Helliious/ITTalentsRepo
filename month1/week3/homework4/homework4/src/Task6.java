public class Task6 {
    public static void main(String[] args) {
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

        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]);
                    if (j != arr[i].length - 1) {
                        System.out.print(", ");
                    }

                    lineSum += arr[i][j];
                }

                System.out.println(" sum: " + lineSum);
                overallSum += lineSum;
                lineSum = 0;
            }
        }

        System.out.println("Sum of the elements: " + overallSum);
    }
}
