package token.operation;

public class SubOperationToken extends OperationToken {
    public SubOperationToken() {
        super(OperationType.SUB);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
