package visitor;

import token.NumberToken;
import token.Token;
import token.brace.BraceToken;
import token.operation.OperationToken;

import java.util.List;
import java.util.Stack;

public class CalcVisitor implements TokenVisitor {
    private Stack<Integer> stack = new Stack<>();

    @Override
    public void visit(NumberToken token) {
        stack.push(token.getNumber());
    }

    @Override
    public void visit(BraceToken token) {
        throw new IllegalStateException("Unexpected brace in RPN");
    }

    @Override
    public void visit(OperationToken token) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Not enough arguments for operation");
        }
        int b = stack.pop();
        int a = stack.pop();

        switch (token.getType()) {
            case ADD:
                stack.push(a + b);
                break;
            case SUB:
                stack.push(a - b);
                break;
            case MUL:
                stack.push(a * b);
                break;
            case DIV:
                stack.push(a / b);
                break;
        }
    }

    public int visit(List<Token> tokens) {
        tokens.forEach(x -> x.accept(this));
        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid expression");
        }
        return stack.pop();
    }
}
