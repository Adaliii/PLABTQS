/**
 * La classe Boat emmagatzema el sbarcos utilitzats per el joc.
 */
public class Boat {
	private int length;
	private boolean[] state; // estat en que es troben les diferents posicions del barco 
	private String positions[]; // posicions en la que es troba el barco en el tauler
	
	public Boat(int length) {
		this.length = length;
		this.state = new boolean[length];
		for(int i =0; i < length; i++) {
			state[i] = false;
		}
		positions = new String [length];
	}
	
	public boolean[] getState() {
		return state;
	}
	
	public String[] getPosition() {
		return positions;
	}

	public void setPosition(String[] position) {
		this.positions = position;
	}

	public int getLength() {
		return length;
	}
	
	public void updateHit(String position) {
		for(int i = 0; i < this.length; i++) {
			if(position == this.positions[i]) {
				state[i] = true;
			}
		}
	}
	
	public boolean checkEnfonsat() {
		for(int i =0; i < this.length; i++) {
			if(state[i] == false) {
				return false;
			}
		}
		return true;
	}
	
}
