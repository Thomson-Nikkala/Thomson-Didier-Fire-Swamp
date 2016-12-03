/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

/**
 *
 * @author maraa
 */
class HelpInventoryView extends View {
    
    public HelpInventoryView() {

        super("\n******************************************************"
                 +  "\n* INVENTORY MENU                                     *"
                 +  "\n* R - Rope                                           *"
                 +  "\n* S - Stick                                          *"
                 +  "\n* P - Healing Potion                                 *"
                 +  "\n* W - Bucket of Water                                *"
                 +  "\n* M - Map                                            *"
                 +  "\n* B - Back                                           *"
                 +  "\n******************************************************"
                + "\n\n Enter command: ");
    }

    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "R":
                this.displayRope();
                break;
            case "S":
                this.displayLook();
                break;
            case "P":
                this.displayHealingPotion();
                break;
            case "W":
                this.displayBucketOfWater();
                break;
            case "M":
                this.displayMap();
                break;
         
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void displayRope() {
        this.console.println("*** displayRope() function called ***");
    }

    private void displayLook() {
        this.console.println("*** displayLook() function called ***");
    }

    private void displayHealingPotion() {
        this.console.println("*** displayHealingPotion() function called ***");
    }

    private void displayBucketOfWater() {
        this.console.println("*** displayBucketOfWater() function called ***");
    }

    private void displayMap() {
        this.console.println("*** displayMap() function called ***");
    }

    private void goBack() {
        this.console.println("*** goBack() function called ***");
    }
    
}
