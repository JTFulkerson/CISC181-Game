
/**
 * Name: Player
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Player
 *
 * @author Brandon Nauta and John Fulkerson
 * @since 04-3-2023
 * @version GameBoard v1.0
 */

import java.util.ArrayList;

public class Player {
    private int playerNumber;
    private boolean isTurn;
    private Team team;

    /*
     * Default constructor
     */
    public Player() {
        this.playerNumber = 0;
        this.isTurn = true;
        this.team = new Team("Unknown", new ArrayList<Unit>());
    }

    /**
     * Constructor with 2 parameters
     * 
     * @param playerNumber player number
     * @param team         team
     */
    public Player(int playerNumber, Team team) {
        this.playerNumber = playerNumber;
        this.isTurn = false;
        this.team = team;
    }

    /**
     * Constructor with 3 parameters
     * 
     * @param playerNumber player number
     * @param isTurn       is turn
     * @param team         team
     */
    public Player(int playerNumber, boolean isTurn, Team team) {
        this.playerNumber = playerNumber;
        this.isTurn = isTurn;
        this.team = team;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isTurn() {
        return this.isTurn;
    }

    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public Team getPlayersTeam() {
        return this.team;
    }

    public void setPlayersTeam(Team team) {
        this.team = team;
    }

}
