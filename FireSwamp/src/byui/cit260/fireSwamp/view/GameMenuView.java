/***************************************************
 * GameMenuView Class                              *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.InventoryControl;
import byui.cit260.fireSwamp.controller.MapControl;
import byui.cit260.fireSwamp.enums.Direction;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.exceptions.InventoryControlException;
import byui.cit260.fireSwamp.exceptions.MapControlException;
import byui.cit260.fireSwamp.model.Item;
import byui.cit260.fireSwamp.model.Location;
import byui.cit260.fireSwamp.model.Map;
import byui.cit260.fireSwamp.model.Player;
import fireswamp.FireSwamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class GameMenuView extends View {

    public GameMenuView() {
    
              super("\n******************************************************"
                 +  "\n* GAME MENU                                          *"
                 +  "\n* V - View map                                       *"
                 +  "\n* O - lOok                                           *"
                 +  "\n* L - Listen                                         *"
                 +  "\n* M - sMell                                          *"
                 +  "\n* T - Take item                                      *"
                 +  "\n* N - move North                                     *"
                 +  "\n* E - move East                                      *"
                 +  "\n* W - move West                                      *"
                 +  "\n* S - move South                                     *"
                 +  "\n* G - save Game                                      *"
                 +  "\n* H - Help                                           *"
                 +  "\n* B - Back                                           *"
                 +  "\n* P - Win Game (for testing purposes)                *"
                 +  "\n******************************************************"
                 +  "\n\n Enter command: ");
    }
    
        @Override
        public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "V":
                this.displayMap();
                break;
            case "O":
                this.look();
                break;
            case "L":
                this.listen();
                break;
            case "M":
                this.smell();
                break;
            case "T":
                this.takeItem();
                break;
            case "N":
                this.moveNorth();
                break;
            case "E":
                this.moveEast();
                break;
            case "W":
                this.moveWest();
                break;
            case "S":
                this.moveSouth();
                break;
            case "G":
                this.saveGame();
                break;
            case "H":
                this.callHelpMenu();
                break;
            case "P":
                this.callWinGameView();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }    

    private void displayMap() {
       Map map = FireSwamp.getCurrentGame().getGameMap();
       final int gridRow = Map.ROWS * 4 + 1;
       final int gridCol = Map.COLUMNS * 4 + 1;
       char [][] grid = new char [gridRow][gridCol];
           
       // Prepare empty grid 
       for (int row = 0; row < gridRow; row++) 
            for (int col = 0; col < gridCol; col++) {
                if ((row == 0 || row == gridRow - 1) && col != 0)
                    grid[row][col] = '-';
                else if (row % 4 == 0 && row != 0)
                    grid[row][col] = '+';
                else if (col % 4 == 0 && col != 0)
                    grid[row][col] = '|';
                else if (col == 0 || col == gridCol - 1)
                    grid[row][col] = '|';
                else
                    grid[row][col] = ' ';
            }
       
        // Draw grid heading
        int stepper = 1;
        for (int col = 0; col < gridCol; col++) {
            if (col == 0)
                System.out.print("   ");
            else if (col == (4 * stepper - 2)) {
                System.out.print(stepper);
                stepper++;
            }
            else
                System.out.print(' ');
        }
        System.out.println();
        
        // Draw grid
        stepper = 1;
        for (int row = 0; row < gridRow; row++) {
           for (int col = 0; col < gridCol; col++) {
               if (col == 0)
                   if (row == ((4 * stepper) -2)) {
                       System.out.print(stepper + "  |");
                       stepper++;
                   }
                   else
                   {
                       System.out.print("   |");
                   }
               else
                   System.out.print(grid[row][col]);
           }
           System.out.println();
       }
       
        for (int row = 0; row < Map.ROWS; row++) {
            for (int col = 0; col < Map.COLUMNS;  col++) {
                char locationType = map.getLocationAt(row,col).getLocationType().toString().charAt(0);
                System.out.print(locationType);
                if (map.getLocationAt(row, col).getItem() != null) {
                    System.out.print(map.getLocationAt(row, col).getItem().getItemName().charAt(0));
                }
                System.out.print("  ");
            }
            System.out.println(" ");
        }
        
        Location playerLoc = FireSwamp.getPlayer().getPlayerPosition();
        int playerRowPos = playerLoc.getLocationRow();
        int playerColPos = playerLoc.getLocationColumn();
        playerRowPos++;
        playerColPos++;
        System.out.println("\n** " + 
                FireSwamp.getPlayer().getPlayerName()
                         + " is at row " + playerRowPos
                         + " and at column " + playerColPos);
        
        map.mapStatistics();
        
          //this temporary section is for testing the checkInventory function
            ArrayList<Item> inventory = new ArrayList();
            InventoryControl inControl = new InventoryControl();
          
            Item rope = new Item();
            rope.setItemType(1);
            rope.setItemDescription("A sturdy rope");
            rope.setItemName("rope");
            inventory.add(rope);
            
            Item potion = new Item();
            potion.setItemType(2);
            potion.setItemDescription("A healing potion");
            potion.setItemName("potion");
            inventory.add(potion);
            
           try {
               int ropePositionInList = inControl.checkInventory(inventory, 1);
               System.out.println("\n inventory position is " + ropePositionInList); 
           }
           catch (InventoryControlException ice) {
                System.out.println(ice.getMessage()); }
            
            //end of testing checkInventory function
        
        
    }

    
    //look function checks for the sandy soil that indicates lightning sand
    private void look() {
        System.out.println("*** look() function called");
    }

    //listen functiono checks for popping sound that precedes a flame spurt
    private void listen() {
        System.out.println("*** listen() function called");
    }

    //smell function checks for the wet dog smell of a ROUS
    private void smell() {
       System.out.println("*** smell() function called");
    }

    private void takeItem() {
       System.out.println("*** takeItem() function called");
    }

    private void moveNorth() {
        Map map = FireSwamp.getCurrentGame().getGameMap();
        Player player = FireSwamp.getPlayer();
        try {
            MapControl.movePlayerDirection(player, Direction.NORTH);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
        
        
    }

    private void moveEast() {
        Map map = FireSwamp.getCurrentGame().getGameMap();
        Player player = FireSwamp.getPlayer();
        try {
            MapControl.movePlayerDirection(player, Direction.EAST);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
    }

    private void moveWest() {
        Map map = FireSwamp.getCurrentGame().getGameMap();
        Player player = FireSwamp.getPlayer();
        try {
            MapControl.movePlayerDirection(player, Direction.WEST);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
    }

    private void moveSouth() {
        Map map = FireSwamp.getCurrentGame().getGameMap();
        Player player = FireSwamp.getPlayer();
        try {
            MapControl.movePlayerDirection(player, Direction.SOUTH);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
    }

    private void saveGame() {
        System.out.println("*** saveGame() function called");
    }

    private void callHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        try {
            helpMenu.display();
        } catch (GameControlException gce) {
            System.out.println(gce.getMessage());
        }
    }

    private void goBack() {
        System.out.println("*** goBack() function called");
    }

    private void callWinGameView() {
        WinGameView winGame = new WinGameView();
        try {
            winGame.display();
        } catch (GameControlException ex) {
            Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
 
}
