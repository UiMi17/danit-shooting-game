package net.uimi;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = '-';
        Random rand = new Random();
        int targetX = rand.nextInt(5);
        int targetY = rand.nextInt(5);
        System.out.println("All Set. Get ready to rumble!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGamingField(board);
            int x = validateInput(scanner, "Enter the row to shoot (1-5): ") - 1;
            int y = validateInput(scanner, "Enter the column to shoot (1-5): ") - 1;
            if (x == targetX && y == targetY) {
                board[x][y] = 'x';
                printGamingField(board);
                System.out.println("You have won!");
                break;
            } else {
                board[x][y] = '*';
            }
        }
    }


    private static void printGamingField(char[][] board) {
        System.out.println("  1 2 3 4 5");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int validateInput(Scanner scanner, String prompt) {
        int number;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0 || number > 5);
        return number;
    }
}