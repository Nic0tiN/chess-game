package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;
import Domain.Figure.Move.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PositionIterator implements Iterable<Position>, Iterator<Position> {
    private final Position from, to;
    private int currentPosition = 0;
    private List<Position> positions = new ArrayList<>();

    public PositionIterator(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    private void loadPath() throws OutOfBoardException {
        MoveSpecification movement;
        Movement move = new Movement(from, to);
        IMovementStrategy strategy = null;

        movement = new MoveDiagonally();
        if (movement.IsSatisfiedBy(move)) {
            strategy = new DiagonalMovementStrategy();
        } else {
            movement = new MoveHorizontally();
            if (movement.IsSatisfiedBy(move)) {
                strategy = new HorizontalMovementStrategy();
            }

            movement = new MoveVertically();
            if (movement.IsSatisfiedBy(move)) {
                strategy = new VerticalMovementStrategy();
            }

            movement = new MoveLShape();
            if (movement.IsSatisfiedBy(move)) {
                strategy = new LShapeMovementStrategy();
            }
        }

        if (strategy != null) {
            this.positions = strategy.getPath(
                    this.from.getHorizontal().ordinal(),
                    this.from.getVertical().ordinal(),
                    this.to.getHorizontal().ordinal(),
                    this.to.getVertical().ordinal()
            );
        }
    }

    @Override
    public boolean hasNext() {
        if (positions.isEmpty()) {
            try {
                this.loadPath();
            } catch (OutOfBoardException ignored) {}
        }

        return currentPosition < positions.size();
    }

    @Override
    public Position next() {
        if (!hasNext()) {
            return null;
        }

        return positions.get(currentPosition++);
    }

    @Override
    public void remove() {
        currentPosition = 0;
        Iterator.super.remove();
    }

    @Override
    public Iterator<Position> iterator() {
        return this;
    }
}
