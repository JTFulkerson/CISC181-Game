public class JesterUnit extends BartSimpsonUnit {

    final static int MAX_NUM_SPAWNED = 6;
    public JesterUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
                      int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits,
                      int numTimesSpawned, boolean distract, boolean recruit) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier,
        numTimesSpawned, distract, recruit, teamColor, numRecruits);
    }

    public JesterUnit() {
        this('J', "Duke", 500.0, 0.0, 15.0, 0.0,
                10, 5, 6, 1, 0, "Unknown", 0,
                0, true, true);
    }

    @Override
    public boolean canSpawn() {
        return (super.symbol == 'J' && super.getNumTimesSpawned() < MAX_NUM_SPAWNED);
    }

    @Override
    public BartSimpsonUnit spawn() {
        super.setNumTimesSpawned(super.getNumTimesSpawned()+1);
        return new BartSimpsonUnit(this.symbol, "Bart Simpson", 100.0, 5.0,
                25.0, 10.0, 0, 1, 1, 1, 1, 0,
                true, true, "Unknown", 0);
    }
}


