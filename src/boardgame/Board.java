package boardgame;

public class Board {
	
	private int rows;
	private int cols;
	private Piece[][] pieces;
	
	
	public Board(int rows, int cols) {
		if (rows < 1 || cols <1 ) {
			throw new BoardException("Error creating board!");
		}
		this.rows = rows;
		this.cols = cols;
		pieces = new Piece[rows][cols];
	}


	public int getRows() {
		return rows;
	}


	public int getCols() {
		return cols;
	}

	
	public Piece piece (int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return this.pieces[row][column];
	}
	
	public Piece piece (Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return this.pieces[position.getRow()][position.getCol()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is a piece on position: "+ position);
		}
		pieces[position.getRow()][position.getCol()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >= 0 && column < cols;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCol());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getCol()] = null;
		return aux;
	}

}
