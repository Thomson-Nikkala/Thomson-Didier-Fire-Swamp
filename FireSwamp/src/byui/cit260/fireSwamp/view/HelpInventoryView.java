/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

import java.util.Scanner;

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
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void displayRope() {
        System.out.println("*** displayRope() function called ***");
    }

    private void displayLook() {
        System.out.println("*** displayLook() function called ***");
    }

    private void displayHealingPotion() {
        System.out.println("*** displayHealingPotion() function called ***");
    }

    private void displayBucketOfWater() {
        System.out.println("*** displayBucketOfWater() function called ***");
    }

    private void displayMap() {
        System.out.println("*** displayMap() function called ***");
    }

    private void goBack() {
        System.out.println("*** goBack() function called ***");
    }
    
}
