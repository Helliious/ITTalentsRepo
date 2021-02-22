import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int firstNum, secondNum;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        firstNum = sc.nextInt();
        System.out.print("Enter second number: ");
        secondNum = sc.nextInt();

        if (firstNum <= secondNum) {
            printNumbers(firstNum, secondNum);
        } else {
            printNumbers(secondNum, firstNum);
        }
    }

    static void printNumbers(int firstNum, int secondNum) {
        if (firstNum == secondNum) {
            System.out.println(firstNum);
        } else {
            System.out.print(firstNum + " ");
            printNumbers(++firstNum, secondNum);
        }
    }
}
