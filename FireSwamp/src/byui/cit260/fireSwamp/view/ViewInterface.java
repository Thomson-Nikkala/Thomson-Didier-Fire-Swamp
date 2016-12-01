package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;

/**
 *
 * @authors Nikkala Thomson and Didier Jourdain
 */

public interface ViewInterface {
    
    public void display() throws GameControlException;
    public String getInput();
    public boolean doAction(String value) throws GameControlException;
    
} 
