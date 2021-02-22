import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        //Solution for 3 numbers
        int first, second, third;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        first = sc.nextInt();
        System.out.println("Enter second number:");
        second = sc.nextInt();
        System.out.println("Enter third number:");
        third = sc.nextInt();

        if (first != second && first != third && second != third) {
            if (first >= second && first >= third) {
                if (second >= third) {
                    System.out.println("Numbers in descending order: " + first + ", " + second + ", " + third);
                } else {
                    System.out.println("Numbers in descending order: " + first + ", " + third + ", " + second);
                }
            } else if (second > first && second >= third) {
                if (first >= third) {
                    System.out.println("Numbers in descending order: " + second + ", " + first + ", " + third);
                } else {
                    System.out.println("Numbers in descending order: " + second + ", " + third + ", " + first);
                }
            } else {
                if (first >= second) {
                    System.out.println("Numbers in descending order: " + third + ", " + first + ", " + second);
                } else {
                    System.out.println("Numbers in descending order: " + third + ", " + second + ", " + first);
                }
            }
        } else {
            System.out.println("Wrong input! The numbers must be different!");
        }

        // Solution for random amount of numbers
        /*
        int[] numbers = new int[3];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            numbers[i] = sc.nextInt();
        }

        if (numbers[0] != numbers[1] && numbers[0] != numbers[2] && numbers[1] != numbers[2]) {
            for (int i = 1; i < 3; i++) {
                int key = numbers[i];
                int j = i - 1;

                while (j >= 0 && numbers[j] < key) {
                    numbers[j + 1] = numbers[j];
                    j = j - 1;
                }
                numbers[j + 1] = key;
            }

            for (int i = 0; i < 3; i++) {
                System.out.print(numbers[i] + " ");
            }
        } else {
            System.out.println("Wrong input! The numbers must be different!");
        }
        */

    }
}
