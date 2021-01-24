package state;

public abstract class State {
    protected Tokenizer tokenizer;

    public State(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public abstract void readCharacter();

    public abstract boolean isTerminal();
}
