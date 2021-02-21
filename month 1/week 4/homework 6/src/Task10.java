import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 1);

        System.out.println(isPrime(2, number));
    }

    static boolean isPrime(int iter, int number) {
        if (number % iter == 0 && iter != number) {
            return false;
        } else if (iter == number) {
            return true;
        }

        return isPrime(++iter, number);
    }
}
