import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        int time;
        double amount;
        boolean isHealthy;

        Scanner sc = new Scanner(System.in);

        //Time is not used by the solution, but it is required by the task's condition!
        System.out.println("Enter time:");
        time = sc.nextInt();

        System.out.println("Enter amount:");
        amount = sc.nextDouble();
        System.out.println("Are you healthy?:");
        isHealthy = sc.nextBoolean();

        if (!isHealthy) {
            if (amount > 0.0) {
                System.out.println("I will buy myself some drugs!");
            } else {
                System.out.println("I will stay home and drink some tea!");
            }
        } else {
            if (amount < 10.0) {
                System.out.println("I'll go drink coffee!");
            } else {
                System.out.println("I'll go to the movies with friends!");
            }
        }
    }
}
