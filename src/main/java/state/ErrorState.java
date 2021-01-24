package state;

public class ErrorState extends State {
    private String message;

    public ErrorState(Tokenizer tokenizer, String message) {
        super(tokenizer);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void readCharacter() {}

    public boolean isTerminal() {
        return true;
    }
}
