import java.util.Arrays;

public class Boat {
	private int length;
	private boolean[] state;
	private String positions[];
	private boolean orientation;
	
	public Boat(int length) {
		this.length = length;
		this.state = new boolean[length];
		Arrays.fill(state, false);
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
	
}
