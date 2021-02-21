import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // with Integers
        //int sum, pr, divRes, intDiv;
        //int first, second;

        // with Doubles
        double sum, pr, divRes, intDiv;
        double first, second;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        // with Integers
        //first = sc.nextInt();

        // with Doubles
        first = sc.nextDouble();

        System.out.println("Enter second number:");
        // with Integers
        //second = sc.nextInt();

        // with Doubles
        second = sc.nextDouble();

        if (first != second) {
            sum = first + second;
            pr = first * second;
            divRes = first % second;
            intDiv = first / second;

            System.out.println("Sum: " + sum);
            System.out.println("Product: " + pr);
            System.out.println("Division Residue: " + divRes);
            System.out.println("Integer Division: " + intDiv);
        } else {
            System.out.println("Wrong input! The numbers must be different!");
        }
    }
}
