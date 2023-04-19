/**
 * Name: ActionSpawn
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for an ActionSpawn that can be performed by a
 * unit. This class extends the Action class.
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version ActionSpawn v1.0
 */

public class ActionSpawn extends Action {

    /**
     * The constructor for the ActionSpawn class that accepts the parameters (Game)
     * game, (int) rowIndexBoardSquare, (int) columnIndexBoardSquare, (int)
     * rowIndexUnit, and (int) columnIndexUnit
     * 
     * @param game                   The game object
     * @param rowIndexBoardSquare    The row index of the board square
     * @param columnIndexBoardSquare The column index of the board square
     * @param rowIndexUnit           The row index of the unit
     * @param columnIndexUnit        The column index of the unit
     * @return void
     */
    public ActionSpawn(Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        super(game, rowIndexBoardSquare, columnIndexBoardSquare, rowIndexUnit, columnIndexUnit);
    }

    /**
     * This method executes the spawn action
     */
    @Override
    public void performAction() {
        Unit fromUnit = this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare].getUnit();
        this.game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(fromUnit);
        this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].setUnit(fromUnit);
    }
}
