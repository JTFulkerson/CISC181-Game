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
    public void removeUnitFromTeam(Unit unit) {
        this.units.remove(unit);
    }

    public void addUnitToTeam(Unit unit) {
        unit.teamColor = this.teamColor;
        this.units.add(unit);
    }

    @Override
    public String toString() {
        String unitString = "";
        for (Unit unit : units) {
            unitString += unit.toString() + "   ";
        }
        return "Team " + this.teamColor + " Units : \n" + unitString;
    }
}
