package token.operation;

public class DivOperationToken extends OperationToken {
    public DivOperationToken() {
        super(OperationType.DIV);
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
