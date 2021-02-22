import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        boolean isZigZag = true;
        int sizeArr;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new int[sizeArr];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element: " + i + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < arr.length - 1; i += 2) {
            if (arr[i - 1] >= arr[i] || arr[i] <= arr[i + 1]) {
                isZigZag = false;
                break;
            }
        }

        if (isZigZag) {
            System.out.println("Изпълнява изискванията на зигзагообразна нагоре редица!");
        } else {
            System.out.println("НЕ изпълнява изискванията на зигзагообразна нагоре редица!");
        }
    }
}
