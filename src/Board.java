/**
 * La classe Board crea el tauler base per jugar i té els mètodes suficients per modificar-la
 */
public class Board {
	public ViewBoard viewBoard = new ViewBoard();
	private int dimention; // dimensió del tauler = dimentin*dimention
	private Boat[] boats;
	private cell board[][]; // [row][column] == [number][letter]
	public enum cell{
		water,boat,hit,miss;		
	}
	
	// Constructor: Inicialitza el tauler amb totes les cel·les d'aigua.
	//		Afegeix les dades dels barcos que s'hauran de col·locar.
	public Board() {
		dimention = 8;
		this.board = new cell[dimention][dimention];
		for(int i=0;i<dimention;i++) {
			for(int j=0;j<dimention;j++) {
				board[i][j] = cell.water;
			}
		}
		Boat[] boats = new Boat[3];
		Boat b0 = new Boat(2);
		boats[0] = b0; 
		Boat b1 = new Boat(3);
		boats[1] = b1; 
 		Boat b2 = new Boat(3);
		boats[2] = b2; 
		setBoats(boats);
	} 
	
	// buildBoat i insertBoat estan separats per facilitar el testing
	/**
   	* Serveix per processar els inputs del jugador per posicionar els seus barcos
 	*/
	public void buildBoard() {      
		for(int i=0; i < boats.length; i++) {
			String position = "";
			boolean validBoat = false;
			viewBoard.showBoardToPlayer(this);
			while(!validBoat) {
				boolean validPosition = false;
				boolean validOrientation = false;
				validBoat = false;
				while(!validPosition) {
					position = viewBoard.askPositionBoat(boats[i].getLength());
					if(position.length() != 2) {
						viewBoard.showErrorPosition(position);
					}
					else {
						String columna = Character.toString(position.charAt(0));
						String fila = Character.toString(position.charAt(1));
						if(columna.matches("^[A-H]$") && fila.matches("^[1-8]$")) {
							validPosition = true;
						}
						else {
							viewBoard.showErrorPosition(position);
						}
					}
					
				}
				
				while(!validOrientation) {
					String orientation = viewBoard.askOrientation();
					if(orientation.length() == 1 ) {
						if (orientation.equals("V")) {
							validBoat = this.insertBoat(position, false, boats[i].getLength());
							validOrientation = true;
							if(!validBoat) {
								viewBoard.showBoatError();
								validPosition = false;
							}
							else {
								validBoat = true;
							}
						}
						else if(orientation.equals("H")) {
							validBoat = this.insertBoat(position, true, boats[i].getLength());
							validOrientation = true;
							if(!validBoat) {
								viewBoard.showBoatError();
								validPosition = false;
							}
							else {
								validBoat = true;
							}
						}
						else {
							viewBoard.showErrorOrientation(orientation);
						}
					}
					else {
						viewBoard.showErrorOrientation(orientation);
					}
						
				}
			}
		}
	}
	
	/**
   	* Serveix insertar un barco en la posicio i horientació desitjada.
	* Mira si no es surt dels limits del tauler.
	*
	* @param  pos		posicio on col·locar el barco
	* @param  horitzontal	orientació del barco
	* @param  length	tamany del barco
 	* @return         true si s'ha inserit correctament el barco
 	*/
	public boolean insertBoat(String pos, boolean horizontal, int length ) {
		int[] intPos = this.convertStringToPosition(pos);
		if(horizontal) {
			if((intPos[0] + length) <= dimention) { // no esta fora dels limits de les columnes
				for(int i =0; i < length; i++) {
					if(board[intPos[1]][intPos[0]+i] == cell.boat) {
						return false;
					}
					else {
						board[intPos[1]][intPos[0]+i]= cell.boat; // Avança col·locacio per les columnes
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		else { // vertical
			if((intPos[1] + length) <= dimention) { // no esta fora dels limits de les files
				for(int i =0; i < length; i++) {
					if(board[intPos[1]+i][intPos[0]].equals(cell.boat)) {
						return false;
					}
					else {
						board[intPos[1]+i][intPos[0]]= cell.boat; // Avança col·locacio per les files
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
   	* Processa el moviment/dispar del jugador en el tauler.
	*
	* @param  pos	posicio on dispara el jugador
 	* @return       0 si li dona a un barco (hit)
			1 si falla en una posició ja fallada
			2 si li dona a un barco que ja li havia donat
			3 si falla a donarli a un barco (miss)
 	*/
	public int makeMoveHit(String pos) {
		int[] intPos = this.convertStringToPosition(pos);
		if(board[intPos[1]][intPos[0]] == cell.boat) {
			board[intPos[1]][intPos[0]] = cell.hit;
			return 0;
		}
		else if(board[intPos[1]][intPos[0]] == cell.hit) {
			return 2;
		}
		else if(board[intPos[1]][intPos[0]] == cell.miss) {
			return 3;
		}
		else {
			board[intPos[1]][intPos[0]] = cell.miss;
			return 1;
		}
		
	}
	
	/**
   	* Recorre el tauler, si no queda cap barco en peu, ha guanyat.
	*
 	* @return       si ha guanyat
 	*/
	public boolean checkWinner(){
		for(int i=0;i<dimention;i++) {
			for(int j=0;j<dimention;j++) {
				if(board[i][j] == cell.boat) {
					return false;
				}
			}
		}
		return true;
	}	
	
	public int getDimention() {
		return dimention;
	}
	
	public void setDimention(int dimention) {
		this.dimention = dimention;
	}
	
	
	public void setBoats(Boat[] boats) {
		this.boats = boats;
	}
	
	public cell[][] getBoard() {
		return board;
	}
	
	/**
   	* Converteix una posició String ("A1") en un array de posicions int ("00") per a igualar les posicions del tauler.
	*
	* @param  casella	input que volem convertir
 	* @return       
 	*/
	public int[] convertStringToPosition(String casella) {
		int[] posicio = new int[2];
		
		posicio[0] = casella.charAt(0) - 65;
		posicio[1] = casella.charAt(1) - '1';
		return posicio;
	}
}
