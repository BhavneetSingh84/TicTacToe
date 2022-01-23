package games;

/*
    Game: TIC TAC TOE
    Developed by: Bhavneet Singh
    Date developed: May 12, 2021
*/

import java.util.Scanner;

public class TicTacToeGame1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // skeleton of the game
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        while (true){

            // invoking the method for the player
            playerTurn(gameBoard, in);
            printGameBoard(gameBoard);       // printing the move

            // invoking the method for the player
            computerTurn(gameBoard);
            printGameBoard(gameBoard);     // printing the move

            isGameFinished(gameBoard);     // check for the draw

        }

    }  // end of the main method

    public static boolean isGameFinished(char[][] gameBoard) {

        if (result(gameBoard,'X')){
            printGameBoard(gameBoard);
            System.out.println("User has won the Game!");
            return true;
        }
        if (result(gameBoard,'O')){
            printGameBoard(gameBoard);
            System.out.println("Computer has won the Game!");
            return true;
        }

        // problem is in this loop
        for (int i = 0; i < gameBoard.length; i+=2) {
            for (int j = 0; j < gameBoard[i].length; j += 2) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }

        printGameBoard(gameBoard);
        System.out.println("the game ended in a tie!");


        return true;
    }

    // method to check the results
    public static boolean result(char[][] gameBoard, char symbol) {
        if ((gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol) ||
                (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol) ||
                (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol) ||
                (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol) ||

                (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol) ||
                (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol) ) {

            return true;
        }

        return false;
    }

    // check the player's input has a space
    private static void playerTurn(char[][] gameBoard, Scanner in) {
        int firstPlayerMove;

        while (true) {
        System.out.print("please enter your move from 1-9: ");
        firstPlayerMove = in.nextInt();

            if (isValidMove(gameBoard, firstPlayerMove)){
                break;
            }
            else {
                System.out.print(firstPlayerMove + " is not a valid move\n");
            }
        }
        playMove(gameBoard, firstPlayerMove, 'X');
    }


    // check the player's input has a space
    private static void computerTurn(char[][] gameBoard) {
        int computerMove;
        while (true) {
            computerMove = 1 + (int) (Math.random() * 9);
            if (isValidMove(gameBoard, computerMove)){
                break;
            }
        }
        System.out.println("computer choose to: "+computerMove);
        playMove(gameBoard, computerMove, 'O');
    }

    //method to print the structure of the game
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char e : row) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    // to arrange the move to the desired position in the game
    public static void playMove(char[][] gameBoard, int firstPlayerMove , char choice) {

        switch (firstPlayerMove) {
            case 1:
                gameBoard[0][0] = choice;
                break;
            case 2:
                gameBoard[0][2] = choice;
                break;
            case 3:
                gameBoard[0][4] = choice;
                break;
            case 4:
                gameBoard[2][0] = choice;
                break;
            case 5:
                gameBoard[2][2] = choice;
                break;
            case 6:
                gameBoard[2][4] = choice;
                break;
            case 7:
                gameBoard[4][0] = choice;
                break;
            case 8:
                gameBoard[4][2] = choice;
                break;
            case 9:
                gameBoard[4][4] = choice;
                break;
            default:
                System.out.print(":(");
        }
    }

    // for validation of the move
    public static boolean isValidMove (char[][] gameBoard, int position){
        switch (position) {
            case 1:
                return gameBoard[0][0] == ' ';
            case 2:
                return gameBoard[0][2] == ' ';
            case 3:
                return gameBoard[0][4] == ' ';
            case 4:
                return gameBoard[2][0] == ' ';
            case 5:
                return gameBoard[2][2] == ' ';
            case 6:
                return gameBoard[2][4] == ' ';
            case 7:
                return gameBoard[4][0] == ' ';
            case 8:
                return gameBoard[4][2] == ' ';
            case 9:
                return gameBoard[4][4] == ' ';
            default:
                return false;
        }
    }

}    // End of the Class
