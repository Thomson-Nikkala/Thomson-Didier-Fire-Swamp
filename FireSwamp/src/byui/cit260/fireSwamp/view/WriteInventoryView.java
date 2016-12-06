package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Game;
import byui.cit260.fireSwamp.model.Item;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Nikkala
 */

class WriteInventoryView {
    
    public static void writeInventory(Game game, String filepath) throws GameControlException {
        
        try( FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            //write the inventory to the file
            output.writeChars("Your inventory contains:");
            for (Item item : game.gameItemList) {
                output.writeChars("\n" + item.itemName);
            }
            
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
}
