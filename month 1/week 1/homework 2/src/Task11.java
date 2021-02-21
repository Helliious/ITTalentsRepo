import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        int n;
        int numberOfSpaces;
        int numberOfStars = 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter N:");
        n = sc.nextInt();
        numberOfSpaces = n - 1;

        for (int i = 0; i < n; i++) {
            for(int k = numberOfSpaces; k > 0; k--) {
                System.out.print(" ");
            }

            //for drawing filled triangle --> make this part a comment
            //if you will run the empty triangle drawing part
            for (int j = 0; j < numberOfStars; j++) {
                System.out.print("*");
            }

            //for drawing empty triangle --> make this part a comment
            //if you will run the filled triangle drawing part
//            for (int j = 0; j < numberOfStars; j++) {
//                if (i > 0 && i < n - 1) {
//                    if (j == 0 || j == numberOfStars - 1) {
//                        System.out.print("*");
//                    } else {
//                        System.out.print(" ");
//                    }
//                } else {
//                    System.out.print("*");
//                }
//            }

            System.out.println();

            numberOfSpaces--;
            numberOfStars += 2;
        }
    }
}
