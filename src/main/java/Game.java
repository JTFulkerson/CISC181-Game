import java.util.Collections;

/**
 * Name: BartSimpson
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Game
 *
 * @author Brandon Nauta
 * @since 03-31-2023
 * @version Game v1.0
 */

public class Game {
    //Variables//

    private GameBoard gameBoard;
    private Player player1;
    private Player player2;

    ///////////////

    private void initializeGameBoard (int numRows, int numColumns) {
        this.gameBoard = new GameBoard(numRows, numColumns);
        for (int i = 0; i < this.player1.getTeam().getTeamUnits().size(); i++) {
            this.gameBoard.findRandomEmptySpace().setUnit(this.player1.getTeam().getTeamUnits().get(i));
        }
        for (int i = 0; i < this.player2.getTeam().getTeamUnits().size(); i++) {
            this.gameBoard.findRandomEmptySpace().setUnit(this.player2.getTeam().getTeamUnits().get(i));
        }
    }

    public Game (int numRows, int numColumns, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(numRows, numColumns);
    }

    public GameBoard getGameBoard () {
        return this.gameBoard;
    }

    public Player getCurrentPlayer () {
        if (this.player1.isTurn()) {
            return this.player1;
        }
        if (this.player2.isTurn()) {
            return this.player2;
        }
        return this.player1;
    }

    public Player getOpponentPlayer () {
        if (!(this.player1.isTurn())) {
            return this.player1;
        }
        if (!(this.player2.isTurn())) {
            return this.player2;
        }
        return this.player1;
    }

    public boolean isTurn (Player player) {
        return player.isTurn();
    }

    public BoardSquare[][] getBoardSquares () {
        return this.gameBoard.getSquares();
    }

    public void changeTurn () {
        boolean tempTurn = player1.isTurn();
        player1.setTurn(player2.isTurn());
        player2.setTurn(tempTurn);
    }

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }
}
