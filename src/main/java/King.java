/**
 * Name: King
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for King
 *
 * @author Brandon Nauta and John Fulkerson, and Seth Thompson
 * @since 05-03-2023
 * @version King v0.1
 */

public abstract class King extends Unit {
    //Variables//

    private int numAttacks;
    private int numRecruits;

    ///////////////////

    public King (char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
                 int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor,
                 int numAttacks, int numRecruits, int numTimesSpawned) {

        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement,
                movementModifier, teamColor, numTimesSpawned);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
    }

    public int getNumAttacks() {
        return this.numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
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
    public abstract boolean validAttackPath(int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
                                   int columnIndexUnit);

    public abstract boolean validRecruitPath(int rowIndexBoardSquare, int columnIndexBoardSquare, int rowIndexUnit,
                                    int columnIndexUnit);
}
