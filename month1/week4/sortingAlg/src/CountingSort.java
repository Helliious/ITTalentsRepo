import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {32, 5, 1, 7, 8, 4, 9, 54};
        countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void countingSort(int[] arr) {
        int min, max;
        min = arr[0];
        max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int[] helpArr = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            helpArr[arr[i] - min]++;
        }

        int nextIdx = 0;
        for (int i = 0; i < helpArr.length; i++) {
            int counted = i + min;
            int counter = helpArr[i];
            for (int j = 0; j < counter; j++) {
                arr[nextIdx++] = counted;
            }
        }
    }
}
