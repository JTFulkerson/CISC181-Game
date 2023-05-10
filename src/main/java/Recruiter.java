/**
 * Name: Recruiter
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program is a child class of Unit that represents a unit that can recruit
 * other units. It is an abstract class that cannot be instantiated.
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version Recruiter v1.0
 */

public abstract class Recruiter extends Unit {
    private int numRecruits; // number of recruits

    /**
     * 15 parameter constructor for the Recruiter class
     * 
     * @param symbol           The text representation of the piece
     * @param name             The units name
     * @param health           The units base health
     * @param healthModifier   Modifications to units health
     * @param damage           The units base damage
     * @param damageModifier   Modifications to units damage
     * @param luck             Our random luck mechanism
     * @param xCor             Current coord on x axis
     * @param yCor             Current coord on y axis
     * @param movement         Amount unit can move
     * @param movementModifier Modifications to units movement
     * @param teamColor        The teams color
     * @param numRecruits
     */
    public Recruiter(char symbol, String name, double health, double healthModifier, double damage,
            double damageModifier,
            int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits, int numTimesSpawned) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier,
                teamColor, numTimesSpawned);
        this.numRecruits = numRecruits;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    /**
     * This method returns true if the unit can recruit another unit
     * 
     * @param rowIndexBoardSquare
     * @param columnIndexBoardSquare
     * @param rowIndexUnit
     * @param columnIndexUnit
     * @return boolean: true if the unit can recruit another unit
     */
    public boolean validRecruitPath(int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        return true;
    }
}
