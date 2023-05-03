import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEventsLinkedListTest {
    GameEventsLinkedList list = new GameEventsLinkedList();

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(new GameEventNode(new GameEvent(181, "SIP", "Spagetti Night")));
        assertFalse(list.isEmpty());
    }

    @Test
    void add() {
        assertEquals(0, list.getSize());
        list.add(new GameEventNode(new GameEvent(210, "SIP", "Taco Night")));
        assertEquals(1, list.getSize());
        assertEquals(210, list.getNode(0).getGameState().getPlayerNumber());
        assertEquals("SIP", list.getNode(0).getGameState().getEventType());
        list.add(new GameEventNode(new GameEvent(181, "SIP", "Spagetti Night")));
        assertEquals(2, list.getSize());
        assertEquals(181, list.getNode(1).getGameState().getPlayerNumber());
        assertEquals("SIP", list.getNode(1).getGameState().getEventType());
        list.add(new GameEventNode(new GameEvent(100, "Party", "Birthday Party")));
        assertEquals(100, list.getNode(2).getGameState().getPlayerNumber());
        assertEquals("Party", list.getNode(2).getGameState().getEventType());
        assertEquals(3, list.getSize());
    }

    @Test
    void remove() {
        GameEventNode node1 = new GameEventNode(new GameEvent(210, "SIP", "Taco Night"));
        GameEventNode node2 = new GameEventNode(new GameEvent(181, "SIP", "Spagetti Night"));
        GameEventNode node3 = new GameEventNode(new GameEvent(100, "Party", "Birthday Party"));
        list.add(node1);
        list.add(node2);
        list.add(node3);
        assertEquals(3, list.getSize());
        assertEquals(181, list.remove(node2).getPlayerNumber());
        assertEquals(2, list.getSize());
        assertEquals(100, list.getNode(1).getGameState().getPlayerNumber());
        assertEquals(210, list.remove(node1).getPlayerNumber());
        assertEquals(1, list.getSize());
        assertEquals(100, list.getNode(0).getGameState().getPlayerNumber());
    }

    @Test
    void extract() {
        list.add(new GameEventNode(new GameEvent(210, "SIP", "Taco Night")));
        list.add(new GameEventNode(new GameEvent(181, "SIP", "Spagetti Night")));
        list.add(new GameEventNode(new GameEvent(100, "Party", "Birthday Party")));
        assertEquals(2, list.extract("SIP").getSize());
        assertEquals(1, list.extract("Party").getSize());
        assertEquals(181, list.extract("SIP").getNode(1).getGameState().getPlayerNumber());
        assertEquals(210, list.extract("SIP").getNode(0).getGameState().getPlayerNumber());
    }
}