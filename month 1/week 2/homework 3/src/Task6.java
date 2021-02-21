import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        boolean areEqual = true;
        int firstArrSize, secondArrSize;
        int[] firstArr;
        int[] secondArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter first array size:");
            firstArrSize = sc.nextInt();
            System.out.println("Enter second array size:");
            secondArrSize = sc.nextInt();
        } while (firstArrSize < 1 || secondArrSize < 1);

        firstArr = new int[firstArrSize];
        secondArr = new int[secondArrSize];

        for (int i = 0; i < firstArr.length; i++) {
            System.out.print("Enter first array element " + i + ": ");
            firstArr[i] = sc.nextInt();
        }

        for (int i = 0; i < secondArr.length; i++) {
            System.out.print("Enter second array element " + i + ": ");
            secondArr[i] = sc.nextInt();
        }

        if (firstArrSize > secondArrSize || secondArrSize > firstArrSize) {
            areEqual = false;
            System.out.println("The two arrays are with different sizes!");
        } else {
            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i] != secondArr[i]) {
                    areEqual = false;
                    break;
                }
            }
        }

        if (areEqual) {
            System.out.println("The two arrays ARE equal!");
        } else {
            System.out.println("The two arrays are NOT equal!");
        }
    }
}
