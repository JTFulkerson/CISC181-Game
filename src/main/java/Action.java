public abstract class Action {
    private Game game;
    private int rowIndexBoardSquare; // from square
    private int columnIndexBoardSquare; // from square
    private int rowIndexUnit; // to square
    private int columnIndexUnit; // to square

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
}
