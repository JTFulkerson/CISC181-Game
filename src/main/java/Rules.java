/**
 * Name: Rules
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates the rules that allow move, spawn, recruit, and attack to be used
 *
 * @author Brandon Nauta, John Fulkerson and Seth Thompson
 * @since 04-20-2023
 * @version Rules v2.0
 */
import java.util.ArrayList;

public class Rules {
    public static boolean checkValidAction(Game game, int unitRowFrom, int unitColumnFrom, int unitRowTo, int unitColumnTo, char action) {
        boolean isValidAction = false;
        if (game.getBoard().inBounds(unitRowTo, unitColumnTo) && game.getBoard().inBounds(unitRowFrom, unitColumnFrom)) {
            BoardSquare[][] gameBoard = game.getBoard().getSquares();
            if (action == 'M') {
                // if the space the unit has to move to is empty
                if (gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    //if the current Unit is and instance of Unit
                    if (fromSquareUnit != null) {
                        // if the current unit has the same color as the current team
                        if (fromSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                            // if validMovePath is true
                            if (fromSquareUnit.validMovePath(unitRowFrom,unitColumnFrom,unitRowTo,unitColumnTo)) {
                                isValidAction = true;
                            }
                        }
                    }
                }
            } else if (action == 'S') {
                // if the space the unit has to move to is empty
                if (gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    //if the current Unit is and instance of Unit
                    if (fromSquareUnit instanceof BartSimpsonUnit) {
                        // if the current unit has the same color as the current team
                        if (fromSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                            // if validMovePath is true
                            if (fromSquareUnit.validSpawnPath(unitRowFrom,unitColumnFrom,unitRowTo,unitColumnTo)) {
                                // if the unit canSpawn
                                if (fromSquareUnit.canSpawn()){
                                    isValidAction = true;
                                }
                            }
                        }
                    }
                }
            } else if (action == 'R') {
                // if the space the unit has to move to is empty
                if (!gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    Unit toSquareUnit = gameBoard[unitRowTo][unitRowTo].getUnit();
                    // if the To Square's Unit is on the other team
                    if (!toSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        //if the From Square's Unit is and instance of BartSimpsonUnit
                        if (fromSquareUnit instanceof BartSimpsonUnit) {
                            // if the From Square's Unit has the same color as the current team
                            if (fromSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                // if validMovePath is true
                                if (((BartSimpsonUnit) fromSquareUnit).validRecruitPath(unitRowFrom,unitColumnFrom,unitRowTo,unitColumnTo)) {
                                    // if the unit canRecruit
                                    if (((BartSimpsonUnit) fromSquareUnit).canRecruit()){
                                        isValidAction = true;
                                    }
                                }
                            }
                        }
                    }
                }

            } else if (action == 'A') {
                // if the space the unit has to move to is empty
                if (!gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    Unit toSquareUnit = gameBoard[unitRowTo][unitRowTo].getUnit();
                    // if the To Square's Unit is on the other team
                    if (!toSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        //if the From Square's Unit is and instance of TomJerryUnit
                        if (fromSquareUnit instanceof TomJerryUnit) {
                            // if the From Square's Unit has the same color as the current team
                            if (fromSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                // if validMovePath is true
                                if (((TomJerryUnit) fromSquareUnit).validAttackPath(unitRowFrom,unitColumnFrom,unitRowTo,unitColumnTo)) {
                                    isValidAction = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return isValidAction;
    }
}
