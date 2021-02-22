import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        int arrSize;
        int[] initialArr;
        int[] resultArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            arrSize = sc.nextInt();
        } while (arrSize < 1);

        initialArr = new int[arrSize];
        resultArr = new int[arrSize];

        for (int i = 0; i < initialArr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            initialArr[i] = sc.nextInt();
        }

        for (int i = 0; i < initialArr.length; i++) {
            if (i == 0 || i == initialArr.length - 1) {
                resultArr[i] = initialArr[i];
            } else {
                resultArr[i] = initialArr[i - 1] + initialArr[i + 1];
            }
        }

        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }
}
