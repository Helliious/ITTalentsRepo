public class Task12 {
    public static void main(String[] args) {
        printNumbersWithDiffDigits(100);
    }

    static void printNumbersWithDiffDigits(int start) {
        if (start > 999) {
            System.out.println();
        } else {
            int tempNum = start;
            int thirdDigit = tempNum % 10;
            int firstDigit = tempNum / 100;
            tempNum /= 10;
            int secondDigit = tempNum % 10;

            if (firstDigit != secondDigit && secondDigit != thirdDigit && firstDigit != thirdDigit) {
                System.out.print(start);
                if (start < 987) {
                    System.out.print(", ");
                }
            }

            printNumbersWithDiffDigits(++start);
        }

    }
}
