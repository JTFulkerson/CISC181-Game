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

    @Override
    public void performAction() {
        Unit fromUnit = this.game.getBoardSquares()[this.rowIndexBoardSquare][this.columnIndexBoardSquare].getUnit();
        this.game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(fromUnit);
        this.game.getBoardSquares()[this.rowIndexUnit][this.columnIndexUnit].setUnit(fromUnit);
    }
}
