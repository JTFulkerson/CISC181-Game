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
            if (!gameBoard[unitRowFrom][unitColumnFrom].isEmpty()) {
                if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().teamColor
                        .equals(game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                    if (action == 'M') {
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
                    } else if (action == 'S') {
                        if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().canSpawn()) {
                            if (gameBoard[unitRowTo][unitColumnTo].isEmpty()) {
                                if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().validSpawnPath(unitRowFrom,
                                        unitColumnFrom, unitRowTo, unitColumnTo)) {
                                    isValidAction = true;
                                } else {
                                    System.out.println("The unit must be able to spawn, your path is blocked!");
                                }
                            } else {
                                System.out.println("The to square must be empty!");
                            }
                        }
                        else {
                            System.out.println("This unit cannot spawn!");
                        }
                    } else if (action == 'R') {
                        // Checks to see if unit is of type BartSimpsonUnit
                        if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof BartSimpsonUnit ||
                            gameBoard[unitRowFrom][unitColumnTo].getUnit() instanceof DukeUnit ||
                            gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof JesterUnit) {
                            if (!gameBoard[unitRowTo][unitColumnTo].isEmpty()) {
                                if (!gameBoard[unitRowTo][unitColumnTo].getUnit().getTeamColor()
                                        .equals(gameBoard[unitRowFrom][unitColumnFrom].getUnit().getTeamColor())) {
                                    if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof BartSimpsonUnit &&
                                            ((BartSimpsonUnit) (gameBoard[unitRowFrom][unitColumnFrom].getUnit()))
                                            .validRecruitPath(unitRowFrom,
                                                    unitColumnFrom, unitRowTo, unitColumnTo)) {
                                        isValidAction = true;
                                    }
                                    if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof DukeUnit &&
                                            ((DukeUnit) (gameBoard[unitRowFrom][unitColumnFrom].getUnit()))
                                                    .validRecruitPath(unitRowFrom,
                                                            unitColumnFrom, unitRowTo, unitColumnTo)) {
                                        isValidAction = true;
                                    }
                                    if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof JesterUnit &&
                                            ((JesterUnit) (gameBoard[unitRowFrom][unitColumnFrom].getUnit()))
                                                    .validRecruitPath(unitRowFrom,
                                                            unitColumnFrom, unitRowTo, unitColumnTo)) {
                                        isValidAction = true;
                                    } else {
                                        System.out.println(
                                                "The from unit must be able to recruit or your path is blocked!");
                                    }
                                } else {
                                    System.out.println("The to square must have an enemy unit!");
                                }
                            } else {
                                System.out.println("The to square must have a unit!");
                            }
                        } else {
                            System.out.println("The unit must be of type BartSimpsonUnit/DukeUnit/JesterUnit!");
                        }
                    } else if (action == 'A') {
                        if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof TomJerryUnit ||
                            gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof DukeUnit) {
                            if (!gameBoard[unitRowTo][unitColumnTo].isEmpty()) {
                                if (!gameBoard[unitRowTo][unitColumnTo].getUnit().getTeamColor()
                                        .equals(gameBoard[unitRowFrom][unitColumnFrom].getUnit().getTeamColor())) {
                                    if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof TomJerryUnit &&
                                            ((TomJerryUnit) (gameBoard[unitRowFrom][unitColumnFrom].getUnit()))
                                            .validAttackPath(unitRowFrom,
                                                    unitColumnFrom, unitRowTo, unitColumnTo)) {
                                        isValidAction = true;
                                    }
                                    if (gameBoard[unitRowFrom][unitColumnFrom].getUnit() instanceof DukeUnit &&
                                            ((DukeUnit) (gameBoard[unitRowFrom][unitColumnFrom].getUnit()))
                                                    .validAttackPath(unitRowFrom,
                                                            unitColumnFrom, unitRowTo, unitColumnTo)) {
                                        isValidAction = true;
                                    } else {
                                        System.out.println(
                                                "The from unit must be able to attack or your path is blocked!");
                                    }
                                } else {
                                    System.out.println("The to square must have an enemy unit!");
                                }
                            } else {
                                System.out.println("The to square must have a unit!");
                            }
                        } else {
                            System.out.println("The unit must be of type TomJerryUnit/DukeUnit!");
                        }
                    }
                    else if (action == 'T') {
                        if (!(gameBoard[unitRowTo][unitColumnTo].isEmpty())) {
                            if (gameBoard[unitRowTo][unitColumnTo].getUnit().teamColor.equals(
                                    game.getCurrentPlayer().getPlayersTeam().getTeamColor())) {
                                if (gameBoard[unitRowFrom][unitColumnFrom].getUnit().validTradePath(
                                        unitRowFrom, unitColumnFrom, unitRowTo, unitColumnTo)) {
                                    isValidAction = true;
                                }
                                else {
                                    System.out.println("Your trade path is blocked!");
                                }
                            }
                            else {
                                System.out.println("The unit you are trying to trade with must be on your team!");
                            }
                        }
                        else {
                            System.out.println("The to square must have a unit!");
                        }
                    }
                } else {
                    System.out.println("The unit on the from square must be on the "
                            + game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " team!");
                }
            } else {
                System.out.println("The from square must have a unit!");
            }
        }
        return isValidAction;
    }
}