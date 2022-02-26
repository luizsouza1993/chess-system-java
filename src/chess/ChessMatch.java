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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.White), new Position(2,1));
		board.placePiece(new King(board, Color.White), new Position(3,1));
		board.placePiece(new Rook(board, Color.White), new Position(4,1));
	}
		
}
