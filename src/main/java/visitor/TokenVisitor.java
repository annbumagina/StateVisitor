package visitor;

import token.brace.BraceToken;
import token.NumberToken;
import token.operation.OperationToken;

public interface TokenVisitor {
    void visit(NumberToken token);
    void visit(BraceToken token);
    void visit(OperationToken token);
}
