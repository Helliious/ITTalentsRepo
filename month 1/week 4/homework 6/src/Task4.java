public class Task4 {
    public static void main(String[] args) {
        System.out.println(showNumbersReverseSec(1, 10));
    }

    static void showNumbersReverse(int startNum, int endNum) {
        if (endNum == startNum) {
            System.out.println(endNum);
        } else {
            System.out.print(endNum + " ");
            showNumbersReverse(startNum, --endNum);
        }
    }

    static int showNumbersReverseSec(int startNum, int endNum) {
        if (endNum == startNum) {
            return endNum;
        } else {
            return endNum + showNumbersReverseSec(startNum, --endNum);
        }
    }
}
