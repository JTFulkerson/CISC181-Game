public class BoardSquare {
    // Variables
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
        empty = true;
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
