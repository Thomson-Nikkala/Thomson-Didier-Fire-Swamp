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
class HelpInventoryView {
    
    private String prompt;

    public HelpInventoryView() {
        prompt = "Enter your choice: ";
        // display the banner when view is created
        this.displayBanner();
    }
    
    

    void displayMenu() {
        boolean done = false;
        do {
            //prompt for and get player's name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("B")) {
                return;
            }

            done = this.doAction(menuOption);

        } while (!done);
    }
    
    private void displayBanner() {
        System.out.println(
                    "\n******************************************************"
                 +  "\n* INVENTORY MENU                                     *"
                 +  "\n* R - Rope                                           *"
                 +  "\n* S - Stick                                          *"
                 +  "\n* P - Healing Potion                                 *"
                 +  "\n* W - Bucket of Water                                *"
                 +  "\n* M - Map                                            *"
                 +  "\n* B - Back                                           *"
                 +  "\n******************************************************");
    }

    private String getMenuOption() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.print("\n" + this.prompt);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1)
                System.out.println("\nInvalid value: value can not be blank");
            else
                valid = true;
        }
             
        return value;
    }

    private boolean doAction(String choice) {
        
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
