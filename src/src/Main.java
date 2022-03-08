/*
===========================================
- Title:  Tic Tac Toe
- Author: @zerot69
- Date:   08 Mar 2022
============================================
*/

package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //Printing simple menu
        System.out.println("Tic-tac-toe");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");
        System.out.print(  "Enter your number (1-9): ");


        //Initializing variables
        Scanner scanner = new Scanner(System.in);
        int userMove;
        int moveCount = 0;
        boolean checkWinning = false;
        String[][] gameArray = {
                {"   ","   ","   "},
                {"   ","   ","   "},
                {"   ","   ","   "}
        };


        //Checking input from user
        while (!checkWinning){
            if (scanner.hasNextInt()) {
                userMove = scanner.nextInt();
                while (userMove > 9 || userMove < 1  || !"   ".equals(gameArray[(userMove-1) / 3][(userMove-1) % 3])){
                    System.out.print("Invalid input! Try again: ");
                    if (scanner.hasNextInt()) {
                        userMove = scanner.nextInt();
                    } else {
                        scanner.next();
                    }
                }
            } else {
                scanner.next();
                continue;
            }
            userMove--; //because the array begins with 0 instead of 1 (0-8 instead of 1-9)
            if (moveCount % 2 == 0) gameArray[userMove/3][userMove%3] = " X ";
            else gameArray[userMove/3][userMove%3] = " O ";
            moveCount++;


            //Checking winning situations: There are 8 winning situations for each player.
            // 1 | 2 | 3
            //---+---+---
            // 4 | 5 | 6
            //---+---+---
            // 7 | 8 | 9
            //Winning situations: 1,2,3 - 1,4,7 - 1,5,9 - 2,5,8 - 3,6,9 - 3,5,7 - 4,5,6 - 7,8,9
            //And I use if else because im lazy af :-)
            if (gameArray[0][0].equals(gameArray[0][1]) && gameArray[0][0].equals(gameArray[0][2]) && !gameArray[0][0].equals("   ")) checkWinning = true;
            else if (gameArray[0][0].equals(gameArray[1][0]) && gameArray[0][0].equals(gameArray[2][0]) && !gameArray[0][0].equals("   ")) checkWinning = true;
            else if (gameArray[0][0].equals(gameArray[1][1]) && gameArray[0][0].equals(gameArray[2][2]) && !gameArray[0][0].equals("   ")) checkWinning = true;
            else if (gameArray[0][1].equals(gameArray[1][1]) && gameArray[0][1].equals(gameArray[2][1]) && !gameArray[0][1].equals("   ")) checkWinning = true;
            else if (gameArray[0][2].equals(gameArray[1][2]) && gameArray[0][2].equals(gameArray[2][2]) && !gameArray[0][2].equals("   ")) checkWinning = true;
            else if (gameArray[0][2].equals(gameArray[1][1]) && gameArray[0][2].equals(gameArray[2][0]) && !gameArray[0][2].equals("   ")) checkWinning = true;
            else if (gameArray[1][0].equals(gameArray[1][1]) && gameArray[1][0].equals(gameArray[1][2]) && !gameArray[1][0].equals("   ")) checkWinning = true;
            else if (gameArray[2][0].equals(gameArray[2][1]) && gameArray[2][0].equals(gameArray[2][2]) && !gameArray[2][0].equals("   ")) checkWinning = true;


            //Printing the board
            for (int i=0; i<9; i++){
                if (i == 0) System.out.println();

                if (i == userMove) System.out.print("\u001B[34m" + gameArray[i/3][i%3] + "\u001B[0m"); //Coloring the last move
                else System.out.print(gameArray[i/3][i%3]);

                if (i % 3 == 2 && i != 8) System.out.println("\n---+---+---");
                else if (i != 8) System.out.print("|");
                else if (moveCount == 9  && !checkWinning) {
                    System.out.println("\n\nTied!");
                    checkWinning = true;
                    break;
                } else if (checkWinning){
                    if (moveCount % 2 ==0) System.out.println("\n\nO wins!");
                    else System.out.println("\n\nX wins!");
                } else {
                    System.out.print("\n\nEnter your number (1-9): ");
                }
            }
        }
    }
}
