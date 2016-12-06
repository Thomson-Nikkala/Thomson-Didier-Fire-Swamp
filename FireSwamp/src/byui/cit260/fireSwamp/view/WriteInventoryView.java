package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Game;
import byui.cit260.fireSwamp.model.Item;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Nikkala
 */

class WriteInventoryView {
    
    public static void writeInventory(Game game, String filepath) throws GameControlException {
        
       
        try (PrintWriter output = new PrintWriter(filepath))
            //write the inventory to the file
            {
                String header = "Your inventory contains:";
                output.println(header);
                
                //for (Item item : game.gameItemList) {
                //    output.println(item.itemName);
                //}
                output.flush();
            }
        
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
    }
    
}
