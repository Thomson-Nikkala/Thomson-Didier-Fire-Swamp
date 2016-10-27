/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.model.Player;
import fireswamp.FireSwamp;

/**
 *
 * @author maraa
 */
public class GameControl {

    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setPlayerName(name);
        
        FireSwamp.setPlayer(player);
        
        return player;
    }

    public static void createNewGame(String playerName) {
        System.out.println("\n createNewGame() function called ***");
    }
    
}
