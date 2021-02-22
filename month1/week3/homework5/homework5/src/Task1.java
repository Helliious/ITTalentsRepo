import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String str1, str2;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter first string: ");
            str1 = sc.nextLine();
            System.out.print("Enter second string: ");
            str2 = sc.nextLine();
        } while (str1.length() > 40 || str2.length() > 40);

        System.out.print(str1.toUpperCase() + " " + str1.toLowerCase() + " ");
        System.out.println(str2.toUpperCase() + " " + str2.toLowerCase());
    }
}
