package main;

public class Demo {
    public static void main(String[] args) {
        int[] arr1 = {8, 3, 10, 24, 0, 4, 7, 14};
        int[] arr2 = {4, 0, 5, 3, 9, 4};

        int[] result = divideArrays(arr1, arr2);

        for (int j : result) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static int[] divideArrays(int[] arr1, int[] arr2) {
        int[] resultArr;
        try {
            int x = arr1[arr2.length - 1];
            resultArr = new int[arr2.length];
        } catch (ArrayIndexOutOfBoundsException e) {
            resultArr = new int[arr1.length];
        }

        for (int i = 0; i < resultArr.length; i++) {
            try {
                resultArr[i] = arr1[i] / arr2[i];
            } catch (ArithmeticException e) {
                resultArr[i] = 0;
            } catch (Exception e) {
                System.out.println("Ooopsy deisy!");
                break;
            }
        }

        return resultArr;
    }
}
