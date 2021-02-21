import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        int sizeArr;
        int temp;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new int[sizeArr];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[((sizeArr - 1) - i)];
            arr[((sizeArr - 1) - i)] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
