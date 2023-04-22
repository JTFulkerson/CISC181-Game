/**
 * Name: BoardSquare
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a BoardSquare
 *
 * @author Brandon Nauta and John Fulkerson
 * @since 04-3-2023
 * @version GameBoard v1.0
 */

public class BoardSquare {
    protected boolean empty;
    protected Unit unit;
    protected String squareColor;

    /**
     * Constructor for BoardSquare
     * 
     * @param color The color of the square
     * 
     */
    public BoardSquare(String color) {
        this.squareColor = color;
        this.empty = true;
        unit = null;
    }

    // Accessors
    public boolean isEmpty() {
        return this.empty;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public String getSquareColor() {
        return this.squareColor;
    }

    // Mutators

    /**
     * This method sets the unit in the square
     * 
     * @param unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
        this.empty = false;
    }

    /**
     * This method removes the unit from the square
     * 
     * @return The unit that was removed
     */
    public Unit removeUnit() {
        Unit temp = this.unit;
        this.unit = null;
        this.empty = true;
        return temp;
    }

    /**
     * This method returns the string representation of the square
     * 
     * @return The string representation of the square
     */
    public String toString() {
        if (this.empty) {
            return "-------";
        } else {
            return "-" + this.unit.toString() + "-";
        }
    }
}
