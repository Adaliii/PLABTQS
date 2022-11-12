
public class MockBoard extends Board {
	public String pos;
	@Override
	public boolean makeMoveHit(String position) {
		this.pos = position;
		if(position.equals("3A")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean checkWinner() {
		if(pos.equals("3A")) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
