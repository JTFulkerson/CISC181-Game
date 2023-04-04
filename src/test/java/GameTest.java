import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
public class GameTest {
    @Test
    public void gameTests() throws Exception {
        System.out.println("Testing Game");
// Create 2 Units for team A
        Unit blueTJ = new TomJerryUnit();
        blueTJ.setTeamColor("Blu");
        Unit blueBart = new BartSimpsonUnit();
        blueBart.setTeamColor("Blu");
// Load the Units in an ArrayList
        ArrayList<Unit> UnitsTeamA = new ArrayList<Unit>();
        UnitsTeamA.add(blueTJ);
        UnitsTeamA.add(blueBart);
        Player p1 = new Player();
        p1.setTurn(true);
        Team teamA = new Team("Blu", UnitsTeamA);
        p1.setPlayersTeam(teamA);
// Create 2 Units for team B
        Unit redTJ = new TomJerryUnit();
        redTJ.setTeamColor("Red");
        Unit redBart = new BartSimpsonUnit();
        redBart.setTeamColor("Red");
// Load the Units in an ArrayList
        ArrayList<Unit> UnitsTeamB = new ArrayList<Unit>();
        UnitsTeamB.add(redTJ);
        UnitsTeamB.add(redBart);
        Player p2 = new Player();
        Team teamB = new Team("Red", UnitsTeamB);
        p2.setPlayersTeam(teamB);
        Game ourGame = new Game(8, 8, p1, p2);
        System.out.println(ourGame.toString());
        assertEquals(p1, ourGame.getCurrentPlayer());
        assertEquals(p2, ourGame.getOpponentPlayer());
        assertEquals(teamA, ourGame.getCurrentPlayer().getPlayersTeam());
        assertEquals(teamB, ourGame.getOpponentPlayer().getPlayersTeam());
        assertTrue(ourGame.isTurn(p1));
        assertFalse(ourGame.isTurn(p2));
        ourGame.changeTurn();
        assertEquals(p2, ourGame.getCurrentPlayer());
        assertEquals(p1, ourGame.getOpponentPlayer());
        assertEquals(teamB, ourGame.getCurrentPlayer().getPlayersTeam());
        assertEquals(teamA, ourGame.getOpponentPlayer().getPlayersTeam());
        assertTrue(ourGame.isTurn(p2));
        assertFalse(ourGame.isTurn(p1));
    }
}
