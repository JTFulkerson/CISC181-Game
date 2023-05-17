/**
 * Name: TomJerryUnit
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Tom Jerry Unit
 *
 * @author Brandon Nauta and John Fulkerson, and Seth Thompson
 * @since 03-01-2023
 * @version TomJerryUnit v3.0
 */

public class TomJerryUnit extends Attacker {
    private boolean homingRocket; // Can use special attack "homing rocket"
    private boolean offerCheese; // Can use special ability "offer cheese"
    private boolean hiding; // Is the unit hidden on the board

    /**
     * This constructor accepts 14 parameters relating to the 14 private variable
     * fields.
     * 
     * @param symbol           The text representation of the piece (char)
     * @param name             The units name
     * @param health           The units base health
     * @param healthModifier   Modifications to units health
     * @param damage           The units base damage
     * @param damageModifier   Modifications to units damage
     * @param luck             Our random luck mechanism
     * @param xCor             Current cord on x-axis
     * @param yCor             Current cord on y-axis
     * @param movement         Amount unit can move
     * @param movementModifier Modifications to units movement
     * @param homingRocket     Can use special attack "homing rocket"
     * @param offerCheese      Can use special ability "offer cheese"
     * @param hiding           Is the unit hidden on the board
     * @param teamColor        The teams color
     * @param numAttacks       The number of attacks
     */
    public TomJerryUnit(char symbol, String name, double health, double healthModifier, double damage,
            double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
            boolean homingRocket, boolean offerCheese, boolean hiding, String teamColor, int numAttacks, int numTimeSpawned) {
        super(symbol, name, health, healthModifier, damage,
                damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor, numAttacks, numTimeSpawned);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    /**
     * This constructor takes 0 parameters and sets all the private variables to
     * default values
     * using the 14 parameters constructor
     */
    public TomJerryUnit() {
        this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0,
                5, 5, 1, 0,
                true, true, false, "Unknown", 0, 0);
    }

    public boolean canHomingRocket() {
        return this.homingRocket;
    }

    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }

    public boolean canOfferCheese() {
        return this.offerCheese;
    }

    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }

    public boolean isHiding() {
        return this.hiding;
    }

    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }

    /**
     * This method determines how much damage the unit will deal
     * 
     * @return Double representing the amount of damage the unit will deal
     */
    public double dealDamage() {
        double extraDamage = 0;
        extraDamage = (this.homingRocket) ? extraDamage + 10 : 0;
        return this.damage + this.damageModifier + extraDamage;
    }

    /**
     * This method determines how much health the unit will have left after taking
     * damage
     * 
     * @param damage The amount of damage the unit will take if it is not hiding
     */
    public void takeDamage(double damage) {
        this.health = (this.hiding) ? this.health : this.health - damage;
    }

    /**
     * This method spawns a new TomJerryUnit
     * 
     * @return A new TomJerryUnit
     */
    @Override
    public TomJerryUnit spawn() {
        this.numTimesSpawned++;
        return new TomJerryUnit(Character.toLowerCase(symbol), "Tom & Jerry", 100.0, 0.0,
                25.0, 0.0, 0,
                5, 5, 1, 0, true, true, false,
                this.teamColor, 0, 0);
    }

    @Override
    public boolean canSpawn() {
        return (this.symbol == Character.toUpperCase(symbol) && this.numTimesSpawned < MAX_NUM_SPAWNED);
    }

    /**
     * TomJerryUnit can move anywhere on the board
     * 
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is moving to
     * @param toSquareColumn   The column of the square the unit is moving to
     * @return Always returns true
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return true;
    }

    /**
     * Limits attack to only two spaces up or down the column but no spaces
     * across the row
     * 
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on:
     * @param toSquareRow      The row of the square the unit is attacking
     * @param toSquareColumn   The column of the square the unit is attacking
     * @return True if the attack is valid, false otherwise
     */
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareColumn, int toSquareRow,
            int toSquareColumn) {
        return (Math.abs(fromSquareRow - toSquareRow) == 0) || (Math.abs(fromSquareRow - toSquareRow) <= 2 && fromSquareColumn == toSquareColumn);
    }

    /**
     * TomJerryUnit can spawn anywhere on the board
     * 
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is spawning to
     * @param toSquareColumn   The column of the square the unit is spawning to
     * @return Always returns true
     */
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareColumn, int toSquareRow,
            int toSquareColumn) {
        return true;
    }
}