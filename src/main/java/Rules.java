/**
 * Name: Rules
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates the rules that allow move, spawn, recruit, and attack to be used
 *
 * @author Brandon Nauta, John Fulkerson and Seth Thompson
 * @since 04-19-2023
 * @version Rules v1.0
 */
import java.util.ArrayList;

public class Rules {
    public static boolean checkValidAction(Game game, int unitRowFrom, int unitColumnFrom, int unitRowTo, int unitColumnTo, char action) {
        boolean isValidAction = false;
        if (game.getBoard().inBounds(unitRowTo, unitColumnTo) && game.getBoard().inBounds(unitRowFrom, unitColumnFrom)) {
            ArrayList<Unit> teamUnits = game.getCurrentPlayer().getPlayersTeam().getTeamUnits();
            BoardSquare[][] gameBoard = game.getBoard().getSquares();
            if (action == 'M') {
                // if the space the unit has to move to is empty
                if (gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    //if the current Unit is and instance of Unit
                    if (gameBoard[unitRowFrom][unitRowFrom].getUnit() instanceof Unit) {
                        // if the current unit has the same color as the current team
                        if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                            isValidAction = true;
                        }
                    }
                }
            } else if (action == 'S') {
                // if the space the unit has to move to is empty
                if (gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    //if the current Unit is and instance of Unit
                    if (gameBoard[unitRowFrom][unitRowFrom].getUnit() instanceof BartSimpsonUnit) {
                        // if the current unit has the same color as the current team
                        if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                            isValidAction = true;
                        }
                    }
                }
            } else if (action == 'R') {
                // if the space the unit has to move to is empty
                if (!gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    // if the To Square's Unit is on the other team
                    if (!gameBoard[unitRowTo][unitColumnTo].getUnit().getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        //if the From Square's Unit is and instance of BartSimpsonUnit
                        if (gameBoard[unitRowFrom][unitRowFrom].getUnit() instanceof BartSimpsonUnit) {
                            // if the From Square's Unit has the same color as the current team
                            if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                isValidAction = true;
                            }
                        }
                    }
                }

            } else if (action == 'A') {
                // if the space the unit has to move to is empty
                if (!gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    // if the To Square's Unit is on the other team
                    if (!gameBoard[unitRowTo][unitColumnTo].getUnit().getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        //if the From Square's Unit is and instance of TomJerryUnit
                        if (gameBoard[unitRowFrom][unitRowFrom].getUnit() instanceof TomJerryUnit) {
                            // if the From Square's Unit has the same color as the current team
                            if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                isValidAction = true;
                            }
                        }
                    }
                }
            }
        }
        return isValidAction;
    }
}
