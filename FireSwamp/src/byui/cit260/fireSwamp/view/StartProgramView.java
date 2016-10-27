/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.GameControl;
import byui.cit260.fireSwamp.model.Player;
import java.util.Scanner;

/**
 *
 * @author Didier Jourdain and Nikkala Thomson
 */
public class StartProgramView {

    private String promptMessage;
    
    public StartProgramView() {
        
        this.promptMessage = "\nPlease enter your name: ";
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        
        System.out.println(
                    "\n******************************************************"
                 +  "\n*                                                    *"
                 +  "\n* Can you survive the fire swamp?                    *"
                 +  "\n* Test your deduction and math skills as you         *"
                 +  "\n* navigate the hazards of the most dangerous place   *"
                 +  "\n* in Florin.                                         *"
                 +  "\n*                                                    *"
                 +  "\n******************************************************");
        
        
    }

    public void displayStartProgramView() {
        
        boolean done = false;
        do {
            //prompt for and get player's name
            String playerName = this.getPlayerName();
            if (playerName.toUpperCase().equals("X"))
                return;
            
            done = this.doAction(playerName);
          
        } while (!done);
    }

    private String getPlayerName() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;
        }
        
        return value;
    }

    private boolean doAction(String playerName) {
        
        if (playerName.length() < 2) {
            System.out.println("\nInvalid player name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        Player player = GameControl.createPlayer(playerName);
        
        if (player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }
        
        this.displayNextView(player);
        
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\n==============================================="
                          + "\n Welcome to the game " + player.getPlayerName()
                          + "\n We hope you have a lot of fun!"
                         + "\n==============================================="
                        );
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.displayMainMenuView();
    }
    
}
