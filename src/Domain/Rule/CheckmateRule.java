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

public class CheckmateRule extends Rule {
    @Override
    public boolean handle(Board board, Movement movement) throws WrongMoveException {
        Color.ColorEnum playingColor = movement.figureMoving.color;
        ArrayList<Position> opponentPositions;
        ArrayList<Position> currentPlayerPositions;
        Position playingKingPosition;
        Figure playingKingFigure;

        try {
            if (playingColor.equals(Color.ColorEnum.WHITE)) {
                opponentPositions = board.getPositionsWithFigures(Color.ColorEnum.BLACK);
                currentPlayerPositions = board.getPositionsWithFigures(Color.ColorEnum.WHITE);
            } else {
                opponentPositions = board.getPositionsWithFigures(Color.ColorEnum.WHITE);
                currentPlayerPositions = board.getPositionsWithFigures(Color.ColorEnum.BLACK);
            }

            // Find King
            playingKingPosition = currentPlayerPositions.stream().filter(p -> board.getFigureAtPosition(p).get().figure == Figure.FigureEnum.KING).findFirst().get();
            playingKingFigure = board.getFigureAtPosition(playingKingPosition).get();

            // Is king threatened
            for (Position opponentPosition : opponentPositions) {
                Figure figureOpponent = board.getFigureAtPosition(opponentPosition).get();
                // NOTE : Should we consider when king position itself in check ? Or this may be another rule
                if (this.isKingThreatenedBy(figureOpponent, new Movement(opponentPosition, playingKingPosition, figureOpponent, playingKingFigure), board)) {
                    if (movement.figureMoving.equals(playingKingFigure)) {
                        // Trying to get out-of-check
                        if (this.isKingThreatenedBy(figureOpponent, new Movement(opponentPosition, movement.to, figureOpponent, null), board)) {
                            throw new WrongMoveException("Checkmate !");
                        }
                    } else if (movement.figureAtDestination == null || !movement.figureAtDestination.equals(figureOpponent)) {
                        // Not capturing the opponent
                        throw new WrongMoveException("Checkmate !");
                    }
                }
            }
        } catch (OutOfBoardException ignored) {}

        return checkNext(board, movement);
    }

    private Boolean isKingThreatenedBy(Figure opponent, Movement movement, Board board) {
        if (opponent.move(movement)) {
            for (Position position : new PositionIterator(movement.from, movement.to)) {
                if (position.equals(movement.to)) {
                    return true; // Opponent can reach destination and threaten king. Check before board as virtual movement is not reflected on board
                }

                if (board.getFigureAtPosition(position).isPresent()
                        && !board.getFigureAtPosition(position).get().equals(movement.figureAtDestination)
                ) {
                    return false;
                }
            }
        }

        return false;
    }
}
