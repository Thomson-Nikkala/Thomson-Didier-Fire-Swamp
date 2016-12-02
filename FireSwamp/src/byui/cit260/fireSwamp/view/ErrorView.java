/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

import fireswamp.FireSwamp;
import java.io.PrintWriter;

/**
 *
 * @author Didier Jourdain and Nikkala Thomson
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = FireSwamp.getOutFile();
    private static final PrintWriter logFile = FireSwamp.getLogFile();
    
    public static void display(String className, String errorMessage) {
        
        errorFile.println(
                    "------------------------------------------------------"
                  + "\n- ERROR - " + errorMessage
                  + "\n-----------------------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
}
