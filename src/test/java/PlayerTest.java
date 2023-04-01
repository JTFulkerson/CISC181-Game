import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testing_constructor() {
        System.out.println("Testing Player default constructor");
        Player player = new Player();
        assertEquals(0, player.getPlayerNumber());
        assertTrue(player.isTurn());
        assertEquals("Unknown", player.getTeam().getTeamColor());
        assertEquals(0, player.getTeam().getTeamUnits().size());

        System.out.println("");
        System.out.println("Testing Player constructor with 3 parameters");
        player = new Player(1, false, new Team("Red", new ArrayList<Unit>()));
        assertEquals(1, player.getPlayerNumber());
        assertFalse(player.isTurn());
        assertEquals("Red", player.getTeam().getTeamColor());
        assertEquals(0, player.getTeam().getTeamUnits().size());

        System.out.println("Testing Player constructor with 2 parameters");
        player = new Player(2, new Team("Blue", new ArrayList<Unit>()));
        assertEquals(2, player.getPlayerNumber());
        assertFalse(player.isTurn());
        assertEquals("Blue", player.getTeam().getTeamColor());
        assertEquals(0, player.getTeam().getTeamUnits().size());

    }

}
