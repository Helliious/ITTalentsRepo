import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int first, second;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        first = sc.nextInt();
        System.out.println("Enter second number:");
        second = sc.nextInt();

        if (first <= second) {
            for (int i = first; i <= second; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = second; i <= first; i++) {
                System.out.print(i + " ");
            }
        }

        //alternative solution
//        int first, second;
//        int temp;
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter first number:");
//        first = sc.nextInt();
//        System.out.println("Enter second number:");
//        second = sc.nextInt();
//
//        if (first > second) {
//            temp = first;
//            first = second;
//            second = temp;
//        }
//
//        for (int i = first; i <= second; i++) {
//            System.out.print(i + " ");
//        }
    }
}
