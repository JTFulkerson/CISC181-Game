import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
public class TeamTest {
    @Test
    public void getTeamName() {
        System.out.println("Testing Team class");
        // Two Units for player 1
        Unit tj1 = new TomJerryUnit();
        Unit bart1 = new BartSimpsonUnit();
        // Two Units for player 2
        Unit tj2 = new TomJerryUnit();
        Unit bart2 = new BartSimpsonUnit();
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();
// Create a team object
        // Load the pieces
        Team teamA = new Team("Blu",piecesTeamA);
        teamA.addUnitsToTeam(tj1);
        teamA.addUnitsToTeam(bart1);
// check teamA
        assertEquals("Blu",teamA.getTeamColor());
        assertEquals(2,teamA.getTeamUnits().size());
        assertTrue(teamA.getTeamUnits().contains(tj1));
        assertTrue(teamA.getTeamUnits().contains(bart1));
        assertFalse(teamA.getTeamUnits().contains(tj2));
        assertFalse(teamA.getTeamUnits().contains(bart2));
// remove Unit from teamA
        teamA.removeUnitsFromTeam(bart1);
        assertEquals(1,teamA.getTeamUnits().size());
        assertFalse(teamA.getTeamUnits().contains(bart1));
// create another Team object
        ArrayList<Unit> unitsTeamB = new ArrayList<Unit>();
        Team teamB = new Team("Red",unitsTeamB);
// Load the pieces
        teamB.addUnitsToTeam(bart2);
        teamB.addUnitsToTeam(tj2);
        //add a bart1 to teamB
        teamB.addUnitsToTeam(bart1);
        // check that bart color was changed to Red
        assertEquals("Red",bart1.getTeamColor());
// check team B units
        assertEquals(3,teamB.getTeamUnits().size());

        assertTrue(teamB.getTeamUnits().contains(bart1));
        assertTrue(teamB.getTeamUnits().contains(tj2));
        assertTrue(teamB.getTeamUnits().contains(bart2));
        assertFalse(teamB.getTeamUnits().contains(tj1));
        System.out.println(teamA.toString());
        System.out.println(teamB.toString());
    }
}