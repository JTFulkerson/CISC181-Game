/**
 * Name: ActionAttack
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program is a child class of Action that represents the attack action
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version ActionAttack v1.0
 */
public class ActionAttack extends Action {

    /**
     * This constructor accepts 5 parameters relating to the super classes member
     * fields
     * 
     * @param game                   The game object
     * @param rowIndexBoardSquare    The row index of the board square
     * @param columnIndexBoardSquare The column index of the board square
     * @param rowIndexUnit           The row index of the unit
     * @param columnIndexUnit        The column index of the unit
     */
    public ActionAttack(Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        super(game, rowIndexBoardSquare, columnIndexBoardSquare, rowIndexUnit, columnIndexUnit);
    }

    /**
     * This method will execute the attack action as long as the current unit is a
     * TomJerryUnit
     */
    @Override
    public void performAction() {
        boolean dead = false;
        Unit attackingUnit = this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare]
                .getUnit();
        Unit attackedUnit = this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].getUnit();
        if (attackingUnit instanceof TomJerryUnit) {
            if (attackedUnit instanceof TomJerryUnit) {
                ((TomJerryUnit) attackedUnit).takeDamage(((TomJerryUnit) attackingUnit).dealDamage());
                if (attackedUnit.getHealth() <= 0.0) {
                    this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].removeUnit();
                    this.game.getOpponentPlayer().getPlayersTeam().removeUnitsFromTeam(attackedUnit);
                    dead = true;
                }
            }
            if (attackedUnit instanceof JesterUnit) {
                //assumption that DukeUnit does not attack
                double attackingUnitTotalDamage= ((TomJerryUnit) attackingUnit).dealDamage();
                double attackedUnitHealth = attackedUnit.getHealth() + attackedUnit.getHealthModifier();
                if (attackingUnitTotalDamage >= attackedUnitHealth && attackedUnit.canSpawn()) {
                    // find and empty space
                    BoardSquare emptySpace = this.game.getBoard().findRandomEmptySpace();
                    // spawn a new unit
                    JesterUnit newUnit = ((JesterUnit) attackedUnit).spawn();
                    this.game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(newUnit);
                    emptySpace.setUnit(newUnit);
                }
                this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].removeUnit();
                this.game.getOpponentPlayer().getPlayersTeam().removeUnitsFromTeam(attackedUnit);
                dead = true;
            }
            else {
                this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].removeUnit();
                this.game.getOpponentPlayer().getPlayersTeam().removeUnitsFromTeam(attackedUnit);
                dead = true;
            }
        }
        if (dead) {
            this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare].removeUnit();
            this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].setUnit(attackingUnit);
        }
        this.game.changeTurn();
    }

    @Override
    public String toString() {

        return game.getCurrentPlayer().getPlayersTeam().getTeamColor() + " teams "
                + game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare]
                        .getUnit().getName()
                + " unit attacks from " + this.rowIndexBoardSquare + "," + this.columnIndexBoardSquare + " to "
                + this.rowIndexUnit + ","
                + this.columnIndexUnit;

    }
}
