import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        int number;
        int first, second, third;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        number = sc.nextInt();

        first = number % 10;
        second = (number / 10) % 10;
        third = number / 100;

        if (first == 0 || second == 0 || third == 0) {
            System.out.println("Wrong input!Number mustn't have zeros!");
        } else {
            if (number % first == 0 && number % second == 0 && number % third == 0) {
                System.out.println("Yes, it does!");
            } else {
                System.out.println("No, it doesn't");
            }
        }
    }
}
