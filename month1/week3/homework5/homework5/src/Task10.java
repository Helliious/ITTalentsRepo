import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter string: ");
            str = sc.nextLine();
        } while (str.length() < 1);

        makeNewString(str);
    }

    static void makeNewString(String str) {
        StringBuilder resultStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            resultStr.append((char)(str.charAt(i) + 5));
        }

        System.out.println(resultStr);
    }
}
