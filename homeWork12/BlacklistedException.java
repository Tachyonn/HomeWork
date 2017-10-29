package homeWork12;

public class BlacklistedException extends Exception {
    private String message = "Class blacklisted!";

    public BlacklistedException() {
        super();
    }

    public BlacklistedException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
