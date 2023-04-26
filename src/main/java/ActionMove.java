/**
 * Name: ActionMove
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program is a child class of Action that represents the move action
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version ActionMove v1.0
 */
public class ActionMove extends Action {

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
    public ActionMove(Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        super(game, rowIndexBoardSquare, columnIndexBoardSquare, rowIndexUnit, columnIndexUnit);
    }

    /**
     * This method executes the move action
     */
    @Override
    public void performAction() {
        Unit currentUnit = this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare]
                .removeUnit();
        this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].setUnit(currentUnit);
        this.game.changeTurn();
    }
}
