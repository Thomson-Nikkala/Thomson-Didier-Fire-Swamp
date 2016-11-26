package byui.cit260.fireSwamp.exceptions;

/**
 *
 * @author Nikkala
 */
public class DangerControlException extends Exception {

    public DangerControlException() {
    }

    public DangerControlException(String message) {
        super(message);
    }

    public DangerControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public DangerControlException(Throwable cause) {
        super(cause);
    }

    public DangerControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
   
    
    
}
