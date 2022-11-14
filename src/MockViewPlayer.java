
public class MockViewPlayer extends ViewPlayer {
	int i = 0;
	int j = 0;
	public int testCase = 0;
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
	
	@Override
	public String askAttack() {
		switch(j) {
		case 0:
			j++;
			return "a";
		case 1:
			j++;
			return "aaa";
		case 2:
			j++;
			return "A9";
		case 3:
			j++;
			return "M3";
		case 4:
			j++;
			return "C3";
		case 5:
			j++;
			return "B6";
		case 6:
			j++;
			return "A3";
		case 7:
			j++;
			return "B7";
		default:
			return "A3";
		}
	}
}

