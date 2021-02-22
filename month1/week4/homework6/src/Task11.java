import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 1);

        makeTriangle(1,1, number);
    }

    static void makeTriangle(int start, int stars, int number) {
        if (start == number) {
            printStars(stars);
        } else {
            printSpaces(number - start);
            printStars(stars);
            System.out.println();
            stars += 2;
            makeTriangle(++start, stars, number);
        }
    }

    static void printSpaces(int numSpaces) {
        if (numSpaces == 1) {
            System.out.print(" ");
        } else {
            System.out.print(" ");
            printSpaces(--numSpaces);
        }
    }

    static void printStars(int numStars) {
        if (numStars == 1) {
            System.out.print("*");
        } else {
            System.out.print("*");
            printStars(--numStars);
        }
    }
}
