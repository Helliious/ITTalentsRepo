public class Task12 {
    public static void main(String[] args) {
        int first, second, third;
        int number;

        for (int i = 100; i <= 999; i++) {
            number = i;
            third = number % 10;
            number = number / 10;
            second = number % 10;
            first = number / 10;

            if (first != second && first != third && second != third) {
                System.out.println(i);
            }
        }
    }
}
