import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        int amount;
        int firstBucket = 2;
        int secondBucket = 3;
        int countTwoPlusThree = 0;
        int leftOver = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount of water:");
        amount = sc.nextInt();

        countTwoPlusThree = amount / (firstBucket + secondBucket);
        leftOver = amount - (countTwoPlusThree * (firstBucket + secondBucket));

        System.out.println(countTwoPlusThree + " times by 2 liters,");
        System.out.println(countTwoPlusThree + " times by 3 liters");

        if (leftOver == 1) {
            System.out.println("Sorry we can't take out 1 liter!");
        } else if (leftOver == 2) {
            System.out.println("Extra bucket of 2 liters");
        } else if (leftOver == 3) {
            System.out.println("Extra bucket of 3 liters");
        } else if (leftOver == 4) {
            System.out.println("2 Extra buckets of 2 liters");
        }
    }
}
