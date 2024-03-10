package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class HorizontalMovementStrategy implements IMovementStrategy {
    @Override
    public List<Position> getPath(int hFromOrdinal, int vFromOrdinal, int hToOrdinal, int vToOrdinal) throws OutOfBoardException {
        boolean reverted = hToOrdinal < hFromOrdinal;
        List<Position> positions = new ArrayList<>();

        int ordinalPosition = Position.ordinalFromIndex(vFromOrdinal, hFromOrdinal);
        if (reverted) {
            for (int i = hFromOrdinal; i > hToOrdinal; i--) {
                positions.add(new Position(--ordinalPosition));
            }
        } else {
            for (int i = hFromOrdinal + 1; i <= hToOrdinal; i++) {
                positions.add(new Position(++ordinalPosition));
            }
        }

        return positions;
    }
}
