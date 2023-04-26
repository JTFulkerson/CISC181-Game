
/**
 * Name: Controller
 * Course: CISC 181-032L Spring 2023
 * University of Delaware
 * This program acts as the controller of the game that receives, interprets and validates input,
 * creates & updates the views to the user, interprets commands, and controls the flow of the game.
 *
 * @author Brandon Nauta, John Fulkerson, and Seth Thompson
 * @since 04-20-2023
 * @version ActionAttack v1.0
 */

import java.util.ArrayList;

public class Controller {
    private Game game;
    private TextView textView;

    public Game setUpGameModel() {
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();

        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");

        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");

        piecesTeamA.add(bs);
        piecesTeamA.add(tj);

        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);
        Player playerOne = new Player(1, true, teamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();
        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");

        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");

        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);

        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);
        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public Controller() {
        this.game = setUpGameModel();
        this.textView = new TextView();
        this.textView.updateView(this.game);
    }

    public void carryOutAction(int fromSquareRow, int fromSquareColumn, int toSquareRow, int toSquareColumn,
            char action) {
        if (action == 'M') {
            ActionMove move = new ActionMove(this.game, fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn);
            move.performAction();
        } else if (action == 'S') {
            ActionSpawn spawn = new ActionSpawn(this.game, fromSquareRow, fromSquareColumn, toSquareRow,
                    toSquareColumn);
            spawn.performAction();
        } else if (action == 'R') {
            ActionRecruit recruit = new ActionRecruit(this.game, fromSquareRow, fromSquareColumn, toSquareRow,
                    toSquareColumn);
            recruit.performAction();
        } else if (action == 'A') {
            ActionAttack attack = new ActionAttack(this.game, fromSquareRow, fromSquareColumn, toSquareRow,
                    toSquareColumn);
            attack.performAction();
        }
    }

    public void playGame() {
        while (!this.game.isGameEnded()) {
            this.textView.getNextPlayersAction(game);

            // variables so reading function calls is easier
            int fromSquareRow = this.textView.getRowIndexBoardSquareMakingAction();
            int fromSquareColumn = this.textView.getColumnIndexBoardSquareMakingAction();
            int toSquareRow = this.textView.getRowIndexBoardSquareReceivingAction();
            int toSquareColumn = this.textView.getColumnIndexBoardSquareReceivingAction();
            char actionType = this.textView.getActionType();

            if (Rules.checkValidAction(this.game, fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn,
                    actionType)) {

                carryOutAction(fromSquareRow, fromSquareColumn, toSquareRow, toSquareColumn, actionType);
            }
            System.out.println(this.game);
        }
        this.textView.printEndOfGameMessage(this.game);

    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }

}
