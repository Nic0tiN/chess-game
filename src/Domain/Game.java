package Domain;

import Domain.Board.*;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Figure.Figure;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Game {
    private Board board;
    private final Color.ColorEnum lastMove = Color.ColorEnum.WHITE;
    private final List<Move> movesHistory;

    public Game() throws OutOfBoardException {
        this.board = new Board();
        this.movesHistory = new ArrayList<>();

        this.initialize();
    }

    private void initialize() throws OutOfBoardException {
        this.board.initialize();
    }

    public Boolean Move(String fromPosition, String toPosition) throws OutOfBoardException, WrongMoveException
    {
        Position from = new Position(fromPosition);
        Position to = new Position(toPosition);

        Optional<Figure> figureToMove = this.board.getFigureAtPosition(from);
        if (figureToMove.isEmpty()) {
            throw new WrongMoveException(String.format("No figures at position %s", fromPosition));
        }

        if (figureToMove.get().color != lastMove) {
            throw new WrongMoveException("This is not your turn.");
        }

        Move move;
        if (this.board.getFigureAtPosition(to).isPresent()) {
            move = new Move(from, to, this.board.getFigureAtPosition(to).get());
        } else {
            move = new Move(from, to);
        }

        this.movesHistory.add(move);

        figureToMove.get().move(move);

        this.board.MoveFigureTo(to, figureToMove.get());
        move.setMoveResult(true);

        return move.getMoveResult();
    }
}
