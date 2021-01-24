package token.operation;

public class MulOperationToken extends OperationToken {
    public MulOperationToken() {
        super(OperationType.MUL);
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
