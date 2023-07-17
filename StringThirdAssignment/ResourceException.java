import java.io.Serializable;
import java.lang.Object;
import java.lang.Throwable;
import java.lang.Exception;
import java.lang.RuntimeException;
public class ResourceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceException (String message) {
        super(message);
    }

    public ResourceException (String message, Throwable cause) {
        super(message, cause);
    }
}
