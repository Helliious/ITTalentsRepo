import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        int number;
        int first, second;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        number = sc.nextInt();

        if (number >= 1000 && number <= 9999) {
            first = ((number / 1000) * 10) + (number % 10);
            number = number / 10;
            second = number - ((number / 100) * 100);

            if (first < second) {
                System.out.println("First is smaller than second");
            } else if (first == second) {
                System.out.println("They are equal");
            } else {
                System.out.println("First is bigger than second");
            }
        } else {
            System.out.println("Wrong input!The number must be between 1000 and 9999!");
        }
    }
}
