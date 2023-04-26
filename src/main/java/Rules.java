
/**
 * Name: Rules
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates the rules that allow move, spawn, recruit, and attack to
 * be used
 *
 * @author Brandon Nauta, John Fulkerson and Seth Thompson
 * @since 04-20-2023
 * @version Rules v2.0
 */

public class Rules {
    public static boolean checkValidAction(Game game, int unitRowFrom, int unitColumnFrom, int unitRowTo,
            int unitColumnTo, char action) {
        boolean isValidAction = false;
        if (game.getBoard().inBounds(unitRowTo, unitColumnTo)
                && game.getBoard().inBounds(unitRowFrom, unitColumnFrom)) {
            BoardSquare[][] gameBoard = game.getBoard().getSquares();
            if (action == 'M') {
                if (!gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().teamColor
                            .equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        if (gameBoard[unitRowTo][unitColumnTo].isEmpty()) {
                            if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().validMovePath(unitRowFrom,
                                    unitColumnFrom, unitRowTo, unitColumnTo)) {
                                isValidAction = true;
                            } else {
                                System.out.println("The unit must be able to move, your path is blocked!");
                            }
                        } else {
                            System.out.println("The to square must be empty!");
                        }
                    } else {
                        System.out.println("The unit being moved must be on the "
                                + game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team!");
                    }
                } else {
                    System.out.println("The from square must have a unit!");
                }
            } else if (action == 'S') {
                // if the space the unit has to move to is empty
                if (gameBoard[unitRowTo][unitColumnTo].isEmpty() && !gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    // if the current Unit is and instance of Unit
                    if (fromSquareUnit instanceof BartSimpsonUnit) {
                        // if the current unit has the same color as the current team
                        if (fromSquareUnit.getTeamColor()
                                .equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                            // if validMovePath is true
                            if (fromSquareUnit.validSpawnPath(unitRowFrom, unitColumnFrom, unitRowTo, unitColumnTo)) {
                                // if the unit canSpawn
                                if (fromSquareUnit.canSpawn()) {
                                    isValidAction = true;
                                } else {
                                    System.out.println("The unit must be able to spawn!");
                                }
                            } else {
                                System.out.println("The validSpawnPath must be true!");
                            }
                        } else {
                            System.out.println("From Square's unit has to be on the " + fromSquareUnit.getTeamColor()
                                    + " player's team!");
                        }
                    } else {
                        System.out.println("In order to attack the from Square unit needs to be a BartSimpsonUnit (B)");
                    }
                } else {
                    System.out.println("The from Square must have a unit, and the to square must not have a unit.");
                }
            } else if (action == 'R') {
                // if the space the unit has to move to is empty
                if (!(gameBoard[unitRowTo][unitColumnTo].isEmpty()
                        && gameBoard[unitRowFrom][unitColumnFrom].isEmpty())) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    Unit toSquareUnit = gameBoard[unitRowTo][unitRowTo].getUnit();
                    // if the To Square's Unit is on the other team
                    if (!toSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        // if the From Square's Unit is and instance of BartSimpsonUnit
                        if (fromSquareUnit instanceof BartSimpsonUnit) {
                            // if the From Square's Unit has the same color as the current team
                            if (fromSquareUnit.getTeamColor()
                                    .equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                // if validMovePath is true
                                if (((BartSimpsonUnit) fromSquareUnit).validRecruitPath(unitRowFrom, unitColumnFrom,
                                        unitRowTo, unitColumnTo)) {
                                    // if the unit canRecruit
                                    if (((BartSimpsonUnit) fromSquareUnit).canRecruit()) {
                                        isValidAction = true;
                                    } else {
                                        System.out.println("The from Square unit must be able to recruit!");
                                    }
                                } else {
                                    System.out.println("The validRecruitPath must be true!");
                                }
                            } else {
                                System.out.println("From Square's unit has to be on the "
                                        + fromSquareUnit.getTeamColor() + " player's team!");
                            }
                        } else {
                            System.out.println(
                                    "In order to attack the from Square unit needs to be a BartSimpsonUnit (B)");
                        }
                    } else {
                        System.out.println("The toSquare's unit needs to be on the" + fromSquareUnit.getTeamColor()
                                + " player's team!!");
                    }
                } else {
                    System.out.println("The coordinates you entered need to contain units.");
                }
            } else if (action == 'A') {
                // the toSquare and fromSquare are not empty
                if (!(gameBoard[unitRowTo][unitColumnTo].isEmpty()
                        && gameBoard[unitRowFrom][unitColumnFrom].isEmpty())) {
                    Unit fromSquareUnit = gameBoard[unitRowFrom][unitRowFrom].getUnit();
                    Unit toSquareUnit = gameBoard[unitRowTo][unitRowTo].getUnit();
                    // if the To Square's Unit is on the other team
                    if (!toSquareUnit.getTeamColor().equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                        // if the From Square's Unit is and instance of TomJerryUnit
                        if (fromSquareUnit instanceof TomJerryUnit) {
                            // if the From Square's Unit has the same color as the current team
                            if (fromSquareUnit.getTeamColor()
                                    .equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                // if validAttackPath is true
                                if (((TomJerryUnit) fromSquareUnit).validAttackPath(unitRowFrom, unitColumnFrom,
                                        unitRowTo, unitColumnTo)) {
                                    isValidAction = true;
                                } else {
                                    System.out.println("The validAttackPath must be true!");
                                }
                            } else {
                                System.out.println("From Square's unit has to be on the "
                                        + fromSquareUnit.getTeamColor() + " player's team!");
                            }
                        } else {
                            System.out
                                    .println("In order to attack the from Square unit needs to be a TomJerryUnit (T)");
                        }
                    } else {
                        System.out.println("The toSquare's unit needs to be on the" + fromSquareUnit.getTeamColor()
                                + " player's team!!");
                    }
                } else {
                    System.out.println("The coordinates you entered need to contain units.");
                }
            }
        }
        return isValidAction;
    }
}