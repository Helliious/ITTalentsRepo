public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 12, 6, 2, 8, 7};

        minMaxSelectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void selectionSort(int[] arr) {
        int temp = 0;
        int minIdx = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }

    static void minMaxSelectionSort(int[] arr) {
        int minIdx, maxIdx;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            minIdx = i;
            maxIdx = i;
            for (int k = i; k <= j; k++) {
                if (arr[k] < arr[minIdx]) {
                    minIdx = k;
                } else if (arr[k] > arr[maxIdx]) {
                    maxIdx = k;
                }
            }

            swap(arr, minIdx, i);

            if (arr[minIdx] == arr[maxIdx]) {
                swap(arr, minIdx, j);
            } else {
                swap(arr, maxIdx, j);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//    int temp = 0;
//    int minElIdx = 0;
//    int maxElIdx = 0;
//
//        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
//        minElIdx = i;
//        maxElIdx = i;
//
//        for (int k = i; k <= j; k++) {
//        if (arr[k] < arr[minElIdx]) {
//        minElIdx = k;
//        } else if (arr[k] > arr[maxElIdx]) {
//        maxElIdx = k;
//        }
//        }
//
//        swap(arr, minElIdx, i);
//
//        if (arr[minElIdx] == arr[maxElIdx]) {
//        swap(arr, minElIdx, j);
//        } else {
//        swap(arr, maxElIdx, j);
//        }
//        }