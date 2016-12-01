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
        rope.setItemType(1);
        items.add(rope);
        
        Item rope2 = new Item();
        rope2.setItemDescription("A sturdy rope");
        rope2.setItemName("rope2");
        rope2.setItemType(1);
        items.add(rope2);
        
        Item rope3 = new Item();
        rope3.setItemDescription("A sturdy rope");
        rope3.setItemName("rope3");
        rope3.setItemType(1);
        items.add(rope3);
        
        Item potion = new Item();
        potion.setItemDescription("A healing potion");
        potion.setItemName("potion");
        potion.setItemType(3);
        items.add(potion);
        
        Item potion2 = new Item();
        potion2.setItemDescription("A healing potion");
        potion2.setItemName("potion2");
        potion2.setItemType(3);
        items.add(potion2);
        
        Item potion3 = new Item();
        potion3.setItemDescription("A healing potionh");
        potion3.setItemName("potion3");
        potion3.setItemType(3);
        items.add(potion3);
        
        Item water = new Item();
        water.setItemDescription("A bucket of water");
        water.setItemName("water");
        water.setItemType(2);
        items.add(water);
        
        Item water2 = new Item();
        water2.setItemDescription("A bucket of water");
        water2.setItemName("water2");
        water2.setItemType(2);
        items.add(water2);
        
        Item water3 = new Item();
        water3.setItemDescription("A bucket of water"); 
        water3.setItemName("water3");
        water3.setItemType(2);
        items.add(water3);
        
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
      
        return player;
    }    
}
