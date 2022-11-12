import java.io.IOException;

public class ControllerGame {
	
	private Player players[] = new Player[2];
	private boolean winner;
	public ViewPlayer viewPlayer = new ViewPlayer();
	public ViewDatabase viewDB = new ViewDatabase();
	ModelDatabase DB = new ModelDatabase();
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] player) {
		this.players = player;
	}
	public boolean getWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	//Creates players
	public void setUpGame() {
		int i = 0;
		for(Player p: players) {
			boolean validName = false;
			while(!validName) {
				String name = viewPlayer.askName();
				if(name.matches("[a-zA-Z]+")) {
					validName = true;
					players[i] = new Player(name, new Board());
					i++;
				}
				else {
					viewPlayer.showNameError();
				}
			}
		}
	}
	
	//main flow of the game
	public Player makeGame() throws IOException {
		Player actualPlayer = players[0];
		int nextPlayer = 0;
		while(!winner) {
			actualPlayer = players[nextPlayer];
			nextPlayer = (nextPlayer + 1) % 2;
			
			boolean validMove = false;
			while(!validMove) {
				
				int move = actualPlayer.makeMove(players[nextPlayer], viewPlayer.askAttack());
				viewPlayer.showResultAttack(move);
				if(move == 4 || move == 0) {
					validMove = true;
				}
				System.out.println(move);
			}
			
			/*
			 * Cridar a vista que mostra el tauler 
			 */
			winner = players[nextPlayer].getBoard().checkWinner();
		}
		
		winner(actualPlayer);
		return actualPlayer;
	}
	
	public void winner(Player p) throws IOException {
		viewPlayer.showWinner(p);
		DB.connect();
		DB.modifyRanking(p);
		viewDB.showRanking(DB.getRanking());
	}
}
