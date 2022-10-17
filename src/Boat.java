import java.util.Arrays;

public class Boat {
	private int length;
	private boolean[] state;
	private String position[];
	private String orientation;
	
	public Boat(int length) {
		this.setLength(length);
		this.state = new boolean[length];
		Arrays.fill(state, false);
	}
	
	public boolean[] getState() {
		return state;
	}
	
	public String[] getPosition() {
		return position;
	}

	public void setPosition(String[] position) {
		this.position = position;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	public void getHit(int position) {
		state[position] = true;
	}
	
}
