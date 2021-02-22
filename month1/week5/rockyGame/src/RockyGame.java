import java.util.Scanner;

public class RockyGame {
    public static void main(String[] args) {
        char rockSymbol = (char)64;
        char hoOmanSymbol = (char)33;
        int[] hoOmanPos = new int[2];
        int[] rockPos = new int[2];

        gameInterface(hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);
    }

    //Creating initial map and assigning values to all parameters
    static void initMap(char[][] arr, int numberOfBushes,
                        char hoOmanSymbol, char rockSymbol,
                        int[] hoOmanPos, int[] rockPos) {
        int[] tempRockPos = new int[2];
        int posX, posY;

        //initialising the map and setting the End point
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == arr.length - 1 && j == arr[i].length - 1) {
                    arr[i][j] = 'E';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < numberOfBushes; i++) {
            do {
                //setting bushes on random positions on map
                posX = (int)(Math.random() * arr.length);
                posY = (int)(Math.random() * arr[0].length);
            } while (arr[posX][posY] == '*' ||
                    arr[posX][posY] == 'E' ||
                    (posX + 1 == arr.length && posY == arr[0].length));

            arr[posX][posY] = '*';
        }

        do {
            //setting the rock on a random position
            posX = (int)(Math.random() * arr.length);
            posY = (int)(Math.random() * arr[0].length);
            tempRockPos[0] = posX;
            tempRockPos[1] = posY;
        } while (arr[posX][posY] == '*' ||
                arr[posX][posY] == 'E' ||
                losingCondition(arr, tempRockPos) ||
                (posX + 1 == arr.length && posY == arr[0].length));

        arr[posX][posY] = rockSymbol;
        rockPos[0] = posX;
        rockPos[1] = posY;

        do {
            //setting character at a random position
            posX = (int)(Math.random() * arr.length);
            posY = (int)(Math.random() * arr[0].length);
        } while (arr[posX][posY] == '*' ||
                arr[posX][posY] == 'E' ||
                arr[posX][posY] == rockSymbol ||
                (posX + 1 == arr.length && posY == arr[0].length));

