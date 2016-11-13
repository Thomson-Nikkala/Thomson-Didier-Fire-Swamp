/***************************************************
 * LoseMenuView Class                              *
 *                                                 *
 ***************************************************/

package byui.cit260.fireSwamp.view;

import java.util.Scanner;

/**
 *
 * @author Nikkala Thomson
 */

public class LoseMenuView extends View {

    public LoseMenuView() {
      super("\n******************************************************"
         +  "\n*  T - Try again                                     *"
         +  "\n*  X - eXit game                                     *"
         +  "\n******************************************************");
   }
  
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        if (choice.compareTo("T")==0) {
            this.tryAgain();
        } else if (choice.compareTo("X") == 0) {
            this.exitGame();
        } else {
            System.out.println("\n*** Invalid selection *** Try again");
        }           
        
        return false;
    }

    private void tryAgain() {
        StartProgramView newProgram = new StartProgramView();
        newProgram.display();
    }

    private void exitGame() {
        System.exit(0);
    }

    
} 
   

