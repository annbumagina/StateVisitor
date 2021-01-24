package token.brace;

import token.Token;
import visitor.TokenVisitor;

public abstract class BraceToken implements Token {
    public enum BraceType {LEFT, RIGHT};
    private BraceType type;

    public BraceToken (BraceType type) {
        this.type = type;
    }

    public BraceType getType() {
        return type;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
