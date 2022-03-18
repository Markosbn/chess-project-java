package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {


    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "H";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] isPossible = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() -2 , position.getColumn() +1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 2 , position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() +2 , position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }

        return isPossible;
    }
}
