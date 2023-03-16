
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author Ashi
 */
public class TicTacToe {
static Scanner sc = new Scanner(System.in);
//2d dimensional char array with 3x3
  static char[][] board = new char[3][3];
  static char turn = 'X';

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
        //nested loop
      for (int j = 0; j < 3; j++) {
        board[i][j] = ' ';
      }
    }
    while (true) {System.out.println("Current board:");
      printBoard();
      System.out.println("Player " + turn + ", enter your move (row[1-3] column[1-3]): ");
      int row = sc.nextInt() - 1;
      int col = sc.nextInt() - 1;
      if (board[row][col] != ' ') {
        System.out.println("That cell is already filled. Try again.");
        continue;
      }
      board[row][col] = turn;
      if (checkWin(row, col)) {
        System.out.println("Player " + turn + " wins!");
        break;
      }
      if (turn == 'X') {
        turn = 'O';
      } else {
        turn = 'X';
      }
    }
  }

  static boolean checkWin(int row, int col) {
    return checkRow(row) || checkCol(col) || checkDiag(row, col);
  }

  static boolean checkRow(int row) {
    for (int i = 0; i < 3; i++) {
      if (board[row][i] != turn) {
        return false;
      }
    }
    return true;
  }

  static boolean checkCol(int col) {
    for (int i = 0; i < 3; i++) {
      if (board[i][col] != turn) {
        return false;
      }
    }
    return true;
  }

  static boolean checkDiag(int row, int col) {
    if (row == col) {
      for (int i = 0; i < 3; i++) {
        if (board[i][i] != turn) {
          return false;
        }
      }
      return true;
    }
    if (row + col == 2) {
      for (int i = 0; i < 3; i++) {
        if (board[i][2 - i] != turn) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  static void printBoard() {
    for (int i = 0; i < 3; i++) {
      System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
      if (i != 2) {
        System.out.println("---+---+---");
      }
    }
  }
}