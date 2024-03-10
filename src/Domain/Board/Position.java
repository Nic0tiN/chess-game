package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;

import java.util.Objects;

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
        A, B, C, D, E, F, G, H
    }
    public enum VERTICAL {
        ONE, TWO, THREE, FOUR, FIVE , SIX, SEVEN, EIGHT
    }

    public Position(int index) throws OutOfBoardException {
        Position position = Position.FromOrdinal(index);
        this.horizontal = position.horizontal;
        this.vertical = position.vertical;
    }
    public Position(int indexHorizontal, int indexVertical) throws OutOfBoardException {
        int ordinalPosition = Position.ordinalFromIndex(indexVertical, indexHorizontal);
        Position position = Position.FromOrdinal(ordinalPosition);
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
    private static Position FromString(String position) {
        String horizontal = position.substring(0, 1);
        int vertical = Integer.parseInt(position.substring(1, 2));

        return new Position(HORIZONTAL.valueOf(horizontal), VERTICAL.valueOf(Position.mapVertical[vertical]));
    }
    public static int ordinalFromIndex(int vertical, int horizontal) {
        return Position.SIZE * (vertical + 1) - (Position.SIZE - (horizontal + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;
        return vertical == position.vertical && horizontal == position.horizontal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }

    @Override
    public String toString() {
        return String.format("%s%s", horizontal.toString(), vertical.ordinal() + 1);
    }
}
