/**
 * Name: DukeUnit
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a DukeUnit
 *
 * @author Brandon Nauta and John Fulkerson, and Seth Thompson
 * @since 05-03-2023
 * @version DukeUnit v0.1
 */

public class DukeUnit extends King {

    public DukeUnit(char symbol, String name, double health, double healthModifier, double damage,
            double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier,
            String teamColor, int numAttacks, int numRecruits, int numTimesSpawned) {
        super(symbol, name, health, healthModifier, damage,
                damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor, numAttacks, numRecruits,
                numTimesSpawned);
    }

    public DukeUnit() {
        this('D', "Duke", 150.0, 0.0, 35.0, 5.0, 0, 5,
                5, 1, 0, "Unknown", 0, 0, 0);
    }

    @Override
    public DukeUnit spawn() {
        return new DukeUnit(Character.toLowerCase(super.symbol), "Duke", 150.0, 10.0,
                40.0, 10.0, 0, 5, 5, 1, 0,
                "Unknown", 0, 0, 0);
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    /**
     * This method determines how much damage the unit will deal
     * @return Double representing the amount of damage the unit will deal
     */
    public double dealDamage() {
        return this.damage + this.damageModifier;
    }

    /**
     * This method determines how much health the unit will have left after taking
     * damage
     * @param damage The amount of damage the unit will take
     */
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return true;
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareColumn, int toSquareRow,
            int toSquareColumn) {
        return true;
    }

    /**
     * Duke Unit can attack anywhere on the board
     *
     * @param fromSquareRow    The row of the square the unit is on
     * @param fromSquareColumn The column of the square the unit is on
     * @param toSquareRow      The row of the square the unit is attacking
     * @param toSquareColumn   The column of the square the unit is attacking
     * @return True if the attack is valid, false otherwise
     */
    @Override
    public boolean validAttackPath(int fromSquareRow, int fromSquareColumn, int toSquareRow,
                                   int toSquareColumn) {
        return true;
    }

    @Override
    public boolean validRecruitPath(int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
                                             int columnIndexUnit) {
        return true;
    }
}
