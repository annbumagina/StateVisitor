package state;

public class EndState extends State {
    public EndState(Tokenizer tokenizer) {
        super(tokenizer);
    }

    public void readCharacter() {}

    public boolean isTerminal() {
        return true;
    }
}
