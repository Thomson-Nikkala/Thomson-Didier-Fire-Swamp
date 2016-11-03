/***************************************************
 * LoseMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;

import java.util.Scanner;

/**
 *
 * @author Nikkala
 */

public class LoseMenuView {
    private final String prompt; 

    public LoseMenuView() {
        
        this.prompt = "Please enter your choice: ";
        // display the banner when view is created
        this.displayBanner();
    }
   
   private void displayBanner() {
      System.out.println(
            "\n******************************************************"
         +  "\n*  T - Try again                                     *"
         +  "\n*  X - eXit game                                     *"
         +  "\n******************************************************");
   }
   
   public void displayMenu() {
        
        boolean done = false;
        do {
            //prompt for and get player's menu choice
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("B")) {
                return;
            }

            done = this.doAction(menuOption);

        } while (!done);
        
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
        newProgram.displayStartProgramView();
    }

    private void exitGame() {
        System.exit(0);
    }

    
} 
   

