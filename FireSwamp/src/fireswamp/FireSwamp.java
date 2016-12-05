/** *************************************************
 * FireSwamp Class                                  *
 *                                                  *
 ************************************************** */
package fireswamp;

import byui.cit260.fireSwamp.model.*;
import byui.cit260.fireSwamp.view.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class FireSwamp {

    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        FireSwamp.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        FireSwamp.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        FireSwamp.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        FireSwamp.currentGame = currentGame;
    }

    /**
     * @param player
     */
    public static void setPlayer(Player player) {
        FireSwamp.player = player;
    }

    public static Player getPlayer() {
        return FireSwamp.player;
    }

    public static void main(String[] args){

        try {
            
            // open character stream files for end user input and output
            FireSwamp.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            FireSwamp.outFile =
                    new PrintWriter(System.out, true);
            // open log file
            String filePath = "log.txt";
            FireSwamp.logFile = new PrintWriter(filePath);
            
            // Create StartProgramView and start the program 
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();
            return;
        
        } catch (Throwable e) {
            
            System.out.println("Exception: " + e.toString() +
                               "\nCause: " + e.getCause() +
                               "\nMessage: " + e.getMessage());
        }        
        finally {
            try {
                if (FireSwamp.inFile != null)
                    FireSwamp.inFile.close();
                
                if (FireSwamp.outFile != null)
                    FireSwamp.outFile.close();
                
                if (FireSwamp.logFile != null)
                    FireSwamp.logFile.close();

                             
            } catch (IOException ex) {
                System.out.println("Error closing files");
            }
            
        }
        
    }

}
