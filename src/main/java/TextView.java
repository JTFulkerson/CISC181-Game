import java.util.Random;
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
     * Generates a random number between 0 and the roll amount
     * 
     * @param random     giving a Random variable
     * @param playerNum  the number representing a player
     * @param rollAmount the amount rolled
     * @return A string in that returns player number and range of possible roll
     */
    public static int getValidInt(Random random, int playerNum, int rollAmount) {
        System.out.println("Player " + playerNum + " Rolling: 0 - " + rollAmount);
        return random.nextInt(rollAmount + 1);
    }

    /**
     * Prompts the user to do an action, and returns the action type
     * 
     * @param scnr takes in a scanner
     * @return string "/roll"
     */
    public static char getUsersNextActionType(Scanner scnr) {
        boolean validInput = false;
        String userInput = "";
        while (!validInput) {
            System.out.println("Type either 'M', 'R', 'A', or 'S'");
            userInput = scnr.next();
            if (userInput.equals("M") || userInput.equals("R") || userInput.equals("A") || userInput.equals("S")) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid input");
            }
        }
        return userInput.charAt(0);
    }

    public void getNextPlayersAction(Game game) {
        this.actionType = getUsersNextActionType(new Scanner(System.in));
    }
}
