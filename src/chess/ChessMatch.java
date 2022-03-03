package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	
	private Board board;
	
	public ChessMatch () {
		board = new Board(8,8);
		initialSetup();
	}
	
	
	public ChessPiece[][] getPieces(){
		
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getCols()];
		
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0;j<board.getCols();j++) {
				mat[i][j]= (ChessPiece) board.piece(i,j);
			}
		}
		return mat;
	}
	
	private void placeNewPiece(char col, int row, ChessPiece piece) {
		board.placePiece(piece,new ChessPosition(col, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b',6, new Rook(board, Color.White));
		placeNewPiece('c',5, new King(board, Color.White));
		placeNewPiece('e',1, new King(board, Color.Black));
	}
		
}
