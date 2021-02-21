import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        int sizeArr;
        double firstBiggest = 0, secondBiggest = 0, thirdBiggest = 0;
        double currSum = 0;
        double sum = 0;
        double[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new double[sizeArr];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i] != arr[j] && arr[i] != arr[k] && arr[j] != arr[k]) {
                        currSum = Math.abs(arr[i] + arr[j] + arr[k]);
                        if (sum < currSum) {
                            sum = currSum;
                            firstBiggest = arr[i];
                            secondBiggest = arr[j];
                            thirdBiggest = arr[k];
                        }
                    }
                }
            }
        }

        System.out.println(firstBiggest + "; " + secondBiggest + "; " + thirdBiggest);
    }
}
