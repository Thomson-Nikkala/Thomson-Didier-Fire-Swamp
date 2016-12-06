package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Game;
import byui.cit260.fireSwamp.model.Item;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Nikkala
 */

class WriteInventoryView {
    
    public static void writeInventory(Game game, String filepath) throws GameControlException {
        
        try( FileOutputStream fops = new FileOutputStream(filepath)) {
                        
            //write the inventory to the file
            String header = "Your inventory contains:";
            // get the header in bytes
            byte[] headerInBytes = header.getBytes();
            fops.write(headerInBytes);
			
            //for (Item item : game.gameItemList) {
            //   output.writeChars("\n" + item.itemName);
            //}
            fops.flush();
            fops.close();
        }
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
    }
    
}
