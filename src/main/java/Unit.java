/**
 * Name: Unit
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program is the parent class for all units in the game
 *
 * @author Brandon Nauta and John Fulkerson
 * @since 03-22-2023
 * @version Unit v1.0
 */
public abstract class Unit {
    // Variables
    protected char symbol; // The text representation of the piece
    protected String name; // The units name
    protected double health; // The units base health
    protected double healthModifier; // Modifications to units health
    protected double damage; // The units base damage
    protected double damageModifier; // Modifications to units damage
    protected int luck; // Our random luck mechanism
    protected int xCor; // Current cord on x-axis
    protected int yCor; // Current cord on y-axis
    protected int movement; // Amount unit can move
    protected int movementModifier; // Modifications to units movement
    protected String teamColor; // The teams color

    /**
     * This constructor accepts 14 parameters
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
     */
    public Unit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier,
            int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
        this.teamColor = teamColor;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealthModifier() {
        return this.healthModifier;
    }

    public void setHealthModifier(double healthModifier) {
        this.healthModifier = healthModifier;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamageModifier() {
        return this.damageModifier;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public int getLuck() {
        return this.luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getxCor() {
        return this.xCor;
    }

    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    public int getyCor() {
        return this.yCor;
    }

    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    public int getMovement() {
        return this.movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMovementModifier() {
        return this.movementModifier;
    }

    public void setMovementModifier(int movementModifier) {
        this.movementModifier = movementModifier;
    }

    public String getTeamColor() {
        return this.teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    /**
     * This method will return the string representation of the unit
     * 
     * @return String: The string representation of the unit
     */
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }

    public abstract Unit spawn();

    public abstract boolean canSpawn();

    // Temporary location of validMovePath and validSpawnPath
    public boolean validMovePath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return true;
    }

    public boolean validSpawnPath(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn) {
        return true;
    }
}