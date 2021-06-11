package exception;

public class IsSaledException extends Exception{
    public IsSaledException() {
        super("This object is already saled");
    }
}
