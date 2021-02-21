import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        boolean isMagicCube = true;
        int sizeArr;
        int[][] arr;
        int currSumRows = 0;
        int currSumCols = 0;
        int currSumDiag = 0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter array size: ");
            sizeArr = sc.nextInt();
        } while (sizeArr < 1);

        arr = new int[sizeArr][sizeArr];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                do {
                    System.out.print("Enter element [" + i + "][" + j + "]: ");
                    arr[i][j] = sc.nextInt();
                } while (arr[i][j] < 1 || arr[i][j] > 20);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[0][i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                currSumRows += arr[i][j];
                currSumCols += arr[j][i];
            }

            if (currSumRows != sum || currSumCols != sum) {
                isMagicCube = false;
                break;
            }

            currSumRows = 0;
            currSumCols = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            currSumDiag += arr[i][i];
        }

        if (currSumDiag != sum) {
            isMagicCube = false;
        }

        currSumDiag = 0;

        for (int i = 0; i < arr.length; i++) {
            currSumDiag += arr[i][(arr.length - 1) - i];
        }

        if (currSumDiag != sum) {
            isMagicCube = false;
        }

        if (isMagicCube) {
            System.out.println("Magic Cube, sum equal to: " + sum);
        } else {
            System.out.println("Not a Magic Cube!");
        }
    }
}
