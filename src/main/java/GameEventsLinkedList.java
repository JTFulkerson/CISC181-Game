class GameEvent {
    private int playerNumber; // stores the unique identifier for a player
    private String eventType; // acts as a tag for different events categories
    private String eventDetails; // represents a description of the game event

    /**
     * The constructor for the GameEvent class that accepts the parameters (int)
     * playerNumber, (String) eventType, and (String) eventDetails
     * 
     * @param playerNumber The unique identifier for a player
     * @param eventType    The tag for different event categories
     * @param eventDetails The description of the game event
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

public class GameEventsLinkedList implements Comparable<GameEventsLinkedList> {
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
     * This method compares the size of the list to the size of another list
     * 
     * @param other The other GameEventsLinkedList to be compared to
     * @return int: 1 if the list is larger, -1 if the list is smaller, 0 if the two
     *         lists are the same size
     */
    public int compareTo(GameEventsLinkedList other) {
        if (this.getSize() > other.getSize()) {
            return 1;
        } else if (this.getSize() < other.getSize()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * This method pushes a GameEventNode to the front of the list
     * 
     * @param GameEventNode: the GameEventNode to be pushed to the list
     */
    public void push(GameEventNode node) {
        if (isEmpty()) {
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        size++;
    }

    /**
     * This method pops the first GameEventNode from the list and returns it
     * 
     * @return GameEventNode: the GameEventNode that was popped from the list
     */
    public GameEventNode pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            GameEventNode poppedNode = this.head;
            this.head = this.head.getNext();
            size--;
            return poppedNode;
        }
    }

    /**
     * This method removes all of the GameEventNodes of the specified eventType from
     * the list and returns them in a new list
     *
     * @param String: the eventType to be extracted from the list and returned
     * @return GameEventsLinkedList: the list of GameEventNodes that were extracted
     *         containing the specified eventType
     */
    public GameEventsLinkedList pop(String eventType) {
        GameEventsLinkedList extractedList = new GameEventsLinkedList();
        GameEventNode current = this.head;
        GameEventNode previous = null;
        while ((current != null) && (size > 0)) {
            if (current.getGameState().getEventType().equals(eventType)) {
                if (previous == null) {
                    this.head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                extractedList.push(current);
                size--;
            } else {
                previous = current;
            }
            current = current.getNext();
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