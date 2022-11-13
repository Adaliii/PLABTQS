
public class MockBoard extends Board {
	public String pos;
	@Override
	public int makeMoveHit(String position) {
		this.pos = position;
		if(position.equals("3A")) {
			return 0;
		}
		else {
			return 1;
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
