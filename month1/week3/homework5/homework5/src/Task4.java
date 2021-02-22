import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String names;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two full names: ");
        names = sc.nextLine();

        findNameWithBiggerSum(names);
    }

    static void findNameWithBiggerSum(String names) {
        String firstName, secondName;
        int firstNameSum = 0, secondNameSum = 0;

        firstName = names.substring(0, names.indexOf(','));
        secondName = names.substring(names.indexOf(',') + 2, names.length());

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) != ' ') {
                firstNameSum += firstName.charAt(i);
            }
        }

        for (int i = 0; i < secondName.length(); i++) {
            if (secondName.charAt(i) != ' ') {
                secondNameSum += secondName.charAt(i);
            }
        }

        if (firstNameSum > secondNameSum) {
            System.out.println(firstName);
        } else if (secondNameSum > firstNameSum) {
            System.out.println(secondName);
        } else {
            System.out.println("The two names have equal sum of their characters ASCII codes!");
            System.out.println(names);
        }
    }
}
