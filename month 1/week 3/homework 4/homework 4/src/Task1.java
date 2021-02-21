public class Task1 {
    public static void main(String[] args) {
        int minEl, maxEl;
        int[][] arr = {
                {48, 72, 13, 14, 15},
                {21, 22, 53, 24, 75},
                {31, 57, 33, 34, 35},
                {41, 95, 43, 44, 45},
                {59, 52, 53, 54, 55},
                {61, 69, 63, 64, 65}
        };

        minEl = arr[0][0];
        maxEl = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (minEl > arr[i][j]) {
                    minEl = arr[i][j];
                }

                if (maxEl < arr[i][j]) {
                    maxEl = arr[i][j];
                }
            }
        }

        System.out.println("Minimal element: " + minEl);
        System.out.println("Maximum element: " + maxEl);
    }
}
