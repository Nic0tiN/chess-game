package Domain;

import Domain.Board.Board;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Color;
import Domain.Figure.Figure;
import Domain.Figure.Move.Movement;
import Domain.Rule.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Game {
    private final Board board;
    private final List<Movement> movesHistory; // Todo: Change to pattern Memento
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
                new TurnRule(Color.ColorEnum.WHITE),
                new CheckmateRule(),
                new CastlingRule(),
                new EnPassantRule(this.movesHistory),
                new MovingRule()
        );
    }

    public Boolean Move(String fromPosition, String toPosition) throws OutOfBoardException, WrongMoveException
    {
        Position from = new Position(fromPosition);
        Position to = new Position(toPosition);

        Movement movement;
        Optional<Figure> figureMoving = this.board.getFigureAtPosition(from);
        Optional<Figure> figureTaken = this.board.getFigureAtPosition(to);

        if (figureMoving.isPresent()) {
            if (figureTaken.isPresent()) {
                movement = new Movement(from, to, figureMoving.get(), figureTaken.get());
            } else {
                movement = new Movement(from, to, figureMoving.get(), null);
            }
        } else {
            movement = new Movement(from, to);
        }

        if (rules.handle(this.board, movement)) {
            movement.setMoveResult(true);
            this.movesHistory.add(movement);
        }

        return movement.getMoveResult();
    }

    public Board getBoard() {
        return this.board;
    }
    public Figure[][] getFigures() {
        return this.board.getBoard();
    }
}
