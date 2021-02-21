public class Task23 {
    public static void main(String[] args) {
        int number = 1;
        int iter = 1;

        while (number <= 9) {
            System.out.print(number + "*" + iter + "; ");
            iter++;

            if (iter > 9) {
                iter = ++number;
                System.out.println();
            }
        }
    }
}
