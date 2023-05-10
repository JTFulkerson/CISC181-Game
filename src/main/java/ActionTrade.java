public class ActionTrade extends Action {

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
    public ActionTrade(Game game, int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
                        int columnIndexUnit) {
        super(game, rowIndexBoardSquare, columnIndexBoardSquare, rowIndexUnit, columnIndexUnit);
    }

    @Override
    public void performAction () {
        Unit toSquareUnit = this.game.getBoardSquares()[rowIndexBoardSquare][columnIndexBoardSquare].getUnit();
        Unit fromSquareunit = this.game.getBoardSquares()[rowIndexUnit][columnIndexUnit].getUnit();
        DukeUnit newUnit = new DukeUnit();
        this.game.getBoardSquares()[rowIndexBoardSquare][columnIndexBoardSquare].removeUnit();
        this.game.getBoardSquares()[rowIndexUnit][columnIndexUnit].removeUnit();
        this.game.getBoardSquares()[rowIndexUnit][columnIndexUnit].setUnit(newUnit);

        this.game.getCurrentPlayer().getPlayersTeam().addUnitsToTeam(newUnit);
        this.game.getCurrentPlayer().getPlayersTeam().removeUnitsFromTeam(fromSquareunit);
        this.game.getCurrentPlayer().getPlayersTeam().removeUnitsFromTeam(toSquareUnit);
        this.game.changeTurn();
    }
}
