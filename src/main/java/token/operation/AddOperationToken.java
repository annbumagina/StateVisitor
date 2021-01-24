package token.operation;

public class AddOperationToken extends OperationToken {
    public AddOperationToken() {
        super(OperationType.ADD);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
