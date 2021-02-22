public class Task1 {
    public static void main(String[] args) {
        numbersInRange(-20, 50);
    }

    static void numbersInRange(int firstNum, int lastNum) {
        if (firstNum == lastNum) {
            System.out.print(lastNum);
        } else {
            System.out.print(firstNum + " ");
            numbersInRange(++firstNum, lastNum);
        }
    }
}
