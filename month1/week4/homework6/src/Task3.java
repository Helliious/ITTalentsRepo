public class Task3 {
    public static void main(String[] args) {
        oddNumbers(-10, 10);
    }

    static void oddNumbers(int beginRange, int endRange) {
        if (beginRange == endRange) {
            if (beginRange % 2 != 0) {
                System.out.print(beginRange);
            }
        } else {
            if (beginRange % 2 != 0) {
                System.out.print(beginRange + " ");
            }

            oddNumbers(++beginRange, endRange);
        }
    }
}
