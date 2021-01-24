package token.operation;

import token.Token;
import visitor.TokenVisitor;

public abstract class OperationToken implements Token {
    public enum OperationType {ADD, SUB, MUL, DIV};
    private OperationType type;

    public OperationToken (OperationType type) {
        this.type = type;
    }

    public OperationType getType() {
        return type;
    }

    public abstract int getPriority();

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
