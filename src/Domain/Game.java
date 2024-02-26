package Domain;

import Domain.Board.*;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Figure.Color;
import Domain.Figure.Figure;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Move.Move;
import Domain.Rule.MovingRule;
import Domain.Rule.PositionRule;
import Domain.Rule.Rule;
import Domain.Rule.TurnRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Game {
    private final Board board;
    private Color.ColorEnum nextPlayingColor = Color.ColorEnum.WHITE;
    private final List<Move> movesHistory; // Todo: Change to pattern Memento
    private Rule rules;

    public Game() throws OutOfBoardException {
        this.board = new Board();
        this.movesHistory = new ArrayList<>();

        this.initialize();
    }

    private void initialize() throws OutOfBoardException {
        this.board.initialize();
        this.rules = Rule.link(
                new PositionRule(),
                new TurnRule(nextPlayingColor),
                new MovingRule()
        );
    }

    public Boolean Move(String fromPosition, String toPosition) throws OutOfBoardException, WrongMoveException
    {
        Position from = new Position(fromPosition);
        Position to = new Position(toPosition);

        Move move;
        Optional<Figure> figureMoving = this.board.getFigureAtPosition(from);
        Optional<Figure> figureTaken = this.board.getFigureAtPosition(to);

        if (figureMoving.isPresent()) {
            if (figureTaken.isPresent()) {
                move = new Move(from, to, figureMoving.get(), figureTaken.get());
            } else {
                move = new Move(from, to, figureMoving.get(), null);
            }
        } else {
            move = new Move(from, to);
        }

        if (rules.handle(this.board, move)) {
            move.setMoveResult(true);
            this.movesHistory.add(move);
        }

        return move.getMoveResult();
    }
}
