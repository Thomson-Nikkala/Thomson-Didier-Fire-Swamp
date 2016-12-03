package byui.cit260.fireSwamp.view;

import fireswamp.FireSwamp;
import java.io.PrintWriter;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
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
