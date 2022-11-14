
public class MockViewPlayer extends ViewPlayer {
	int i=0;
	
	@Override
	public String askName() {
		switch(i) {
		case 0:
			i++;
			return "Juan";
		
		case 1:
			i++;
			return "Alfonso";
		case 2:
			i++;
			return "1234";
		default:
			return "Hola";
		}
	}
}
