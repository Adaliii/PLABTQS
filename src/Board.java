

public class Board {
	public ViewBoard viewBoard = new ViewBoard();
	private int dimention;
	private Boat[] boats;
	private cell board[][]; // [row][column] == [number][letter] == position "3A"
	public enum cell{
		water,boat,hit,miss;		
	}
	
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
	
	// buildBoat and insertBoat methods are separated for easier testing
	// Gets input from the player 
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
			/*
			String[] str = new String [2];
			System.out.println("For size " + boats[i].getLength() + " boat: ");
			System.out.println("In what position do you want to put it? (A-H)+(1-8)");
			str[0] = scan.nextLine();
			System.out.println("In horitzontal or vertical orientation? (H/V)");
			str[1] = scan.nextLine();  
			if(str[1].equals("H")) {
				this.insertBoat(str[0], true, boats[i].getLength());
			}
			else {
				this.insertBoat(str[0], false, boats[i].getLength());
			}
			*/
		}
	}
	
	// Position a boat in board and returns false if position invalid (out of range) 
	public boolean insertBoat(String pos, boolean horizontal, int length ) {
		int[] intPos = this.convertStringToPosition(pos);
		if(horizontal) {
			if((intPos[0] + length) <= dimention) { // if not out of range letter
				for(int i =0; i < length; i++) {
					if(board[intPos[1]][intPos[0]+i] == cell.boat) {
						return false;
					}
					else {
						board[intPos[1]][intPos[0]+i]= cell.boat; // advance letter
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		else { // vertical
			if((intPos[1] + length) <= dimention) { // if not out of range num
				for(int i =0; i < length; i++) {
					if(board[intPos[1]+i][intPos[0]].equals(cell.boat)) {
						return false;
					}
					else {
						board[intPos[1]+i][intPos[0]]= cell.boat; // advance numA
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
	}
	
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
	
	
	public int[] convertStringToPosition(String casella) {
		int[] posicio = new int[2];
		
		posicio[0] = casella.charAt(0) - 65;
		posicio[1] = casella.charAt(1) - '1';
		return posicio;
	}
}
