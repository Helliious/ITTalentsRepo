import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        boolean isSpecular = true;
        int arrSize;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            arrSize = sc.nextInt();
        } while (arrSize < 1);

        arr = new int[arrSize];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[--arrSize]) {
                isSpecular = false;
                break;
            }
        }

        if (isSpecular) {
            System.out.println("The array is specular!");
        } else {
            System.out.println("The array is NOT specular!");
        }
    }
}
