import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int sizeArr;
        int[][] arr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter array size: ");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new int[sizeArr][sizeArr];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + " ");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][(arr.length - 1) - i] + " ");
        }
    }
}
