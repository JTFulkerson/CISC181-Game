/**
 * Name: Attacker
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program is a child class of Unit that represents a unit that can attack
 * other units. It is an abstract class that cannot be instantiated.
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-19-2023
 * @version Attacker v1.0
 */

public abstract class Attacker extends Unit {
    private int numAttacks; // number of attacks

    /**
     * 15 parameter constructor for the Attacker class
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
     * @param numAttacks
     */
    public Attacker(char symbol, String name, double health, double healthModifier, double damage,
            double damageModifier,
            int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numAttacks) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier,
                teamColor);
        this.numAttacks = numAttacks;
    }

    public int getNumAttacks() {
        return this.numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    /**
     * This method returns true if the unit can attack another unit
     * 
     * @param rowIndexBoardSquare
     * @param columnIndexBoardSquare
     * @param rowIndexUnit
     * @param columnIndexUnit
     * @return boolean: true if the unit can attack another unit
     */
    public boolean validAttackPath(int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
            int columnIndexUnit) {
        return true;
    }
}
