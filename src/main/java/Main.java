import state.Tokenizer;
import token.Token;
import visitor.CalcVisitor;
import visitor.ParseVisitor;
import visitor.PrintVisitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer(System.in);
        List<Token> tokens = tokenizer.tokenize();
        tokens = new ParseVisitor().visit(tokens);
        System.out.print("RPN: ");
        new PrintVisitor(System.out).visit(tokens);
        System.out.println("Result: " + new CalcVisitor().visit(tokens));
    }
}
