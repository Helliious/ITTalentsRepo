import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {
        int number;
        int count = 1;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter number:");
            number = sc.nextInt();
        } while (number < 1 || number > 999);

        number++;

        while (count <= 10) {
            if ((number % 2 == 0) || (number % 3 == 0) || (number % 5 == 0)) {
                System.out.print(count + ":" + number + ", ");
                count++;
            }

            number++;
        }
    }
}
