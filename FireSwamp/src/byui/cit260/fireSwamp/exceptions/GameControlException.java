package byui.cit260.fireSwamp.exceptions;

/**
 *
 * @authors Nikkala and Didier
 */
public class GameControlException extends Exception {

    public GameControlException() {
    }

    public GameControlException(String message) {
        super(message);
    }

    public GameControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameControlException(Throwable cause) {
        super(cause);
    }

    public GameControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
