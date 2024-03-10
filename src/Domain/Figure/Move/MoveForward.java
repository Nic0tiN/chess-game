package Domain.Figure.Move;

import Domain.Figure.Color;

abstract public class MoveForward extends MoveSpecification {

    protected int verticalDistance(Movement movement) {
        if (movement.figureMoving == null || movement.figureMoving.color.equals(Color.ColorEnum.WHITE)) {
            return movement.getVerticalDistance();
        }

        return movement.getVerticalDistance() * -1;
    }
}
