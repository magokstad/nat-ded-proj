public class OperatorDoesNotExistException extends RuntimeException{
    OperatorDoesNotExistException(char c) {
        super("Operator " + c + " does not exist");
    }
}