        arr[posX][posY] = hoOmanSymbol;
        hoOmanPos[0] = posX;
        hoOmanPos[1] = posY;
    }

    //Map drawing
    static void drawMap(char[][] arr) {
        //printing top border
        System.out.print("\t\t\t\t   +");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t\t\t\t   |");
            //printing the matrix elements
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }

        //printing bottom border
        System.out.print("\t\t\t\t   +");
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    //Character moving method
    static void makeMove(char[][] arr, char hoOmanSymbol, char rockSymbol,
                         int[] hoOmanPos, int[] rockPos) {
        char direction;
        Scanner sc = new Scanner(System.in);

        //getting direction by the player
        System.out.print("Enter direction(U/D/L/R): ");
        direction = sc.nextLine().charAt(0);

        //updating the map with the new positions of character and rock
        if (isValidMove(arr, direction, hoOmanPos, rockPos)) {
            arr[rockPos[0]][rockPos[1]] = rockSymbol;
            arr[hoOmanPos[0]][hoOmanPos[1]] = hoOmanSymbol;
        } else {
            makeMove(arr, hoOmanSymbol,  rockSymbol, hoOmanPos, rockPos);
        }
    }

    //checking if the entered move is valid
    static boolean isValidMove(char[][] arr, char direction,
                               int[] hoOmanPos, int[] rockPos) {
        int nextPosHoOmanX, nextPosHoOmanY;
        int nextPosRockX, nextPosRockY;

        //checking valid input by player
        if (direction != 'U' &&
                direction != 'D' &&
                direction != 'L' &&
                direction != 'R') {
            System.out.println("You must enter a valid direction!");
            return false;
        }

        //calculating new positions of character and rock
        switch (direction) {
            case 'U':
                nextPosHoOmanX = hoOmanPos[0] - 1;
                nextPosHoOmanY = hoOmanPos[1];
                if (nextPosHoOmanX < 0 ||
                        arr[nextPosHoOmanX][nextPosHoOmanY] == '*') {
                    return false;
                } else if (nextPosHoOmanX == rockPos[0] && nextPosHoOmanY == rockPos[1]) {
                    nextPosRockX = rockPos[0] - 1;
                    nextPosRockY = rockPos[1];
                    if (nextPosRockX < 0 ||
                            arr[nextPosRockX][nextPosRockY] == '*') {
                        return false;
                    } else {
                        arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                        hoOmanPos[0] = nextPosHoOmanX;
                        rockPos[0] = nextPosRockX;
                        return true;
                    }
                } else {
                    arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                    hoOmanPos[0] = nextPosHoOmanX;
                    return true;
                }
            case 'D':
                nextPosHoOmanX = hoOmanPos[0] + 1;
                nextPosHoOmanY = hoOmanPos[1];
                if (nextPosHoOmanX > arr.length - 1 ||
                        arr[nextPosHoOmanX][nextPosHoOmanY] == '*') {
                    return false;
                } else if (nextPosHoOmanX == rockPos[0] && nextPosHoOmanY == rockPos[1]) {
                    nextPosRockX = rockPos[0] + 1;
                    nextPosRockY = rockPos[1];
                    if (nextPosRockX > arr.length - 1 ||
                            arr[nextPosRockX][nextPosRockY] == '*') {
                        return false;
                    } else {
                        arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                        hoOmanPos[0] = nextPosHoOmanX;
                        rockPos[0] = nextPosRockX;
                        return true;
                    }
                } else {
                    arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                    hoOmanPos[0] = nextPosHoOmanX;
                    return true;
                }
            case 'L':
                nextPosHoOmanX = hoOmanPos[0];
                nextPosHoOmanY = hoOmanPos[1] - 1;
                if (nextPosHoOmanY < 0 ||
                        arr[nextPosHoOmanX][nextPosHoOmanY] == '*') {
                    return false;
                } else if (nextPosHoOmanX == rockPos[0] && nextPosHoOmanY == rockPos[1]) {
                    nextPosRockX = rockPos[0];
                    nextPosRockY = rockPos[1] - 1;
                    if (nextPosRockY < 0 ||
                            arr[nextPosRockX][nextPosRockY] == '*') {
                        return false;
                    } else {
                        arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                        hoOmanPos[1] = nextPosHoOmanY;
                        rockPos[1] = nextPosRockY;
                        return true;
                    }
                } else {
                    arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                    hoOmanPos[1] = nextPosHoOmanY;
                    return true;
                }
            case 'R':
                nextPosHoOmanX = hoOmanPos[0];
                nextPosHoOmanY = hoOmanPos[1] + 1;
                if (nextPosHoOmanY > arr[0].length - 1 ||
                        arr[nextPosHoOmanX][nextPosHoOmanY] == '*') {
                    return false;
                } else if (nextPosHoOmanX == rockPos[0] && nextPosHoOmanY == rockPos[1]) {
                    nextPosRockX = rockPos[0];
                    nextPosRockY = rockPos[1] + 1;
                    if (nextPosRockY > arr[0].length - 1 ||
                            arr[nextPosRockX][nextPosRockY] == '*') {
                        return false;
                    } else {
                        arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                        hoOmanPos[1] = nextPosHoOmanY;
                        rockPos[1] = nextPosRockY;
                        return true;
                    }
                } else {
                    arr[hoOmanPos[0]][hoOmanPos[1]] = ' ';
                    hoOmanPos[1] = nextPosHoOmanY;
                    return true;
                }
        }

        return false;
    }

    //Winning Condition -> getting to End point - E
    static boolean winningCondition(char[][] arr, int[] rockPos) {
        return rockPos[0] == arr.length - 1 && rockPos[1] == arr[0].length - 1;
    }

    //Losing condition -> hitting left or upper border,
    //rock being surrounded by bushes, or a wall and a bush
    static boolean losingCondition(char[][] arr, int[] rockPos) {
        int posX = rockPos[0];
        int posY = rockPos[1];

        //hitting left or upper border
        if (posX == 0 || posY == 0) {
            return true;
        }

        //rock being disabled by bushes
        if ((posX < arr.length - 1 && posX > 0) &&
                (posY < arr[0].length - 1 && posY > 0)) {
            if ((arr[posX + 1][posY] == '*' && arr[posX][posY + 1] == '*') ||
                    (arr[posX + 1][posY] == '*' && arr[posX][posY - 1] == '*') ||
                    (arr[posX - 1][posY] == '*' && arr[posX][posY + 1] == '*') ||
                    (arr[posX - 1][posY] == '*' && arr[posX][posY - 1] == '*')) {
                return true;
            }
        }

        // rock being disabled by a bush and a wall
        if ((posX == arr.length - 1 && arr[posX][posY + 1] == '*') ||
                (posX == arr.length - 1 && arr[posX][posY - 1] == '*')) {
            return true;
        }

        if ((posY == arr[0].length - 1 && arr[posX + 1][posY] == '*') ||
                (posY == arr[0].length - 1 && arr[posX - 1][posY] == '*')) {
            return true;
        }

        return false;
    }

    //Sign representing the grieve of the loser
    static void printSignOfShame() {
        int signHeight = 6;
        int symbolWidth = 10;
        int spaceBetweenSymbols = 3;
        int spaceIdx = symbolWidth;

        for (int i = 0; i < signHeight; i++) {
            System.out.print("\t");
            //L
            if (i == signHeight - 1) {
                for (int j = 0; j < symbolWidth; j++) {
                    System.out.print("-");
                }
            } else {
                System.out.print("|");
                for (int j = 0; j < symbolWidth - 1; j++) {
                    System.out.print(" ");
                }
            }

            for (int j = 0; j < spaceBetweenSymbols; j++) {
                System.out.print(" ");
            }

            //O
            if (i == 0 || i == signHeight - 1) {
                for (int j = 0; j < symbolWidth; j++) {
                    System.out.print("-");
                }
            } else {
                for (int j = 0; j < symbolWidth ; j++) {
                    if (j == 0 || j == symbolWidth - 1) {
                        System.out.print("|");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            for (int j = 0; j < spaceBetweenSymbols; j++) {
                System.out.print(" ");
            }

            //S
            if (i == 0 || i == (signHeight -1) / 2 || i == signHeight - 1) {
                for (int j = 0; j < symbolWidth; j++) {
                    if (j == 0 && i == (signHeight -1) / 2) {
                        System.out.print("|");
                    } else if (j > 0 && i == (signHeight -1) / 2) {
                        System.out.print("_");
                    } else {
                        System.out.print("-");
                    }
                }
            } else {
                if (i > (signHeight - 1) /2) {
                    for (int j = 0; j < symbolWidth - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("|");
                } else {
                    System.out.print("|");
                    for (int j = 0; j < symbolWidth - 1; j++) {
                        System.out.print(" ");
                    }
                }
            }

            for (int j = 0; j < spaceBetweenSymbols; j++) {
                System.out.print(" ");
            }

            //E
            if (i == 0 || i == (signHeight -1) / 2 || i == signHeight - 1) {
                for (int j = 0; j < symbolWidth; j++) {
                    if (j == 0 && i == (signHeight -1) / 2) {
                        System.out.print("|");
                    } else if (j > 0 && i == (signHeight -1) / 2) {
                        System.out.print("_");
                    } else {
                        System.out.print("-");
                    }
                }
            } else {
                System.out.print("|");
                for (int j = 0; j < symbolWidth - 1; j++) {
                    System.out.print(" ");
                }
            }

            for (int j = 0; j < spaceBetweenSymbols; j++) {
                System.out.print(" ");
            }

            //R
            if (i == 0 || i == (signHeight -1) / 2) {
                for (int j = 0; j < symbolWidth; j++) {
                    if ((j == 0 || j == symbolWidth - 1) &&
                            i == (signHeight -1) / 2) {
                        System.out.print("|");
                    } else if (j > 0 && i == (signHeight -1) / 2) {
                        System.out.print("_");
                    } else {
                        System.out.print("-");
                    }
                }
            } else {
                System.out.print("|");
                for (int j = 0; j < symbolWidth - 1; j++) {
                    if (j == symbolWidth - 2 && i < (signHeight - 1) / 2) {
                        System.out.print("|");
                    } else if (i < (signHeight - 1) / 2) {
                        System.out.print(" ");
                    }
                }

                if (i > (signHeight - 1) / 2) {
                    for (int j = 0; j < symbolWidth - spaceIdx; j++) {
                        System.out.print("  ");
                    }
                    spaceIdx--;
                    System.out.print("\\");
                }
            }

            System.out.println();
        }
    }

    //iterating one game
    static void gamePlay(char[][] arr, char hoOmanSymbol, char rockSymbol,
                         int[] hoOmanPos, int[] rockPos) {
        drawMap(arr);
        makeMove(arr, hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);

        if (winningCondition(arr, rockPos)) {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t  WINNER!\n");
            gameInterface(hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);
        } else if (losingCondition(arr, rockPos)) {
            System.out.println("\n\n\n");
            printSignOfShame();
            System.out.println("\n\n\n");
            gameInterface(hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);
        } else {
            gamePlay(arr, hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);
        }
    }

    //The game interface, getting all the initial data for the player
    static void gameInterface(char hoOmanSymbol, char rockSymbol,
                              int[] hoOmanPos, int[] rockPos) {
        char[][] arr;
        char playAgain;
        char gameDifficulty;
        int numberOfBushes;
        Scanner sc = new Scanner(System.in);

        //checking if Player want to play
        System.out.println("\t\t\t\t\t WELCOME TO ROCKY - THE GAME!\n");
        do {
            System.out.print("\t\t\t\t\t Do you wanna play? (y/n): ");
            playAgain = sc.nextLine().charAt(0);
        } while (playAgain != 'y' && playAgain != 'n');

        if (playAgain == 'y') {
            //Asking for game difficulty
            do {
                System.out.println("\t\t\t\t\t Choose difficulty:");
                System.out.println("A: Map - 10x30; 10% Bushes;");
                System.out.println("B: Map - 20x50; 20% Bushes;");
                System.out.println("C: Map - 30x80; 30% Bushes;");
                System.out.print("Your choice: ");
                gameDifficulty = sc.nextLine().charAt(0);
            } while (gameDifficulty != 'A' &&
                    gameDifficulty != 'B' &&
                    gameDifficulty != 'C');

            //calculating map size and bushes count by difficulty
            switch (gameDifficulty) {
                case 'B':
                    arr = new char[20][50];
                    numberOfBushes = (arr.length * arr[0].length) / 5;
                    break;
                case 'C':
                    arr = new char[30][80];
                    numberOfBushes = ((arr.length * arr[0].length) * 3) / 10;
                    break;
                default:
                    arr = new char[10][30];
                    numberOfBushes = (arr.length * arr[0].length) / 10;
                    break;
            }

            initMap(arr, numberOfBushes, hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);
            gamePlay(arr, hoOmanSymbol, rockSymbol, hoOmanPos, rockPos);
        } else {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t  END GAME");
        }
    }
}
