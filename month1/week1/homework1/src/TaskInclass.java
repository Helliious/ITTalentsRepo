import java.util.Scanner;

public class TaskInclass {
    public static void main(String[] args) {
        //da napisha progr koqto prochita cqlo pol chislo i prod deistvie samo ako e vavedeno validno poloj chislo
        //check if number is odd or even

        int number = -1;

        Scanner sc = new Scanner(System.in);

        while (number < 0) {
            System.out.println("Enter valid positive integer:");
            number = sc.nextInt();
        }

        if (number % 2 != 0) {
            for (int i = 1; i <= number; i++) {
                System.out.println(i);
            }
        } else {
            if (number % 5 == 0) {
                System.out.println("YES it is divisible by 5");
            } else {
                System.out.println("Nope, srry not divisible by 5");
            }
        }
    }
}
