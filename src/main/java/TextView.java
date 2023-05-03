
/**
 * Name: TextView
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a TextView that can be used to display the game
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version TextView v1.0
 */

import java.util.Scanner;

public class TextView {
    private int rowIndexBoardSquareMakingAction; // Represents row index of board square with Unit making Action (From
                                                 // Square)
    private int columnIndexBoardSquareMakingAction; // Represents column index of board square with Unit making Action
                                                    // (From Square)
    private int rowIndexBoardSquareReceivingAction; // Represents row index of the board square to be receiving the
                                                    // Action (To Square)
    private int columnIndexBoardSquareReceivingAction; // Represents column index of the board square to be receiving
                                                       // the Action (To Square)
    private char actionType; // action type chosen by player

    public int getRowIndexBoardSquareMakingAction() {
        return rowIndexBoardSquareMakingAction;
    }

    public int getColumnIndexBoardSquareMakingAction() {
        return columnIndexBoardSquareMakingAction;
    }

    public int getRowIndexBoardSquareReceivingAction() {
        return rowIndexBoardSquareReceivingAction;
    }

    public int getColumnIndexBoardSquareReceivingAction() {
        return columnIndexBoardSquareReceivingAction;
    }

    public char getActionType() {
        return actionType;
    }

    /**
     * @param scnr only parameter representing a Scanner object (new Scanner)
     * @return character representing users move, if invalid user is prompted to
     *         enter valid character
     */
    public static char getUsersNextActionType(Scanner scnr) {
        boolean legal = false;
        String input = "";
        while (!legal) {
            System.out.print("Enter either A (attack), M (Move), R (Recruit), S (Spawn): ");
            input = scnr.next().toUpperCase(); // allows both upper and lowercase
            if (input.charAt(0) == 'A' || input.charAt(0) == 'M' || input.charAt(0) == 'R' || input.charAt(0) == 'S') {
                legal = true;
            } else {
                System.out.println("Invalid Character");
            }
        }
        return input.charAt(0);
    }

    /**
     * @param min  minimum value of range
     * @param max  maximum value of range
     * @param scnr Scanner object
     * @return int representing a valid integer in the range of min to max
     */
    public static int getValidInt(int min, int max, Scanner scnr) {
        boolean inRange = false;
        int input = 0;
        while (!inRange) {
            System.out.print("Enter an integer in the range " + min + " to " + max + ": ");
            if (scnr.hasNextInt()) { // checks if scanner object has another integer
                input = Integer.parseInt(scnr.next()); // turns string into integer
                if (input >= min && input <= max) {
                    inRange = true;
                } else {
                    System.out.println("Not in range");
                }
            } else {
                System.out.println("Invalid Input");
                scnr.next();
            }
        }
        return input;
    }

    /**
     * Prompts user for input for all of the action variables and sets the instance
     * variables of the TextView
     * 
     * @param game Game object
     * @return void
     */
    public void getNextPlayersAction(Game game) {
        Scanner scnr = new Scanner(System.in);
        this.actionType = getUsersNextActionType(scnr);
        System.out.print("Row index of the 'from square'. ");
        this.rowIndexBoardSquareMakingAction = getValidInt(0, game.getBoardSquares().length - 1, scnr);
        System.out.print("Column index of the 'from square'. ");
        this.columnIndexBoardSquareMakingAction = getValidInt(0, game.getBoardSquares()[0].length - 1, scnr);
        System.out.print("Row index of the 'to square'. ");
        this.rowIndexBoardSquareReceivingAction = getValidInt(0, game.getBoardSquares().length - 1, scnr);
        System.out.print("Column index of the 'to square'. ");
        this.columnIndexBoardSquareReceivingAction = getValidInt(0, game.getBoardSquares()[0].length - 1, scnr);
    }

    /**
     * Prints the game board to the console
     * 
     * @param game Game object
     * @return void
     */
    public void updateView(Game game) {
        System.out.print(game);
    }

    /**
     * Prints the end of game message to the console
     * 
     * @param game Game object
     * @return void
     */
    public void printEndOfGameMessage(Game game) {
        System.out.println("Game Over");
        System.out.println("Player number " + game.getWinner().getPlayerNumber()
                + game.getWinner().getPlayersTeam().getTeamColor() + " on the " + "team wins!");
    }
}
