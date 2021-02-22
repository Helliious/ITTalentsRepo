import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        int number, tempNumber;
        int sizeArr = 0;
        int[] binNumber;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            number = sc.nextInt();
        } while (number < 0);

        tempNumber = number;

        do {
            tempNumber /= 2;
            sizeArr++;
        } while (tempNumber / 2 != 0);

        sizeArr++;
        binNumber = new int[sizeArr];

        for (int i = binNumber.length - 1; i >= 0 ; i--) {
            binNumber[i] = number % 2;
            number /= 2;
        }

        System.out.println("The number in binary system:");

        for (int i = 0; i < binNumber.length; i++) {
            System.out.print(binNumber[i]);
        }
    }
}
