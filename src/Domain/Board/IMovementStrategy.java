package Domain.Board;

import Domain.Board.Exception.OutOfBoardException;

import java.util.List;

interface IMovementStrategy
{
    List<Position> getPath(int hFromOrdinal, int vFromOrdinal, int hToOrdinal, int vToOrdinal) throws OutOfBoardException;
}
