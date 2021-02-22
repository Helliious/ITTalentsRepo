import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter string: ");
            str = sc.nextLine();
        } while (str.length() < 1);

        if (isPalindrome(str)) {
            System.out.println("Yes!");
        } else {
            System.out.println("No!");
        }
    }

    static boolean isPalindrome(String str) {
        boolean isPalindrome = true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt((str.length() - 1) - i)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
