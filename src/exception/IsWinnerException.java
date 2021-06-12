package exception;

public class IsWinnerException extends Exception{
    public IsWinnerException() {
        super("This player already won!");
    }
}
