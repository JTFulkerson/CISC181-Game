/**
 * Name: Action
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for an Action that can be performed by a unit
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version Action v1.0
 */

public abstract class Action {
    protected Game game;
    protected int rowIndexBoardSquare; // from square
    protected int columnIndexBoardSquare; // from square
    protected int rowIndexUnit; // to square
    protected int columnIndexUnit; // to square

    /**
     * The constructor for the Action class that accepts the parameters (Game) game,
     * (int) rowIndexBoardSquare, (int) columnIndexBoardSquare, (int) rowIndexUnit,
     * and (int) columnIndexUnit
     * 
     * @param game                   The game object
     * @param rowIndexBoardSquare    The row index of the board square
     * @param columnIndexBoardSquare The column index of the board square
     * @param rowIndexUnit           The row index of the unit
     * @param columnIndexUnit        The column index of the unit
     * @return void
     */
    public Action(Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        this.game = game;
        this.rowIndexBoardSquare = rowIndexBoardSquare;
        this.columnIndexBoardSquare = columnIndexBoardSquare;
        this.rowIndexUnit = rowIndexUnit;
        this.columnIndexUnit = columnIndexUnit;
    }

    public abstract void performAction();
}
