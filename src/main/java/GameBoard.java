/**
 * Name: BartSimpson
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a GameBoard
 *
 * @author Brandon Nauta and John Fulkerson
 * @since 04-3-2023
 * @version GameBoard v1.0
 */
public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    /**
     * Constructor for GameBoard with 2 parameters
     * 
     * @param numRows    number of rows
     * @param numColumns number of columns
     */
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

    /**
     * Returns the board squares
     * 
     * @return BoardSquare[][]: board squares
     */
    public BoardSquare[][] getSquares() {
        return squares;
    }

    /**
     * Checks to see if a given row and column are in bounds
     * 
     * @param rowIndex    row index
     * @param columnIndex column index
     * @return boolean: true if in bounds, false if not
     */
    public boolean inBounds(int rowIndex, int columnIndex) {
        return rowIndex >= 0 && rowIndex < this.squares.length && columnIndex >= 0
                && columnIndex < this.squares[0].length;
    }

    /**
     * Sets up the empty board with white squares
     */
    private void setUpEmptyBoard() {
        for (int i = 0; i < this.squares.length; i++) {
            for (int j = 0; j < this.squares[i].length; j++) {
                this.squares[i][j] = new BoardSquare("White");
            }
        }
    }

    /**
     * Finds a random empty space on the board
     * 
     * @return BoardSquare: random empty space
     */
    public BoardSquare findRandomEmptySpace() {
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

    /**
     * Returns the board as a string
     * 
     * @return String: board as a string
     */
    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for (int col = 0; col < squares[0].length; col++) {
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for (int row = 0; row < squares.length; row++) {
            boardString.append("Row : " + row + "   ");
            for (int col = 0; col < squares[row].length; col++) {
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}