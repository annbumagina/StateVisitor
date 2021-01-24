package state;

import token.brace.LeftBraceToken;
import token.brace.RightBraceToken;
import token.operation.*;

public class StartState extends State {
    public StartState(Tokenizer tokenizer) {
        super(tokenizer);
    }

    public void readCharacter() {
        char c = tokenizer.getCurr();
        if (c == '\n' || c == '\r') {
            tokenizer.changeState(new EndState(tokenizer));
            return;
        }
        switch (c) {
            case '(':
                tokenizer.addToken(new LeftBraceToken());
                tokenizer.next();
                break;
            case ')':
                tokenizer.addToken(new RightBraceToken());
                tokenizer.next();
                break;
            case '+':
                tokenizer.addToken(new AddOperationToken());
                tokenizer.next();
                break;
            case '-':
                tokenizer.addToken(new SubOperationToken());
                tokenizer.next();
                break;
            case '*':
                tokenizer.addToken(new MulOperationToken());
                tokenizer.next();
                break;
            case '/':
                tokenizer.addToken(new DivOperationToken());
                tokenizer.next();
                break;
            case ' ':
                tokenizer.next();
                break;
            default:
                if (Character.isDigit(c)) {
                    tokenizer.changeState(new NumberState(tokenizer, 0));
                } else {
                    tokenizer.changeState(new ErrorState(tokenizer, "Unexpected character while reading '" + c + "'"));
                }
        }
    }

    public boolean isTerminal() {
        return false;
    }
}
