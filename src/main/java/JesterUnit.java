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

    final static int MAX_NUM_SPAWNED = 3;
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
}


