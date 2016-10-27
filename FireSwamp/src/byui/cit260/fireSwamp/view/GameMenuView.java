/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.GameControl;
import fireswamp.FireSwamp;

/**
 *
 * @author Didier Jourdain and Nikkala Thomson
 */
public class GameMenuView {
    
    private void startNewGame() {
        GameControl.createNewGame(FireSwamp.getPlayerName());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void displayMenu() {
        System.out.println("\n*** displayMenu() function called ***");
    }
    
}
