package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    //verifica torre apta para roque
    private boolean testRookCastling(Position position){
        ChessPiece positionOfRook =(ChessPiece) getBoard().piece(position);
        return positionOfRook != null && positionOfRook instanceof Rook && positionOfRook.getColor() == getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] isPossible = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);
        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            isPossible[p.getRow()][p.getColumn()] = true;
        }
        //roque pequeno
        p.setValues(position.getRow(), position.getColumn() + 2);
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            Position rookL = new Position(position.getRow(), position.getColumn() +3);
            if (testRookCastling(rookL)){
                Position positionSideOne = new Position(position.getRow(), position.getColumn() + 1);
                Position positionSideTwo = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(positionSideOne) == null && getBoard().piece(positionSideTwo) == null){
                    isPossible[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            //roque grande
            Position rookB = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(rookB)){
                Position positionSideOne = new Position(position.getRow(), position.getColumn() - 1);
                Position positionSideTwo = new Position(position.getRow(), position.getColumn() - 2);
                Position positionSideThree = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(positionSideOne) == null && getBoard().piece(positionSideTwo) == null && getBoard().piece(positionSideThree) == null){
                    isPossible[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

            return isPossible;
    }
}
