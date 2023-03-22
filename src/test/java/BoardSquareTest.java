import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardSquareTest {
    @Test
    public void testingBoardSpace() {
        System.out.println("Testing Board Square Class");
        BoardSquare testSquare11 = new BoardSquare("Black");
        BoardSquare testSquare12 = new BoardSquare("White");
        // getColor
        assertEquals("Black", testSquare11.getSquareColor());
        assertEquals("White", testSquare12.getSquareColor());
        // isEmpty
        assertTrue(testSquare11.isEmpty());
        assertTrue(testSquare12.isEmpty());
        // toString
        assertEquals("-------", testSquare11.toString());
        assertEquals("-------", testSquare12.toString());
        // getUnit - none
        assertNull(testSquare11.getUnit());
        assertNull(testSquare12.getUnit());
        // setUnit
        // place some Units on the GameBoard
        Unit tj = new TomJerryUnit('M', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false, "Blu");
        Unit bart = new BartSimpsonUnit('E', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0, true, true,
                "Red");
        testSquare11.setUnit(tj);
        testSquare12.setUnit(bart);
        // toString
        assertEquals("-Blu M-", testSquare11.toString());
        assertEquals("-Red E-", testSquare12.toString());
        // getUnit - returns Unit but doesn't remove it from space
        assertSame(tj, testSquare11.getUnit());
        assertSame(bart, testSquare12.getUnit());
        // isEmpty
        assertFalse(testSquare11.isEmpty());
        assertFalse(testSquare12.isEmpty());
        // removeUnit - returns Unit and removes it from space
        assertSame(tj, testSquare11.removeUnit());
        assertSame(bart, testSquare12.removeUnit());
        // isEmpty
        assertTrue(testSquare11.isEmpty());
        assertTrue(testSquare12.isEmpty());
        // toString
        assertEquals("-------", testSquare11.toString());
        assertEquals("-------", testSquare12.toString());
    }
}