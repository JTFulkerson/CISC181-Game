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
public class ActionAttack extends Action{

    /**
     * This constructor accepts 5 parameters relating to the super classes member fields
     * @param game The game object
     * @param rowIndexBoardSquare The row index of the board square
     * @param columnIndexBoardSquare The column index of the board square
     * @param rowIndexUnit The row index of the unit
     * @param columnIndexUnit The column index of the unit
     */
    public ActionAttack (Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
                          int columnIndexUnit) {
        super(game, rowIndexBoardSquare, columnIndexBoardSquare, rowIndexUnit, columnIndexUnit);
    }

    /**
     * This method will execute the attack action as long as the current unit is a TomJerryUnit
     */
    @Override
    public void performAction () {
        boolean dead = false;
        Unit attackingUnit = this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare].getUnit();
        Unit attackedUnit = this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].getUnit();
        if (attackingUnit instanceof TomJerryUnit) {
            if (attackedUnit instanceof TomJerryUnit) {
                ((TomJerryUnit) attackedUnit).takeDamage(((TomJerryUnit) attackingUnit).dealDamage());
                if (attackedUnit.getHealth() <= 0.0) {
                    this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].removeUnit();
                    dead = true;
                }
            }
            this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].removeUnit();
            dead = true;
        }
        if (dead) {
            ActionMove move = new ActionMove(this.game, this.rowIndexBoardSquare, this. columnIndexBoardSquare,
                    this.rowIndexUnit, this.columnIndexUnit);
            move.performAction();
        }
        this.game.changeTurn();
    }
}
