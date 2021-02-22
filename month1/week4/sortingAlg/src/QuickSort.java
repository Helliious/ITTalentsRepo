import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {32, 1, 12, 5, 43, 2, 3, 9, 8};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIdx = partition(arr, start, end);
        quickSort(arr, start, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, end);
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int nextIdx = start + 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[nextIdx];
                arr[nextIdx] = temp;
                nextIdx++;
            }
        }

        int temp = arr[start];
        arr[start] = arr[nextIdx - 1];
        arr[nextIdx - 1] = temp;

        return nextIdx - 1;
    }
}
