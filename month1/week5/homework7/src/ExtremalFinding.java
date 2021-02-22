public class ExtremalFinding {
    public static void main(String[] args) {
        int[] arrForMin = {12, 11, 10, 9, 8, 7, 6, 12, 13, 14, 15, 17};
        int[] arrForMax = {1, 2, 3, 4, 5, 4, 3};
        int resultIdx = findMax(arrForMax, 0, arrForMax.length - 1);

        if (resultIdx < 0) {
            resultIdx = findMin(arrForMax, 0, arrForMax.length - 1);
            System.out.println("Minimum extremal found index: " + resultIdx);
        } else {
            System.out.println("Maximum extremal found index: " + resultIdx);
        }
    }

    static int findMax(int[] arr, int start, int end) {
        if (end >= start) {
            //Calculate mid index
            int mid = (start + end) / 2;

            //Check if we have found the extremal value
            if ((mid == 0) ||
                    (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])) {
                return mid;
            }
            //If element before mid is bigger -> search first half
            if (arr[mid - 1] > arr[mid]) {
                return findMax(arr, start, mid);
            }

            //If element after mid is bigger -> search second half
            if (arr[mid + 1] > arr[mid]) {
                //Check if we are going to hit the last index on next iteration
                if (mid + 1 == end) {
                    return end;
                }
                return findMax(arr, mid, end);
            }
        }

        return -1;
    }

    static int findMin(int[] arr, int start, int end) {
        if (end >= start) {
            //Calculate mid index
            int mid = (start + end) / 2;
            //Check if we are on last iteration
            if (mid == end - 1) {
                return end;
            }

            //Check if we have found the extremal value
            if ((mid == 0) ||
                    (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1])) {
                return mid;
            }

            //If element before mid is bigger -> search second half
            if (arr[mid - 1] > arr[mid]) {
                return findMin(arr, mid, end);
            }
            //If element after mid is bigger -> search first half
            if (arr[mid + 1] > arr[mid]) {
                return findMin(arr, start, mid);
            }
        }

        return -1;
    }
}
