import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TeamTest {

    @Test
    public void getTeamName() {

        System.out.println("Testing Team class");
        Unit tj = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false,
                "Unknown");
        Unit bart = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0, true, true,
                "Unknown");

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

        // remove a Unit from teamA
        teamA.removeUnitFromTeam(bart);
        assertEquals(1, teamA.getTeamUnits().size());
        assertFalse(teamA.getTeamUnits().contains(bart));

        // create another Team object
        ArrayList<Unit> unitsTeamB = new ArrayList<Unit>();
        Team teamB = new Team("Red", unitsTeamB);
        // add a Unit the bart to team B
        teamB.addUnitToTeam(bart);
        // check that bart color was changed to Red
        assertEquals("Red", bart.getTeamColor());

        // check team B units
        assertEquals(1, teamB.getTeamUnits().size());
        assertTrue(teamB.getTeamUnits().contains(bart));

        System.out.println(teamA.toString());
        System.out.println(teamB.toString());

    }

}