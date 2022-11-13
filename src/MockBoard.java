
public class MockBoard extends Board {
	public String pos;
	@Override
	public int makeMoveHit(String position) {
		this.pos = position;
		if(position.equals("A3")) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public boolean checkWinner() {
		if(pos.equals("A3")) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
