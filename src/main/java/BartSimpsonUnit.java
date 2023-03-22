/**
 * Name: BartSimpson
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Bart Simpson Unit
 *
 * @author Brandon Nauta
 * @since 03-01-2023
 * @version BartSimpsonUnit v2.0
 */

public class BartSimpsonUnit extends Unit {
    private int numTimesSpawned; // The number of times this piece has spawned
    private boolean distract; // Can use special ability “distract”
    private boolean recruit; // Can recruit other units
    final static int MAX_NUM_SPAWNED = 1; // The maximum number of times this piece can spawn

    /**
     * This constructor accepts 14 parameters relating to the 14 private variable
     * fields.
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
     * @param numTimesSpawned  The number of times this piece has spawned
     * @param distract         Can use special ability “distract”
     * @param recruit          Can recruit other units
     * @param teamColor        The teams color
     */
    public BartSimpsonUnit(char symbol, String name, double health, double healthModifier, double damage,
            double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
            int numTimesSpawned, boolean distract, boolean recruit, String teamColor) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor,
                movement, movementModifier, teamColor);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;
    }

    /**
     * This constructor takes 0 parameters and sets all the private variables to
     * default values
     * using the 14 parameters constructor
     */
    public BartSimpsonUnit() {
        this('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0,
                5, 5, 1, 0, 0,
                true, true, "Unknown");
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public boolean isDistract() {
        return distract;
    }

    public void setDistract(boolean distract) {
        this.distract = distract;
    }

    public boolean isRecruit() {
        return recruit;
    }

    public void setRecruit(boolean recruit) {
        this.recruit = recruit;
    }

    /**
     * This method determines whether a unit can spawn another unit
     * 
     * @return Boolean representing whether a unit can spawn another unit
     */
    public boolean canSpawn() {
        return (symbol == Character.toUpperCase(symbol) && numTimesSpawned < MAX_NUM_SPAWNED);
    }

    /**
     * This method prints out "Unit Distracted!" if the distarct field is true
     */
    public void distracted() {
        if (distract) {
            System.out.println("Unit Distracted!");
        }
    }

    /**
     * This method spawns a new BartSimpsonUnit
     * 
     * @return A new BartSimpsonUnit
     */
    public BartSimpsonUnit spawn() {
        numTimesSpawned++;
        return new BartSimpsonUnit(Character.toLowerCase(symbol), "Bart Simpson", 100.0, 5.0,
                25.0, 10.0, 0, 1, 1, 1, 1, 0,
                true, true, "Unknown");
    }

}
