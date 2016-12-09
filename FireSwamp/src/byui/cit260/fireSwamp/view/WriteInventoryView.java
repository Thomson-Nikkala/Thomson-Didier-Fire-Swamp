package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Item;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Nikkala
 */

public class WriteInventoryView extends View {
    
    public static void writeInventory(ArrayList<Item> itemList, String filepath) throws GameControlException {
      
       
        try (PrintWriter output = new PrintWriter(filepath))
            //write the inventory to the file
            {   
                String header = "Your inventory contains:";
                output.println(header);
                //if itemList is not empty, write each item on a new line
                if (itemList.isEmpty()) {
                    
                } else { 
                    for (Item item: itemList) {                        
                        output.println(item.getItemName());
                    }                   
                }   
                 
                output.flush();
            }
        
        catch(Exception e) {
            
            throw new GameControlException(e.getMessage());
            
        }
        
    }
   
    @Override
    public boolean doAction(String value) {
        return false;
    }
}
