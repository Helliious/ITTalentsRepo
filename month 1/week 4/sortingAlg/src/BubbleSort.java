public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 7, 9, 4, 6};

        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length ; i++) {
            boolean isSorted = true;
            for (int j = arr.length - 1; j > i ; j--) {
                if (arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }
}
