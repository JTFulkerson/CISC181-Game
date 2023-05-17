
/**
 * Name: Team
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program creates a class for a Team
 *
 * @author Brandon Nauta and John Fulkerson
 * @since 04-3-2023
 * @version GameBoard v1.0
 */

import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Unit> units;

    /**
     * This constructor takes 2 parameters and sets the team color and the units
     * 
     * @param teamColor The team color
     * @param units     The units of the team
     */
    public Team(String teamColor, ArrayList<Unit> units) {
        this.teamColor = teamColor;
        this.units = units;
    }

    // Accessors
    public String getTeamColor() {
        return this.teamColor;
    }

    public ArrayList<Unit> getTeamUnits() {
        return this.units;
    }

    // Mutators
    public void removeUnitsFromTeam(Unit unit) {
        this.units.remove(unit);
    }

    public void addUnitsToTeam(Unit unit) {
        unit.teamColor = this.teamColor;
        this.units.add(unit);
    }

    /**
     * This method returns the string representation of team color and the units of
     * the team
     * 
     * @return String: team color and units
     */
    @Override
    public String toString() {
        String unitString = "";
        for (Unit unit : units) {
            unitString += unit.toString() + " (Health:  " + unit.health +  ")   ";
        }
        return "Team " + this.teamColor + " Units : \n" + unitString;
    }
}
