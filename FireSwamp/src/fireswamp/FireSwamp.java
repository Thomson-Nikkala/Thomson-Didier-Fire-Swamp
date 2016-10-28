package fireswamp;

import byui.cit260.fireSwamp.model.*;
import byui.cit260.fireSwamp.view.*;
/*
import java.util.HashSet;
import java.util.Set;
*/
/**
 *
 * @authors Didier Jourdain <maraamu@byui.edu>
 *          Nikkala Thomson <nikkalat@gmail.com>
 */
public class FireSwamp {
    
    private static Game currentGame = null;
    private static Player player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        FireSwamp.currentGame = currentGame;
    }

    /**
     * @param args the command line arguments
     */
    
    public static void setPlayer(Player player) {
        System.out.println("\n*** setPlayer called ***");
    }
    
    public static String getPlayer() {
        System.out.println("\n*** getPlayer called ***");
        return "hello";
    }
    
    public static void main(String[] args) {
        
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        
        
        /*
        Map mainMap = new Map();
        Danger dangerOne = new Danger();
        
        Location entryPoint = new Location();
        Location extractionPoint = new Location();
        
        entryPoint.setLocationRow(3);
        entryPoint.setLocationColumn(4);
        mainMap.setMapEntrance(entryPoint);
        
        dangerOne.setDangerDescription("Quicksand that is drier and quicker.");
        dangerOne.setDangerName("Lightning Sand");
        dangerOne.setDangerType(1);
        
        String dangerInfo = dangerOne.toString();
        System.out.println(dangerInfo);
        
        /* Testing Player, Location, Item and Question
           Tested by Didier
        
         //Instantiate Player class
         Player myPlayer = new Player();
         myPlayer.setPlayerName("Didier");
         myPlayer.setPlayerGender('M');
        
         //Need to create an item to put in player's inventory
         Item stick = new Item();
         stick.setItemType(0);
         stick.setItemName("Monkey King's stick");
         stick.setQuantity(1);
         stick.setItemDescription("This is Monkey King's magical stick");
         
         String itemInfo = stick.toString();
         System.out.println(itemInfo);
         
         //Continue instantiating Player class
         myPlayer.setPlayerInventory(stick);
         
         //Need to create the player's location
         Location playerInitialPosition = new Location();
         playerInitialPosition.setLocationRow(2);
         playerInitialPosition.setLocationColumn(0);
         playerInitialPosition.setLocationVisited(true);
         playerInitialPosition.setLocationDescription("This is where the player starts");
         
         //Finish instantiating Player class
         myPlayer.setPlayerPosition(playerInitialPosition);
         myPlayer.setPlayerIsAlive(true);
         
         //Prepare output for myPlayer
         String playerInfo = myPlayer.toString();
         System.out.println(playerInfo);
        
        */
        
    }


    
    
}
