/** *************************************************
 * GameControl Class                                *
 *                                                  *
 ************************************************** */
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.model.Game;
import byui.cit260.fireSwamp.model.Item;
import byui.cit260.fireSwamp.model.Location;
import byui.cit260.fireSwamp.model.Map;
import byui.cit260.fireSwamp.model.Player;
import fireswamp.FireSwamp;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class GameControl {
    
    public void createNewGame(Player player) {
        
        Game currentGame = new Game();
        
        currentGame.setGamePlayer(player);
        
        Map map = new Map();
        map.init();
        
        currentGame.setGameMap(map);
        
        createAndAssignItems(map);
        
        FireSwamp.setCurrentGame(currentGame);
    }

    private void createAndAssignItems(Map map) {
        
        ArrayList<Item> items = new ArrayList<>();
        
        Item rope = new Item();
        rope.setItemDescription("A sturdy rope");
        rope.setItemName("rope");
        rope.setQuantity(1);
        items.add(rope);
        
        Item rope2 = new Item();
        rope2.setItemDescription("A sturdy rope");
        rope2.setItemName("rope2");
        rope2.setQuantity(1);
        items.add(rope2);
        
        Item rope3 = new Item();
        rope3.setItemDescription("A sturdy rope");
        rope3.setItemName("rope");
        rope3.setQuantity(1);
        items.add(rope3);
        
        Random rand = new Random();
        
        for (Item item : items) {
            boolean placed = false;
            while (!placed) {                
                int randomRow = rand.nextInt(Map.ROWS);
                int randomCol = rand.nextInt(Map.COLUMNS);
            
                Location location = map.getLocationAt(randomRow, randomCol);
                if (location.getItem() == null) {
                    location.setItem(item);
                    placed = true;
                }
            }
        }
    }
        
    public static Player createPlayer(String name) {

        if (name == null) {
            return null;
        }

        Player player = new Player();
        player.setPlayerName(name);

        FireSwamp.setPlayer(player);
        
        //initialize inventory
        Item emptyInventory = new Item();
        emptyInventory.setItemType(0);
        emptyInventory.setItemName("Rope");
        emptyInventory.setItemDescription("A rope that you can use to pull yourself out of the lightning sand.");
        emptyInventory.setQuantity(0);
        player.addPlayerInventory(emptyInventory);
        
        emptyInventory.setItemType(1);
        emptyInventory.setItemName("Water");
        emptyInventory.setItemDescription("A bucket of water that you can use to douse a fire spurt.");
        emptyInventory.setQuantity(0);
        player.addPlayerInventory(emptyInventory);
        
        emptyInventory.setItemType(2);
        emptyInventory.setItemName("Potion");
        emptyInventory.setItemDescription("A healing potion that you can use to heal yourself from an ROUS bite.");
        emptyInventory.setQuantity(0);
        player.addPlayerInventory(emptyInventory);
        //set inventory
        
        
        return player;
    }

    public static void createNewGame(String playerName) {
        System.out.println("\n createNewGame() function called ***");
    }

}
