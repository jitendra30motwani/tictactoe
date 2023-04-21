/**
 * 
 */
package design.lld.tictactoe;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 91978
 *
 */
public class TicTacToeLldDesign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque<Player> players = new LinkedList<>();
		
		players.add(new Player("A", new PlayingPieceX(PlayingPieceType.X)));
		players.add(new Player("B", new PlayingPieceX(PlayingPieceType.O)));
		
		TicTocToeGame ticTocToeGame = new TicTocToeGame(3, players);
		
		System.out.println("Winner is :"+ticTocToeGame.startGame()); 
	}

}

class PlayingPiece{
	
	private PlayingPieceType pieceType;
	
	public PlayingPiece(PlayingPieceType pieceType) {
		this.pieceType = pieceType;
	}
	
}

enum PlayingPieceType{
	
	X,O;
	
}


class PlayingPieceX extends PlayingPiece{
	
	public PlayingPieceX(PlayingPieceType pieceType) {
		super(pieceType);
	}
	
}

class PlayingPieceO extends PlayingPiece{
	
	public PlayingPieceO(PlayingPieceType pieceType) {
		super(pieceType);
	}
	
}

class Board{
	
	private int size;
	private PlayingPiece playingPiece[][];
	
	public Board(int size) {
		this.size = size;
		playingPiece = new PlayingPiece[this.size][this.size];
	}
	
	boolean addToBoard(int row, int col, PlayingPiece playingPiece) {
		//add valid for input
		if(this.playingPiece[row][col]==null) {
			this.playingPiece[row][col] = playingPiece;
			return true;
		}
		return false;
		
	}
	
}

class Player{
	
	private String name;
	private PlayingPiece playingPiece;
	
	public Player(String name, PlayingPiece playingPiece) {
		this.name = name;
		this.playingPiece = playingPiece;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayingPiece getPlayingPiece() {
		return playingPiece;
	}

	public void setPlayingPiece(PlayingPiece playingPiece) {
		this.playingPiece = playingPiece;
	}
	
	
	
}


class TicTocToeGame{
	
	private Deque<Player> players;
	private Board board;
	
	public TicTocToeGame(int boardSize,Deque<Player> players) {
		this.players = players;
		board = new Board(boardSize);
	}

	public String startGame() {
		
		boolean noWinner = true;
		
		while(noWinner) {
			
			Player player = players.getFirst();
			
			// Take input
			
			// check for empty cell
			
			int row=0;
			int col=0;
			PlayingPiece playingPiece=player.getPlayingPiece();
			
			boolean added = board.addToBoard(row, col, playingPiece);
			
			if(added) {
				players.addLast(players.removeFirst());
				boolean win = isThereAWinner(board, playingPiece);
				
				if(win) {
					return player.getName();
				}else {
					continue;
				}
				
				
			}else {
				//players.addFirst(player);
				continue;
			}
			
		}
		
		return "Tie";
		
	}

	private boolean isThereAWinner(Board board2, PlayingPiece playingPiece) {
		// TODO Auto-generated method stub
		return false;
	}
	
}