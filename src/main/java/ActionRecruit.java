/**
 * Name: ActionRecruit
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program is a child class of Action that represents the recruit action
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version ActionRecruit v1.0
 */
public class ActionRecruit extends Action {

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
    public ActionRecruit(Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        super(game, rowIndexBoardSquare, columnIndexBoardSquare, rowIndexUnit, columnIndexUnit);
    }

    /**
     * This method performs the recruit action
     */
    @Override
    public void performAction() {
        this.game.getOpponentPlayer().getPlayersTeam().removeUnitsFromTeam(
                this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare].getUnit());
        this.game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(
                this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare].getUnit());
        this.game.changeTurn();
    }
}
