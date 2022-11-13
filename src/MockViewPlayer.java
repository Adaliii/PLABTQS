
public class MockViewPlayer extends ViewPlayer {
	int i=0;
	
	@Override
	public String askName() {
		switch(i) {
		case 0:
			return "Juan";
		
		default:
			return "Alfonso";
		}
	}
}
