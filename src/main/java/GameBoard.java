/**
 * Name: BartSimpson
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a GameBoard
 *
 * @author Brandon Nauta
 * @since 03-22-2023
 * @version GameBoard v1.0
 */
public class GameBoard {
    //Variables//

    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    //////////

    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return numRows;
    }
    public int getNumColumns() {
        return numColumns;
    }
    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds (int rowIndex, int columnIndex) {
        if (rowIndex > this.squares.length || columnIndex > this.squares[rowIndex].length) {
            return false;
        }
        return true;
    }
    private void setUpEmptyBoard () {
        for (int i = 0; i < this.squares.length; i++) {
            for (int j = 0; j < this.squares[i].length; j++) {
                this.squares[i][j] = new BoardSquare("White");
            }
        }
    }

    public BoardSquare findRandomEmptySpaced () {
        boolean emptySpace = false;
        int row = 0;
        int column = 0;
        while (!emptySpace) {
            row = (int) (Math.random() * squares.length);
            column = (int) (Math.random() * squares[0].length);
            if (squares[row][column].isEmpty()) {
                emptySpace = true;
            }
        }
        return squares[row][column];
    }

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
