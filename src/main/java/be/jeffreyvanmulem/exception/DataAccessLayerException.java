package be.jeffreyvanmulem.exception;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 06/01/12
 * Time: 10:08
 * Represents Exceptions thrown by the Data Access Layer.
 */
public class DataAccessLayerException extends RuntimeException {
    public DataAccessLayerException() {
    }

    public DataAccessLayerException(String message) {
        super(message);
    }

    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }

    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}

