public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {32, 33, 34, 35, 37, 39, 40};
        System.out.println(binSearch(arr, 0, arr.length - 1, 34));
    }

    static int binSearch(int[] arr, int start, int end, int valueSearched) {
        int midIdx = (start + end) / 2;

        if (end >= start) {
            if (arr[midIdx] == valueSearched) {
                return midIdx;
            }

            if (arr[midIdx] < valueSearched) {
                return binSearch(arr, midIdx + 1, end, valueSearched);
            }

            if (arr[midIdx] > valueSearched) {
                return binSearch(arr, start, midIdx - 1, valueSearched);
            }
        }
        return -1;
    }
}
