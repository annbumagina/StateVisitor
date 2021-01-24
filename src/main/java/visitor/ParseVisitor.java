package visitor;

import token.Token;
import token.brace.BraceToken;
import token.NumberToken;
import token.operation.OperationToken;

import java.util.*;

public class ParseVisitor implements TokenVisitor {
    private List<Token> result = new ArrayList<>();
    private Stack<Token> opStack = new Stack<>();

    @Override
    public void visit(NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(BraceToken token) {
        switch (token.getType()) {
            case LEFT:
                opStack.push(token);
                break;
            case RIGHT:
                while (!opStack.empty() && !(opStack.peek() instanceof BraceToken)) {
                    result.add(opStack.pop());
                }
                if (opStack.empty() || ((BraceToken) opStack.peek()).getType() != BraceToken.BraceType.LEFT) {
                    throw new IllegalStateException("Mismatched brackets");
                }
                opStack.pop();
                break;
        }
    }

    @Override
    public void visit(OperationToken token) {
        while (!opStack.empty() && !(opStack.peek() instanceof BraceToken) &&
            ((OperationToken) opStack.peek()).getPriority() >= token.getPriority()) {
            result.add(opStack.pop());
        }
        opStack.push(token);
    }

    public List<Token> visit(List<Token> tokens) {
        tokens.forEach(x -> x.accept(this));
        while (!opStack.empty()) {
            if (opStack.peek() instanceof BraceToken) {
                throw new IllegalStateException("Mismatched brackets");
            }
            result.add(opStack.pop());
        }
        return result;
    }
}
