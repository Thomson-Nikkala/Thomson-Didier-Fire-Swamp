package fireswamp;

import byui.cit260.fireSwamp.model.Item;
import byui.cit260.fireSwamp.model.Location;
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
        
        Location startingPoint = new Location();
        Item[] startingInventory = new Item[3];
        
        Player playerOne = new Player();
        
        playerOne.setPlayerName("Fred Flintstone");
        playerOne.setPlayerGender('M');
        playerOne.setPlayerInventory(startingInventory);
        playerOne.setPlayerPosition(startingPoint);
        playerOne.setPlayerIsAlive(true);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
