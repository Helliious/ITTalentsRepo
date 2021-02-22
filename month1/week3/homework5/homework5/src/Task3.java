import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String firstStr, secondStr;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first line: ");
            firstStr = sc.nextLine();
            System.out.print("Enter second line: ");
            secondStr = sc.nextLine();
        } while (firstStr.length() < 1 || secondStr.length() < 1);

        compareStrings(firstStr, secondStr);
    }

    static void compareStrings(String firstString, String secondString) {
        int size = 0;

        if (firstString.length() == secondString.length()) {
            System.out.println("The two strings are with equal length!");
            size = firstString.length();
        } else {
            System.out.println("The two strings are with different lengths!");

            if (firstString.length() > secondString.length()) {
                size = secondString.length();
            } else {
                size = firstString.length();
            }
        }

        for (int i = 0; i < size; i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                System.out.println((i + 1) + " " + firstString.charAt(i) + "-" + secondString.charAt(i));
            }
        }
    }
}
