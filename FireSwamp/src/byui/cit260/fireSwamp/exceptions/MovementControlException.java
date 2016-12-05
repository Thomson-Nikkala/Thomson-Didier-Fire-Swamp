package byui.cit260.fireSwamp.exceptions;

/**
 *
 * @author Nikkala
 */
public class MovementControlException extends Exception {

    public MovementControlException() {
    }

    public MovementControlException(String message) {
        super(message);
    }

    public MovementControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovementControlException(Throwable cause) {
        super(cause);
    }

    public MovementControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
