package Domain.Figure.Move;

import Domain.Figure.Color;

abstract public class MoveForward extends MoveSpecification {

    protected int verticalDistance(Move move) {
        if (move.figureMoving == null || move.figureMoving.color.equals(Color.ColorEnum.WHITE)) {
            return move.getVerticalDistance();
        }

        return move.getVerticalDistance() * -1;
    }
}
