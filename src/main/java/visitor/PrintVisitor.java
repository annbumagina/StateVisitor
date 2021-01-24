package visitor;

import token.Token;
import token.brace.BraceToken;
import token.NumberToken;
import token.operation.OperationToken;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

public class PrintVisitor implements TokenVisitor {
    private PrintWriter writer;

    public PrintVisitor(OutputStream stream) {
        writer = new PrintWriter(stream);
    }

    @Override
    public void visit(NumberToken token) {
        writer.print(token.getNumber() + " ");
    }

    @Override
    public void visit(BraceToken token) {
        switch (token.getType()) {
            case LEFT:
                writer.print("( ");
                break;
            case RIGHT:
                writer.print(") ");
                break;
        }
    }

    @Override
    public void visit(OperationToken token) {
        switch (token.getType()) {
            case ADD:
                writer.print("+ ");
                break;
            case SUB:
                writer.print("- ");
                break;
            case MUL:
                writer.print("* ");
                break;
            case DIV:
                writer.print("/ ");
                break;
        }
    }

    public void visit(List<Token> tokens) {
        tokens.forEach(x -> x.accept(this));
        writer.println();
        writer.flush();
    }
}
