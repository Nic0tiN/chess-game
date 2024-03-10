package Domain.Rule;

import Domain.Board.Board;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Move.Movement;

public abstract class Rule {
    private Rule next = null;

    abstract public boolean handle(Board board, Movement movement) throws WrongMoveException;

    public static Rule link(Rule first, Rule... chain) {
        Rule head = first;
        for (Rule nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }

        return first;
    }

    protected boolean checkNext(Board board, Movement movement) throws WrongMoveException {
        if (next == null) {
            return true;
        }

        return next.handle(board, movement);
    }
}
