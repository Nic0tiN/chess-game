package Domain.Figure.Move;

import Domain.Board.Position;
import Domain.Figure.Figure;

public final class Move {
    public final Position from;
    public final Position to;
    public final Figure figureAtDestination;
    private Boolean moveResult;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
        this.moveResult = false;
        this.figureAtDestination = null;
    }

    public Move(Position from, Position to, Figure figureAtDestination) {
        this.from = from;
        this.to = to;
        this.figureAtDestination = figureAtDestination;
        this.moveResult = false;
    }

    public void setMoveResult(Boolean moveResult) {
        this.moveResult = moveResult;
    }

    public Boolean getMoveResult() {
        return moveResult;
    }

    public int getVerticalDistance() {
        return this.to.getVertical().ordinal() - this.from.getVertical().ordinal();
    }

    public int getHorizontalDistance() {
        return this.to.getHorizontal().ordinal() - this.from.getHorizontal().ordinal();
    }

    public Figure getFigureAtDestination() {
        return figureAtDestination;
    }
}
