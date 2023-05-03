class GameEvent {
    private int playerNumber; // stores the unique identifier for a player
    private String eventType; // acts as a tag for different events categories
    private String eventDetails; // represents a description of the game event

    /**
     * The constructor for the GameEvent class that accepts the parameters (int)
     * playerNumber, (String) eventType, and (String) eventDetails
     */
    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.eventType = eventType;
        this.playerNumber = playerNumber;
        this.eventDetails = eventDetails;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetails() {
        return this.eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}

class GameEventNode {
    private GameEvent gameState; // stores a specific game event
    private GameEventNode next; // stores a reference to the next node in the list

    /**
     * The constructor for the GameEventNode class that accepts the parameter
     * GameEvent
     */
    public GameEventNode(GameEvent gameState) {
        this.gameState = gameState;
        this.next = null;
    }

    public GameEvent getGameState() {
        return this.gameState;
    }

    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }

    public GameEventNode getNext() {
        return this.next;
    }

    public void setNext(GameEventNode next) {
        this.next = next;
    }
}

public class GameEventsLinkedList {
    private GameEventNode head; // stores a reference to the first node in the list
    private int size; // stores the number of nodes in the list

    /**
     * The constructor for the GameEventsLinkedList class that accepts no parameters
     */
    public GameEventsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public GameEventNode getNode(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        } else {
            GameEventNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current;
        }
    }

    /**
     * This method checks if the list is empty
     * 
     * @return boolean: true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * This method adds a GameEventNode to the end of the list
     * 
     * @param GameEventNode: the GameEventNode to be added to the list
     */
    public void add(GameEventNode node) {
        if (this.isEmpty()) {
            this.head = node;
        } else {
            GameEventNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        this.size++;
    }

    /**
     * This method removes a GameEventNode from the list
     * 
     * @param GameEventNode: the GameEventNode to be removed from the list
     * @return GameEvent: the GameEvent that was removed from the list
     */
    public GameEvent remove(GameEventNode node) {
        GameEvent gameEvent = null;
        if (!isEmpty()) {
            if (node == head) {
                gameEvent = head.getGameState();
                head = head.getNext();
            } else {
                GameEventNode current = head;
                while (current != null && current.getNext() != node) {
                    current = current.getNext();
                }
                if (current != null) {
                    gameEvent = current.getNext().getGameState();
                    current.setNext(current.getNext().getNext());
                }
            }
            size--;
        }
        return gameEvent;
    }

    /**
     * This method removes a GameEventNode from the list
     * 
     * @param String: the eventType to be extracted from the list and returned
     * @return GameEventsLinkedList: the list of GameEventNodes that were extracted
     *         containing the specified eventType
     */
    public GameEventsLinkedList extract(String eventType) {
        GameEventsLinkedList extractedList = new GameEventsLinkedList();
        if (!isEmpty()) {
            GameEventNode current = head;
            while (current != null) {
                if (current.getGameState().getEventType().equals(eventType)) {
                    extractedList.add(new GameEventNode(current.getGameState()));
                }
                current = current.getNext();
            }
        }
        return extractedList;
    }

    /**
     * This method displays the contents of the list
     */
    public void display() {
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }
}