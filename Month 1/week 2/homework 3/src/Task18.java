import java.util.Scanner;

public class Task18 {
    public static void main(String[] args) {
        int sizeFirst, sizeSecond;
        int sizeResult;
        int[] firstArr;
        int[] secondArr;
        int[] resultArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter first array size:");
            sizeFirst = sc.nextInt();
            System.out.println("Enter second array size:");
            sizeSecond = sc.nextInt();
        } while (sizeFirst < 1 || sizeSecond < 1);

        firstArr = new int[sizeFirst];
        secondArr = new int[sizeSecond];

        for (int i = 0; i < firstArr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            firstArr[i] = sc.nextInt();
        }

        for (int i = 0; i < secondArr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            secondArr[i] = sc.nextInt();
        }

        if (firstArr.length < secondArr.length) {
            sizeResult = firstArr.length;
        } else {
            sizeResult = secondArr.length;
        }

        resultArr = new int[sizeResult];

        for (int i = 0; i < resultArr.length; i++) {
            if (firstArr[i] > secondArr[i]) {
                resultArr[i] = firstArr[i];
            } else {
                resultArr[i] = secondArr[i];
            }
        }

        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i] + " ");
        }
    }
}
