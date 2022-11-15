import java.io.IOException;

/**
 * La classe Controllergame es l'encargada de controlar la interacció entre la vista i el model del Game
 */
public class ControllerGame {
	
	public Player players[] = new Player[2];
	private boolean winner;
	public ViewPlayer viewPlayer = new ViewPlayer();
	public ViewDatabase viewDB = new ViewDatabase();
	public ModelDatabase DB = new ModelDatabase("./Ranking.txt");
	public ViewBoard viewBoard = new ViewBoard();
	 
	/**
   	* Inicialitza els atributs de cada jugador.
 	*/
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
	
	/**
   	* Inicialitza el tauler de cada jugador, cada un col·loca els seus barcos.
 	*/
	public void setUpBoards() {
		for (Player p: players) {
			System.out.println("Jugador " + p.getName());
			p.getBoard().buildBoard();
			viewBoard.showBoardToPlayer(p.getBoard());
			System.out.println("\n\n\n\n");
		}
	}
	/**
   	* Es el flux principal del joc, a través de crides al tauler i altres classes cada jugador fa els seus moviments fins que un guanya.
	*
 	* @return    el jugador guanyador
 	*/
	public Player makeGame() throws IOException {
		setUpBoards();
		Player actualPlayer = players[0];
		int nextPlayer = 0;
		while(!winner) {
			actualPlayer = players[nextPlayer];
			nextPlayer = (nextPlayer + 1) % 2;
			System.out.println("Jugador " + actualPlayer.getName());
			boolean validMove = false;
			while(!validMove) {
				viewBoard.showBoardToEnemy(players[nextPlayer].getBoard());
				int move = actualPlayer.makeMove(players[nextPlayer], viewPlayer.askAttack());
				viewPlayer.showResultAttack(move);
				if(move == 4 || move == 0) {
					validMove = true;
				}
			}
			System.out.println("\n\n\n\n");
			winner = players[nextPlayer].getBoard().checkWinner();
		}
		
		winner(actualPlayer);
		return actualPlayer;
	}
	
	/**
   	* Actualitza/guarda  en la base de dades del ranking el jugador que hagi guanyat en la partida.
	*
	* @param  p	jugador que ha guanyat una partida
 	*/
	public void winner(Player p) throws IOException {
		viewPlayer.showWinner(p);
		DB.connect();
		DB.modifyRanking(p);
		viewDB.showRanking(DB.getRanking());
		DB.disconnect();
	}
}
