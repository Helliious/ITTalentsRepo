import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        int firstPosX, firstPosY;
        int secondPosX, secondPosY;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first position X:");
        firstPosX = sc.nextInt();
        System.out.println("Enter first position Y:");
        firstPosY = sc.nextInt();
        System.out.println("Enter second position X:");
        secondPosX = sc.nextInt();
        System.out.println("Enter second position Y:");
        secondPosY = sc.nextInt();

        if ((firstPosX > 0 && firstPosX <= 8) && (firstPosY > 0 && firstPosY <= 8) &&
                (secondPosX > 0 && secondPosX <= 8) && (secondPosY > 0 && secondPosY <= 8)) {
            if (((firstPosX + firstPosY) % 2 == 0) && ((secondPosX + secondPosY) % 2 == 0)) {
                System.out.println("Positions are with the same color!");
            } else {
                System.out.println("Positions are with different color!");
            }
        } else {
            System.out.println("Wrong input! Coordinates must be between 1 and 8!");
        }
    }
}
