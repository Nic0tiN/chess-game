package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class VerticalMovementStrategy implements IMovementStrategy {

    @Override
    public List<Position> getPath(int hFromOrdinal, int vFromOrdinal, int hToOrdinal, int vToOrdinal) throws OutOfBoardException {
        boolean reverted = vToOrdinal < vFromOrdinal;
        List<Position> positions = new ArrayList<>();

        int ordinalPosition = Position.SIZE * (vFromOrdinal + 1) - (Position.SIZE - (hFromOrdinal + 1));
        if (reverted) {
            for (int i = vFromOrdinal; i > vToOrdinal; i--) {
                ordinalPosition -= 8;
                positions.add(new Position(ordinalPosition));
            }
        } else {
            for (int i = vFromOrdinal + 1; i <= vToOrdinal; i++) {
                ordinalPosition += 8;
                positions.add(new Position(ordinalPosition));
            }
        }

        return positions;
    }
}
