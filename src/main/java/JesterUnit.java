/**
 * Name: JesterUnit
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This class holds the definition of
 * a JesterUnit and its functionality
 *
 * JesterUnit has standard health, and half attack of other units, but it
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 05-12-2023
 * @version JesterUnit v1.0
 */
public class JesterUnit extends BartSimpsonUnit {

    final static int MAX_NUM_SPAWNED = 2;
    public JesterUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
                      int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits,
                      int numTimesSpawned, boolean distract, boolean recruit) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier,
        numTimesSpawned, distract, recruit, teamColor, numRecruits);
    }
    //initial case
    public JesterUnit() {
        this('J', "Jester", 100.0, 0.0, 0.0,0.0,
                10, 5, 6, 1, 0, "Unknown", 0,
                0, true, true);
    }

    @Override
    public boolean canSpawn() {

        return (this.symbol == 'J' && this.getNumTimesSpawned() < MAX_NUM_SPAWNED);
    }

    public JesterUnit spawn() {
        return new JesterUnit('J', "Jester", 100.0, 0.0, 0.0,0.0,
                10, 5, 6, 1, 0, "Unknown", 0,
                this.numTimesSpawned, true, true);
    }

    /**
     * JesterUnit can move anywhere on the board
     *
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is moving to
     * @param toSquareColumn   The column of the square the unit is moving to
     * @return True if the unit can move to the square, false otherwise
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return true;
    }

    /**
     * JesterUnit can spawn in a 3 space radius
     *
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is moving to
     * @param toSquareColumn   The column of the square the unit is moving to
     * @return True if the unit can move to the square, false otherwise
     */
    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return ((Math.abs(fromSquareColumn - toSquareColumn) <= 2) && (Math.abs(toSquareRow - fromSquareRow) <= 2));
    }
    /**
     * JesterUnit can recruit and spawn in the same radius of 3
     *
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is moving to
     * @param toSquareColumn   The column of the square the unit is moving to
     * @return True if the unit can move to the square, false otherwise
     */
    @Override
    public boolean validRecruitPath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return this.validSpawnPath(fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
    }


}


