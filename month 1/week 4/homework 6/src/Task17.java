import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        int size;
        char symbol;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter size: ");
            size = sc.nextInt();
            System.out.print("Enter symbol: ");
            symbol = sc.next().charAt(0);
        } while (size < 1);

        makeSquare(size, size, symbol);
    }

    static void makeSquare(int it, int size, char symbol) {
        if (it == 1) {
            printLineStars(size);
        } else if (it == size) {
            printLineStars(size);
            makeSquare(--it, size, symbol);
        } else {
            printLineSymbols(size, size, symbol);
            makeSquare(--it, size, symbol);
        }
    }

    static void printLineStars(int size) {
        if (size == 1) {
            System.out.println("*");
        } else {
            System.out.print("*");
            printLineStars(--size);
        }
    }

    static void printLineSymbols(int it, int size, char symbol) {
        if (it == 1) {
            System.out.println("*");
        } else if (it == size) {
            System.out.print("*");
            printLineSymbols(--it, size, symbol);
        } else {
            System.out.print(symbol);
            printLineSymbols(--it, size, symbol);
        }
    }
}
