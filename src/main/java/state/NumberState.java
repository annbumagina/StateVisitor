package state;

import token.NumberToken;

public class NumberState extends State {
    private int number;

    public NumberState(Tokenizer tokenizer, int number) {
        super(tokenizer);
        this.number = number;
    }

    public void readCharacter() {
        char c = tokenizer.getCurr();
        if (Character.isDigit(c)) {
            number = number * 10 + Character.getNumericValue(c);
            tokenizer.next();
        } else {
            tokenizer.addToken(new NumberToken(number));
            tokenizer.changeState(new StartState(tokenizer));
        }
    }

    public boolean isTerminal() {
        return false;
    }
}
