/**
 * description: InvalidDataFormatException
 * @author: delongh
 */
public class InvalidDataFormatException extends Exception {
    String message = "";

    public  InvalidDataFormatException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
