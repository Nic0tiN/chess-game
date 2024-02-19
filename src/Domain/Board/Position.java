package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;

public class Position {
    private final VERTICAL vertical;
    private final HORIZONTAL horizontal;
    public final static int SIZE = 8;

    private static final String[] mapHorizontal = {
            HORIZONTAL.H.toString(),
            HORIZONTAL.A.toString(),
            HORIZONTAL.B.toString(),
            HORIZONTAL.C.toString(),
            HORIZONTAL.D.toString(),
            HORIZONTAL.E.toString(),
            HORIZONTAL.F.toString(),
            HORIZONTAL.G.toString()
    };
    private static final String[] mapVertical = {
            "",
            VERTICAL.ONE.toString(),
            VERTICAL.TWO.toString(),
            VERTICAL.THREE.toString(),
            VERTICAL.FOUR.toString(),
            VERTICAL.FIVE.toString(),
            VERTICAL.SIX.toString(),
            VERTICAL.SEVEN.toString(),
            VERTICAL.EIGHT.toString(),
    };

    public enum HORIZONTAL {
        A, B, C, D, E, F, G, H;
    }
    public enum VERTICAL {
        ONE, TWO, THREE, FOUR, FIVE , SIX, SEVEN, EIGHT;
    }

    public Position(int index) throws OutOfBoardException {
        Position position = Position.FromOrdinal(index);
        this.horizontal = position.horizontal;
        this.vertical = position.vertical;
    }
    public Position(String strPosition) throws OutOfBoardException {
        Position position = Position.FromString(strPosition);
        this.horizontal = position.horizontal;
        this.vertical = position.vertical;
    }

    public Position(HORIZONTAL horizontal, VERTICAL vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public VERTICAL getVertical() {
        return this.vertical;
    }
    public HORIZONTAL getHorizontal() {
        return this.horizontal;
    }

    private static Position FromOrdinal(int index) throws OutOfBoardException {
        if (index < 1 || index > (SIZE * SIZE)) {
            throw new OutOfBoardException(String.format("Specified ordinal position '%d' is out of board.", index));
        }

        int iH = index % SIZE;
        int iV = Math.ceilDiv(index, SIZE);

        return new Position(
                HORIZONTAL.valueOf(Position.mapHorizontal[iH]),
                VERTICAL.valueOf(Position.mapVertical[iV])
        );
    }
    private static Position FromString(String position) throws OutOfBoardException {
        String horizontal = position.substring(0, 1);
        int vertical = Integer.valueOf(position.substring(1, 2));

        return new Position(HORIZONTAL.valueOf(horizontal), VERTICAL.valueOf(Position.mapVertical[vertical]));
    }
}
