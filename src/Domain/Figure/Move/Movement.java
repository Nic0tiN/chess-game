package Domain.Figure.Move;

import Domain.Board.Position;
import Domain.Figure.Figure;

public final class Movement {
    public final Position from;
    public final Position to;
    public final Figure figureMoving;
    public final Figure figureAtDestination;
    private Boolean moveResult;

    public Movement(Position from, Position to) {
        this.from = from;
        this.to = to;
        this.moveResult = false;
        this.figureMoving = null;
        this.figureAtDestination = null;
    }

    public Movement(Position from, Position to, Figure figureMoving, Figure figureAtDestination) {
        this.figureMoving = figureMoving;
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
}
