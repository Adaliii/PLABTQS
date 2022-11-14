import java.io.IOException;

public class ControllerGame {
	
	public Player players[] = new Player[2];
	private boolean winner;
	public ViewPlayer viewPlayer = new ViewPlayer();
	public ViewDatabase viewDB = new ViewDatabase();
	public ModelDatabase DB = new ModelDatabase("./Ranking.txt");
	public ViewBoard viewBoard = new ViewBoard();
	 
	//Creates players
	public void setUpPlayers() {
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
	public void setUpBoards() {
		for (Player p: players) {
			p.getBoard().buildBoard();
			viewBoard.showBoardToPlayer(p.getBoard());
		}
	}
	//main flow of the game
	public Player makeGame() throws IOException {
		setUpBoards();
		Player actualPlayer = players[0];
		int nextPlayer = 0;
		while(!winner) {
			actualPlayer = players[nextPlayer];
			nextPlayer = (nextPlayer + 1) % 2;
			
			boolean validMove = false;
			while(!validMove) {
				viewBoard.showBoardToEnemy(players[nextPlayer].getBoard());
				int move = actualPlayer.makeMove(players[nextPlayer], viewPlayer.askAttack());
				viewPlayer.showResultAttack(move);
				if(move == 4 || move == 0) {
					validMove = true;
				}
			}
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
		DB.disconnect();
	}
}
