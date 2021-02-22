import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        int day, month, year;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter day:");
        day = sc.nextInt();
        System.out.println("Enter month:");
        month = sc.nextInt();
        System.out.println("Enter year:");
        year = sc.nextInt();

        if ((day > 0 && day <= 31) && (month > 0 && month <=12) && year > 0) {
            if ((year % 4 == 0 || year % 400 == 0) && month == 2 && day == 29) {
                day = 1;
                month++;
            } else if ((year % 4 != 0 || year % 400 != 0) && month == 2 && day == 28) {
                day = 1;
                month++;
            } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) && day == 31) {
                day = 1;
                month++;
            } else if (month == 12 && day == 31) {
                day = 1;
                month = 1;
                year++;
            } else if (day == 30){
                day = 1;
                month++;
            } else {
                day++;
            }

            System.out.println("Next date:");
            System.out.println(day + "." + month + "." + year);
        } else {
            System.out.println("Wrong input! Input accurate day, month and year!");
        }
    }
}
