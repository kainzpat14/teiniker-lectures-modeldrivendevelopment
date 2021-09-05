package org.se.lab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Spoiler alert: This code is awful. How many flaws can you find?
 */
public class Main {

    public static void main(String[] args) {
        startGame();
    }

    static private Scanner scanner = new Scanner(System.in);

    private static final String i =
            "Let's play a round of tic tac toe!\n" +
                    "\n" +
                    "The first player is 'x', the second one is 'o'. In order to set your symbol on a position, simply enter the indicating number.\n" +
                    "\n" +
                    "|---|---|---|\n" +
                    "| 1 | 2 | 3 |\n" +
                    "|-----------|\n" +
                    "| 4 | 5 | 6 |\n" +
                    "|-----------|\n" +
                    "| 7 | 8 | 9 |\n" +
                    "|---|---|---|\n" +
                    "\n" +
                    "So for an example, enter '1' to set your symbol on position 1.\n" +
                    "|---|---|---|\n" +
                    "| x | 2 | 3 |\n" +
                    "|-----------|\n" +
                    "| 4 | 5 | 6 |\n" +
                    "|-----------|\n" +
                    "| 7 | 8 | 9 |\n" +
                    "|---|---|---|\n" +
                    "\n" +
                    "The first player to get 3 of his symbols in a row (up, down, across, or diagonally) is the winner.\n" +
                    "\n" +
                    "Ready to play a game now? (y/n)";

    static String in = "Let's play a round of tic tac toe!\n" +
            "\n" +
            "[i]nstruction\n" +
            "[s]tart game\n" +
            "[q]uit application\n";

    /**
     * Allows the user to either read the instruction, start a game or quit the application.
     */
    private static void startGame() {
        String menuSelection = "initial";

        ArrayList allowedInput = new ArrayList<String>() {{
            add("i");
            add("s");
            add("q");
        }};

        System.out.println(in);
        while (!allowedInput.contains(menuSelection.toLowerCase().trim())) {
            menuSelection = scanner.next();
            switch (menuSelection) {
                case "i": {
                    System.out.println(i);

                    menuSelection = "initial";

                    ArrayList iAllowedInput = new ArrayList<String>() {{
                        add("y");
                        add("n");
                    }};

                    while (!iAllowedInput.contains(menuSelection.toLowerCase())) {
                        menuSelection = scanner.next();
                        switch (menuSelection) {
                            case "y":
                                playGame();
                            case "n":
                                System.exit(0);
                            default:
                                System.out.println("\n'" + menuSelection + "' is an invalid input. \nEnter either \n- y for yes, in order to start another round or \n- n for no, in order to quit the application ");
                                break;
                        }
                    }}
                case "s":
                    playGame();
                case "q":
                    System.exit(0);
                default:
                    System.out.println("\n'"+menuSelection + "' is an invalid input.\nEither enter \n- i for instructions \n- s for starting a game or \n- q for quitting the application");
                    break;
            }
        }
    }

    private enum Value {x, o}

    /**
     * Provides the whole game logic
     */
    private static void playGame() {
        //TODO: Possible extension for the future: Make the board size dynamic.
        Value[][] board = new Value[4][4];
        int roundNo = 1;

        renderBoard(board);

        Value currentPlayer;
         while(true) {
            if(roundNo % 2 != 0 )
            {
                currentPlayer = Value.x;
            }
            else{
                currentPlayer = Value.o;
            }

            System.out.println("Player "+currentPlayer+" set your target position (xy).");
            int x = 0;
            int y = 0;
             while(true) {
                String input = scanner.next();

                if(!input.matches("[1-3][1-3]")) {
                    System.out.println("The input '" + input + "' is invalid. \nPlayer " + currentPlayer + " set a valid position (xy).");
                }
                else
                {
                    x = Integer.parseInt(input.substring(0, 1));
                    y = Integer.parseInt(input.substring(1, 2));

                    if (board[x][y] != null) {
                        System.out.println("The entered positions '" + input + "' is already in use. \nPlayer " + currentPlayer + " set a valid position (xy).");
                    }
                    else
                    {
                        break;
                    }
                }
            }

            board[x][y] = currentPlayer;

            checkWinningConditions(board, currentPlayer, x, y);

            renderBoard(board);
            roundNo++;
    }}

    /**
     * Checks whether a user won.
     * @param board
     * @param currentPlayer
     * @param x - x coordinate
     * @param y - y coordinate
     */
    private static void checkWinningConditions(Value[][] board, Value currentPlayer, int x, int y) {

        for(int i = 1; i < 4; i++){
            // When one of the entries in the column does not belong to the current player, no win.
            if(board[x][i] != currentPlayer)
                break;
            if(i == 3){
                sucessMessageUndGameNeustart(currentPlayer, board);
            }
        }

        for(int i = 1; i < 4; i++){
            // When one of the entries in the row does not belong to the current player, no win.
            if(board[i][y] != currentPlayer)
                break;
            if(i == 3){
                sucessMessageUndGameNeustart(currentPlayer, board);
            }
        }

        // When x equals y we are for sure on a diagonal
        if(x == y){
            // Now we iterate throw all possibilities (1/1,2/2...)
            for(int i = 1; i < 4; i++){
                // When one of the entries in the row does not belong to the current player, no win.
                if(board[i][i] != currentPlayer)
                    break;
                if(i == 3){
                    sucessMessageUndGameNeustart(currentPlayer, board);
                }
            }
        }

        // When having a 3x3, the second possible diagonal must always have a sum of 4 e.g 1/3 or 2/2.
        if(x + y == 4){
            for(int i = 1; i < 4; i++){
                // When one of the entries in the row does not belong to the current player, no win.
                if(board[i][(4)-i] != currentPlayer)
                    break;
                if(i == 3){
                    sucessMessageUndGameNeustart(currentPlayer, board);
                }
            }
        }
    }

    /**
     * Validates whether this move resulted in a win of the current player.
     * @param currentPlayer
     * @param board
     */
    private static void sucessMessageUndGameNeustart(Value currentPlayer, Value[][] board) {
        renderBoard(board);
        System.out.println("Player "+ currentPlayer +" won! Another round? (y/n)");

        String menuSelection = "initial";

        ArrayList allowedInput = new ArrayList<String>() {{
            add("y");
            add("n");
        }};

        while (!allowedInput.contains(menuSelection.toLowerCase())) {
            menuSelection = scanner.next();
            switch (menuSelection) {
                case "y":
                    playGame();
                case "n":
                    System.exit(0);
                default:
                    System.out.println("\n'" + menuSelection + "' is an invalid input.\nEnter either \n- y for yes, in order to start another round or \n- n for no, in order to quit the application ");
                    break;
            }
        }
    }

    /**
     * Renders the board in the console.
     * @param board
     */
    private static void renderBoard(Value[][] board) {
        StringBuilder builder = new StringBuilder();
        builder.append("|---|---|---|\n");
        for (int x = 1; x <= 3; x++) {
            builder.append("|");
            for (int y = 1; y <= 3; y++) {
                String value = board[x][y] == null ? " " : String.valueOf(board[x][y]);
                builder.append(" " + value + " |");
            }
            builder.append("\n");
        }
        builder.append("|---|---|---|");
        builder.append("\n");

        System.out.println(builder);
    }
}

