package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Game;
import byui.cit260.fireSwamp.model.Item;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Nikkala
 */

class WriteInventoryView {
    
    public static void writeInventory(ArrayList<Item> itemList, String filepath) throws GameControlException {
        
       
        try (PrintWriter output = new PrintWriter(filepath))
            //write the inventory to the file
            {
                String header = "Your inventory contains:";
                output.println(header);
                
                for (Item item : itemList) {
                    output.println(item.itemName);  //I had to make itemName public for this to work.  Why?
                }
                output.flush();
            }
        
        catch(Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
    }
    
}
