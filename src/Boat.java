import java.util.Arrays;

public class Boat {
	private int length;
	private boolean[] state;
	private String position[];
	private boolean orientation;
	
	public Boat(int length, boolean orientation) {
		this.setLength(length);
		this.state = new boolean[length];
		Arrays.fill(state, false);
		this.orientation = orientation;
	}
	
	public boolean[] getState() {
		return state;
	}
	
	public String[] getPosition() {
		return position;
	}

	public void setPosition(String[] position) {
		for(int i = 0; i < position.length; i++) {
			this.positions[i] = position[i];
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean getOrientation() {
		return orientation;
	}

	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}
	
	public void getHit(int position) {
		state[position] = true;
	}
	
}
