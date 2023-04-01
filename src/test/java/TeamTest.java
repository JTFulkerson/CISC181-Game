import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void getTeamName() {

        System.out.println("Testing Team class");

        Unit tj = new TomJerryUnit();
        Unit bart = new BartSimpsonUnit();

        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();
        piecesTeamA.add(tj);
        piecesTeamA.add(bart);

        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // check teamA
        assertEquals("Blu", teamA.getTeamColor());
        assertEquals(2, teamA.getTeamUnits().size());

        assertTrue(teamA.getTeamUnits().contains(tj));
        assertTrue(teamA.getTeamUnits().contains(bart));

        // remove Unit from teamA
        teamA.removeUnitsFromTeam(bart);
        assertEquals(1, teamA.getTeamUnits().size());
        assertFalse(teamA.getTeamUnits().contains(bart));

        // create another Team object
        ArrayList<Unit> unitsTeamB = new ArrayList<Unit>();
        Team teamB = new Team("Red", unitsTeamB);
        // add a Unit bart to team B
        teamB.addUnitsToTeam(bart);
        // check that bart color was changed to Red
        assertEquals("Red", bart.getTeamColor());

        // check team B units
        assertEquals(1, teamB.getTeamUnits().size());
        assertTrue(teamB.getTeamUnits().contains(bart));

        System.out.println(teamA.toString());
        System.out.println(teamB.toString());

    }

}