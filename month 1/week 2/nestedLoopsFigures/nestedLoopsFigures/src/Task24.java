public class Task24 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            if (i == 0 || i == 4 || i == 8) {
                for (int j = 0; j < 9; j++) {
                    if (j == 0 || j == 4 || j== 8) {
                        System.out.print("+");
                    } else {
                        System.out.print("=");
                    }
                }
            } else {
                for (int j = 0; j < 9; j++) {
                    if (j == 0 || j == 4 || j== 8) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }
    }
}
