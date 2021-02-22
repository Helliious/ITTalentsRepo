import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        int sizeStartArr, sizeResultArr = 0;
        int resultArrPos = 0;
        double[] startArr;
        double[] resultArr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter array size:");
            sizeStartArr = sc.nextInt();
        } while (sizeStartArr < 1);

        startArr = new double[sizeStartArr];

        for (int i = 0; i < startArr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            startArr[i] = sc.nextDouble();

            if (startArr[i] >= -2.99 && startArr[i] <= 2.99) {
                sizeResultArr++;
            }
        }

        resultArr = new double[sizeResultArr];

        for (int i = 0; i < startArr.length; i++) {
            if (startArr[i] >= -2.99 && startArr[i] <= 2.99) {
                resultArr[resultArrPos] = startArr[i];
                resultArrPos++;
            }
        }

        for (int i = 0; i < resultArr.length; i++) {
            System.out.print(resultArr[i]);

            if (i != resultArr.length - 1) {
                System.out.print("; ");
            }
        }
    }
}
