
/**
 * Name: Game
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Game
 *
 * @author Brandon Nauta and John Fulkerson
 * @since 04-3-2023
 * @version Game v1.0
 */

import java.util.Collections;

public class Game {
    private GameBoard board;
    private Player player1;
    private Player player2;

    /**
     * Initializes the game board
     * 
     * @param numRows    number of rows
     * @param numColumns number of columns
     */
    private void initializeGameBoard(int numRows, int numColumns) {
        this.board = new GameBoard(numRows, numColumns);
        for (int i = 0; i < this.player1.getPlayersTeam().getTeamUnits().size(); i++) {
            this.board.findRandomEmptySpace().setUnit(this.player1.getPlayersTeam().getTeamUnits().get(i));
        }
        for (int i = 0; i < this.player2.getPlayersTeam().getTeamUnits().size(); i++) {
            this.board.findRandomEmptySpace().setUnit(this.player2.getPlayersTeam().getTeamUnits().get(i));
        }
    }

    /**
     * Constructor for Game with 4 parameters
     * 
     * @param numRows    number of rows
     * @param numColumns number of columns
     * @param player1    player 1
     * @param player2    player 2
     * 
     */
    public Game(int numRows, int numColumns, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player2.setTurn(false);
        initializeGameBoard(numRows, numColumns);
    }

    /**
     * Returns the game board
     * 
     * @return GameBoard: game board
     */
    public GameBoard getBoard() {
        return this.board;
    }

    /**
     * Returns the current player by checking if it is their turn
     * 
     * @return Player: current player
     */
    public Player getCurrentPlayer() {
        if (this.player1.isTurn()) {
            return this.player1;
        } else {
            return this.player2;
        }
    }

    /**
     * returns the opponent player
     * 
     * @return Player: opponent player
     */
    public Player getOpponentPlayer() {
        if (this.player1.isTurn()) {
            return this.player2;
        } else {
            return this.player1;
        }
    }

    /**
     * Returns true if it is the player's turn
     * 
     * @param player
     * @return boolean: true if it is the player's turn
     */
    public boolean isTurn(Player player) {
        return player.isTurn();
    }

    /**
     * Returns the game board
     * 
     * @return BoardSquare[][]: game board
     */
    public BoardSquare[][] getBoardSquares() {
        return this.board.getSquares();
    }

    /**
     * Changes the turn of the game
     */
    public void changeTurn() {
        boolean tempTurn = player1.isTurn();
        player1.setTurn(player2.isTurn());
        player2.setTurn(tempTurn);
    }

    /**
     * Returns a String representation of the game board and the teams
     * 
     * @return String: representation of the game board
     */
    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns() * 8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s ("
                        + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

}
