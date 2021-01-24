package state;

import token.Token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private State state;
    private BufferedReader reader;
    private List<Token> tokens = new ArrayList<Token>();
    private char curr;

    public Tokenizer(InputStream stream) {
        this.state = new StartState(this);
        this.reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
    }

    public List<Token> tokenize() {
        next();
        while (!state.isTerminal()) {
            state.readCharacter();
        }
        if (state instanceof ErrorState) {
            throw new IllegalStateException(((ErrorState) state).getMessage());
        }
        return tokens;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void next() {
        try {
            curr = (char) reader.read();
        } catch (IOException e) {
            changeState(new ErrorState(this, "Error while reading from input stream"));
        }
    }

    public char getCurr() {
        return curr;
    }
}
