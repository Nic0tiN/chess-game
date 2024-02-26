package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;

public class DiagonalMovementStrategy implements IMovementStrategy {
    @Override
    public List<Position> getPath(int hFromOrdinal, int vFromOrdinal, int hToOrdinal, int vToOrdinal) throws OutOfBoardException {
        boolean hReverted = hToOrdinal < hFromOrdinal;
        boolean vReverted = vToOrdinal < vFromOrdinal;

        List<Position> positions = new ArrayList<>();
        int ordinalPosition = Position.SIZE * (vFromOrdinal + 1) - (Position.SIZE - (hFromOrdinal + 1));
        if (hReverted) {
            for (int i = hFromOrdinal; i > hToOrdinal; i--) {
                ordinalPosition = ordinalPosition - 1;
                if (vReverted) {
                    ordinalPosition -= 8;
                } else {
                    ordinalPosition += 8;
                }
                positions.add(new Position(ordinalPosition));
            }
        } else {
            for (int i = hFromOrdinal + 1; i <= hToOrdinal; i++) {
                ordinalPosition = ordinalPosition + 1;
                if (vReverted) {
                    ordinalPosition -= 8;
                } else {
                    ordinalPosition += 8;
                }
                positions.add(new Position(ordinalPosition));
            }
        }

        return positions;
    }
}
