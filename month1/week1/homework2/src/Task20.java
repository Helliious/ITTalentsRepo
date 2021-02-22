public class Task20 {
    public static void main(String[] args) {
        int number;

        for (int i = 1; i <= 10; i++) {
            number = i;

            if(number > 9) {
                number = 0;
            }

            for (int j = 0; j < 10; j++) {
                System.out.print(number + " ");
                number++;

                if(number > 9) {
                    number = 0;
                }
            }

            System.out.println();
        }
    }
}
