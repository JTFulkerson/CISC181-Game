import java.util.ArrayList;

public class Player {
    private int playerNumber;
    private boolean isTurn;
    private Team team;

    public Player() {
        this.playerNumber = 0;
        this.isTurn = false;
        this.team = new Team("Unknown", new ArrayList<Unit>());
    }

    public Player(int playerNumber, Team team) {
        this.playerNumber = playerNumber;
        this.isTurn = false;
        this.team = team;
    }

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

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
