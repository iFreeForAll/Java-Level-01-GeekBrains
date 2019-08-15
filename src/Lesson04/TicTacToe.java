package Lesson04;

import com.sun.corba.se.impl.copyobject.FallbackObjectCopierImpl;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;
    static final int WIN_CONDITION = 4;
    static char[][] field = new char[SIZE_Y][SIZE_X];

    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '*';

    static Scanner sc  = new Scanner(System.in);
    static final Random rnd = new Random();

    //initializing our field, filling it with '*' elements
    public static void initializeField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    //printing our filed for user
    public static void printField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print('|');
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    //setting a give symbol in a given coordinates on our field
    public static void setSymbol(int y, int x, char symbol) {
        field[y][x] = symbol;
    }

    //player's turn, where he enters X, Y coordinates
    public static void playerStep(int x, int y) {
        setSymbol(y, x, PLAYER_DOT);
    }

    //AI turn, that checks if player can win or AI can win
    //otherwise it does a random turn
    public static void aiStep() {
        int x, y;

        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if(isCellValid(i, j)) {
                    setSymbol(i, j, AI_DOT);
                    if(checkWin()) {
                        setSymbol(i, j, AI_DOT);
                        return;
                    } else {
                        setSymbol(i, j, EMPTY_DOT);
                    }
                }
            }
        }

        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (isCellValid(i, j)) {
                    setSymbol(i, j, PLAYER_DOT);
                    if(checkWin()) {
                        setSymbol(i, j, AI_DOT);
                        return;
                    } else {
                        setSymbol(i, j, EMPTY_DOT);
                    }
                }
            }
        }

        do {
            x = rnd.nextInt(SIZE_X);
            y = rnd.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));

        setSymbol(y, x, AI_DOT);
    }

    //that function checks whether the cell that the player choose is valid in case of the field size
    //and it also checks if the cell is empty or not
    public static boolean isCellValid(int y, int x) {
        //checking if entered coordinates are valid
        if(x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }

        //checking whether the cell is empty or not
        return(field[y][x] == EMPTY_DOT);
    }

    //checking if the field is full or not
    public static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        System.out.println("Draw!");
        return true;
    }

    //old checking for win version, couldn't realize how to check diagonals
//    //checking if someone has won
//    public static boolean checkWin(char sym) {
//        int count;
//        //checking horizontal condition
//        for (int i = 0; i < SIZE_Y; i++) {
//            count = 0;
//            for (int j = 0; j < SIZE_X - 1; j++) {
//                if (field[i][j] == field[i][j + 1] && field[i][j] == sym) {
//                    count++;
//                } else {
//                    count = 0;
//                }
//                if (count == WIN_CONDITION - 1) {
//                    if (field[i][j] == PLAYER_DOT) {
//                        System.out.println("You win!");
//                        return true;
//                    } else {
//                        System.out.println("AI win!");
//                        return true;
//                    }
//                }
//            }
//        }
//
//        //checking for vertical condition
//        for (int i = 0; i < SIZE_X; i++) {
//            count = 0;
//            for (int j = 0; j < SIZE_Y - 1; j++) {
//                if (field[j][i] == field[j + 1][i] && field[j][i] == sym) {
//                    count++;
//                } else {
//                    count = 0;
//                }
//                if (count == WIN_CONDITION - 1) {
//                    if (field[j][i] == PLAYER_DOT) {
//                        System.out.println("You win!");
//                        return true;
//                    } else {
//                        System.out.println("AI win!");
//                        return true;
//                    }
//                }
//            }
//        }
//
//        //checking for diagonal condition
//        for (int i = 0; i < SIZE_Y; i++) {
//            count = 0;
//            for (int j = 0; j < SIZE_X - 1; j++) {
//                if(field[i][j] == field[i+1][j+1] && field[i][j] == sym) {
//                    count++;
//                }
//            }
//        }
//        return false;
//    }
    //checking for win condition, new version that uses algebraic vectors
    //works for any size of field
    public static boolean checkWin() {
        //we have 4 directions: horizontal, diagonal down, diagonal up and vertical
        int[][] directions = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        int count;
        for (int[] d : directions) {
            int dx = d[0];
            int dy = d[1];
            for (int i = 0; i < SIZE_X; i++) {
                for (int j = 0; j < SIZE_Y; j++) {
                    count = 0;
                    int lastX = i + (WIN_CONDITION - 1)*dx;
                    int lastY = j + (WIN_CONDITION - 1)*dy;
                    if(lastX >= 0 && lastX < SIZE_X && lastY >= 0 && lastY < SIZE_Y) {
                        char ch = field[i][j];
                        for (int k = 1; k < WIN_CONDITION; k++) {
                            if(ch != EMPTY_DOT && ch == field[i + k*dx][j + k*dy]){
                                count++;
                            }
                            if(count == WIN_CONDITION - 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int x, y;

        initializeField();
        printField();

        while(true) {
            do {
                System.out.println("Enter your X, Y coordinates (1-3): ");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(y, x));
            playerStep(x, y);
            printField();
            if(checkWin()) {
                System.out.println("You won!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("Draw!");
                break;
            }
            aiStep();
            printField();
            if(checkWin()) {
                System.out.println("AI won!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}