package Domain.Rule;

import Domain.Board.Board;
import Domain.Board.Exception.OutOfBoardException;
import Domain.Board.Position;
import Domain.Board.PositionIterator;
import Domain.Exception.WrongMoveException;
import Domain.Figure.Color;
import Domain.Figure.Figure;
import Domain.Figure.Move.Movement;

import java.util.ArrayList;
import java.util.Optional;

public class CastlingRule extends Rule {
    @Override
    public boolean handle(Board board, Movement movement) throws WrongMoveException {
        if (movement.figureMoving.figure == Figure.FigureEnum.KING
                && movement.figureMoving.getCountMoves() == 0
                && Math.abs(movement.getHorizontalDistance()) == 2
        ) {
            Color.ColorEnum playingColor = movement.figureMoving.color;
            ArrayList<Position> positions;
            Position throughCheck;
            try {
                if (playingColor.equals(Color.ColorEnum.WHITE)) {
                    positions = board.getPositionsWithFigures(Color.ColorEnum.BLACK);
                    throughCheck = new Position(movement.from.getHorizontal().ordinal() + 1, movement.from.getVertical().ordinal());
                } else {
                    positions = board.getPositionsWithFigures(Color.ColorEnum.WHITE);
                    throughCheck = new Position(movement.from.getHorizontal().ordinal() - 1, movement.from.getVertical().ordinal());
                }

                // Is Out-of, through or into check ?
                for (Position opponentPosition : positions) {
                    Figure figureOpponent = board.getFigureAtPosition(opponentPosition).get();
                    if (figureOpponent.figure != Figure.FigureEnum.KNIGHT) {
                        // Are we trying to move over figures ?
                        for (Position position : new PositionIterator(movement.from, movement.to)) {
                            if (board.getFigureAtPosition(position).isPresent()
                                    && !board.getFigureAtPosition(position).get().equals(movement.figureAtDestination)
                            ) {
                                break;
                            }
                        }
                    }

                    if (figureOpponent.move(new Movement(opponentPosition, movement.from))) {
                        throw new WrongMoveException("Can't castle out-of check.");
                    }
                    if (figureOpponent.move(new Movement(opponentPosition, throughCheck))) {
                        throw new WrongMoveException("Can't castle through check.");
                    }
                    if (figureOpponent.move(new Movement(opponentPosition, movement.to))) {
                        throw new WrongMoveException("Can't castle into check.");
                    }
                }

                Position rookPosition;
                Position rookDestination;

                if (movement.getHorizontalDistance() == 2) {
                    // Castling king side
                    rookPosition = new Position(movement.from.getHorizontal().ordinal() + 3, movement.from.getVertical().ordinal());
                    rookDestination = new Position(movement.to.getHorizontal().ordinal() - 1, movement.to.getVertical().ordinal());
                } else {
                    // Castling queen side
                    rookPosition = new Position(movement.from.getHorizontal().ordinal() - 4, movement.from.getVertical().ordinal());
                    rookDestination = new Position(movement.to.getHorizontal().ordinal() + 1, movement.to.getVertical().ordinal());
                }

                Optional<Figure> rook = board.getFigureAtPosition(rookPosition);
                if (rook.isEmpty() || rook.get().figure != Figure.FigureEnum.ROOK) {
                    throw new WrongMoveException("Can't castle if rook has moved");
                }
                if (board.getFigureAtPosition(rookDestination).isPresent()) {
                    throw new WrongMoveException("Can't castle if another figure is placed at rook destination");
                }

                // King move
                checkNext(board, movement);

                // Rook move
                board.MoveFigureTo(new Movement(rookPosition, rookDestination, rook.get(), null));

                return true;
            } catch (OutOfBoardException ignored) {}
        }

        return checkNext(board, movement);
    }
}
