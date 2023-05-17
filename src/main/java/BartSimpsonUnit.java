/**
 * Name: BartSimpsonUnit
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Bart Simpson Unit
 *
 * @author Brandon Nauta and John Fulkerson, and Seth Thompson
 * @since 03-22-2023
 * @version BartSimpsonUnit v3.0
 */

public class BartSimpsonUnit extends Recruiter {
    private boolean distract; // Can use special ability distract
    private boolean recruit; // Can recruit other units

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
     * @param distract         Can use special ability distract
     * @param recruit          Can recruit other units
     * @param teamColor        The teams color
     * @param numRecruits      The number of recruits
     */
    public BartSimpsonUnit(char symbol, String name, double health, double healthModifier, double damage,
            double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
            int numTimesSpawned, boolean distract, boolean recruit, String teamColor, int numRecruits) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor,
                movement, movementModifier, teamColor, numRecruits, numTimesSpawned);
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
                true, true, "Unknown", 0);
    }

    public boolean canDistract() {
        return this.distract;
    }

    public void setDistract(boolean distract) {
        this.distract = distract;
    }

    public boolean canRecruit() {
        return this.recruit;
    }

    public void setRecruit(boolean recruit) {
        this.recruit = recruit;
    }

    /**
     * This method determines whether a unit can spawn another unit
     * 
     * @return Boolean representing whether a unit can spawn another unit
     */

    @Override
    public boolean canSpawn() {
        return (this.symbol == Character.toUpperCase(symbol) && this.numTimesSpawned < MAX_NUM_SPAWNED);
    }

    /**
     * This method prints out "Unit Distracted!" if the distarct field is true
     */
    public void distracted() {
        if (this.distract) {
            System.out.println("Unit Distracted!");
        }
    }

    /**
     * This method spawns a new BartSimpsonUnit
     * 
     * @return A new BartSimpsonUnit
     */
    @Override
    public BartSimpsonUnit spawn() {
        this.numTimesSpawned++;
        return new BartSimpsonUnit(Character.toLowerCase(this.symbol), "Bart Simpson", 100.0, 5.0,
                25.0, 10.0, 0, 1, 1, 1, 1, 0,
                true, true, this.teamColor, 0);
    }

    /**
     * BartSimpsonUnit can move any number of spaces up and down the column but no
     * spaces across the row
     * 
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is moving to
     * @param toSquareColumn   The column of the square the unit is moving to
     * @return True if the unit can move to the square, false otherwise
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return (fromSquareColumn == toSquareColumn && fromSquareRow != toSquareRow) || (Math.abs(fromSquareColumn - toSquareColumn) <= 2 && ((toSquareRow-fromSquareRow) >= 0));
    }

    /**
     * BartSimpsonUnit can recruit any number of spaces up and down the column but
     * no spaces across the row
     * 
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is attacking
     * @param toSquareColumn   The column of the square the unit is attacking
     * @return True if the unit can recruit the square, false otherwise
     */
    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareColumn, int toSquareRow,
            int toSquareColumn) {
        return this.validMovePath(fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }

    /**
     * BartSimpsonUnit can attack any number of spaces up and down the column but no
     * spaces across the row
     * 
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is attacking
     * @param toSquareColumn   The column of the square the unit is attacking
     * @return True if the unit can attack the square, false otherwise
     */
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareColumn, int toSquareRow,
            int toSquareColumn) {
        return this.validMovePath(fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }

}
