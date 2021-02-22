import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        int sum;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter sum: ");
            sum = sc.nextInt();
        } while (sum < 2 || sum > 27);

        printNumbersWithSumDigitsEqualTo(100, sum);
    }

    static void printNumbersWithSumDigitsEqualTo(int currNum, int sum) {
        if (currNum > 999) {
            System.out.println();
        } else {
            int tempNum = currNum;
            int thirdDigit = tempNum % 10;
            int firstDigit = tempNum / 100;
            tempNum /= 10;
            int secondDigit = tempNum % 10;

            if ((firstDigit + secondDigit + thirdDigit) == sum) {
                System.out.print(currNum + ", ");
            }

            printNumbersWithSumDigitsEqualTo(++currNum, sum);
        }
    }
}
