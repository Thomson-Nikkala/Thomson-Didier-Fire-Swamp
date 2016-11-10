/***************************************************
 * GameMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;

import java.util.Scanner;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class GameMenuView extends View {

    public GameMenuView() {
    
              super("\n******************************************************"
                 +  "\n* GAME MENU                                          *"
                 +  "\n* V - View map                                       *"
                 +  "\n* O - lOok                                           *"
                 +  "\n* L - Listen                                         *"
                 +  "\n* M - sMell                                          *"
                 +  "\n* T - Take item                                      *"
                 +  "\n* N - move North                                     *"
                 +  "\n* E - move East                                      *"
                 +  "\n* W - move West                                      *"
                 +  "\n* S - move South                                     *"
                 +  "\n* G - save Game                                      *"
                 +  "\n* H - Help                                           *"
                 +  "\n* B - Back                                           *"
                 +  "\n******************************************************"
                 +  "\n\n Enter command: ");
    }
    
        @Override
        public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "V":
                this.displayMap();
                break;
            case "O":
                this.look();
                break;
            case "L":
                this.listen();
                break;
            case "M":
                this.smell();
                break;
            case "T":
                this.takeItem();
                break;
            case "N":
                this.moveNorth();
                break;
            case "E":
                this.moveEast();
                break;
            case "W":
                this.moveWest();
                break;
            case "S":
                this.moveSouth();
                break;
            case "G":
                this.saveGame();
                break;
            case "H":
                this.callHelpMenu();
                break;
         
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }    

    private void displayMap() {
       System.out.println("*** displayMap() function called"); 
    }

    private void look() {
        System.out.println("*** look() function called");
    }

    private void listen() {
        System.out.println("*** listen() function called");
    }

    private void smell() {
       System.out.println("*** smell() function called");
    }

    private void takeItem() {
       System.out.println("*** takeItem() function called");
    }

    private void moveNorth() {
        System.out.println("*** moveNorth() function called");
    }

    private void moveEast() {
        System.out.println("*** moveEast() function called");
    }

    private void moveWest() {
        System.out.println("*** moveWest() function called");
    }

    private void moveSouth() {
        System.out.println("*** moveSouth() function called");
    }

    private void saveGame() {
        System.out.println("*** saveGame() function called");
    }

    private void callHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void goBack() {
        System.out.println("*** goBack() function called");
    }
        
 
}
