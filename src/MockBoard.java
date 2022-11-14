/**
 * La classe MockBoard ajuda a altres classes a fer tests retornant les dades esperades.
 */
public class MockBoard extends Board {
	public String pos;
	int i = 0;
	@Override
	public void buildBoard() {
		//does nothing;
	}
	@Override
	public int makeMoveHit(String position) {
		this.pos = position;
		if(position.equals("A3")) {
			return 0;
		}
		else if(position.equals("B6")){
			switch (i) {
				case 0:
					i++;
					return 1;
				default:
					return 2;
			}
			
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
