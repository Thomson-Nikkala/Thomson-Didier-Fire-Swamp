/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fireswamp;

import byui.cit260.fireSwamp.model.Player;

/**
 *
 * @author maraa
 */
public class FireSwamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flintstone");
        playerOne.setGender('M');
        //playerOne.setInventory("");
        //playerOne.setPosition
        playerOne.setIsAlive(true);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
