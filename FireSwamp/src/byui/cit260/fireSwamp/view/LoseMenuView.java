/** *************************************************
 * LoseMenuView Class                              *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikkala Thomson
 */
public class LoseMenuView extends View {

    public LoseMenuView() {
        super("\n******************************************************"
            + "\n*  T - Try again                                     *"
            + "\n*  X - eXit game                                     *"
            + "\n******************************************************");
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase();

        if (choice.compareTo("T") == 0) {
            this.tryAgain();
        } else if (choice.compareTo("X") == 0) {
            this.exitGame();
        } else {
            this.console.println("\n*** Invalid selection *** Try again");
        }

        return false;
    }

    private void tryAgain() {
        try {
            StartProgramView newProgram = new StartProgramView();
            newProgram.display();
        } catch (GameControlException ex) {
            Logger.getLogger(LoseMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void exitGame() {
        System.exit(0);
    }

}
