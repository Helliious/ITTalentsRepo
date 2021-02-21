import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        int temp;
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;

        arr[2] -= arr[3];
        arr[3] += arr[2];
        arr[2] = arr[3] - arr[2];

        arr[4] *= arr[5];
        arr[5] = arr[4] / arr[5];
        arr[4] /= arr[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
