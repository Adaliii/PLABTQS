import java.util.Scanner;

public class MockViewBoard extends ViewBoard {
	
	public int i = 0;
	@Override
	public String askPositionBoat(int boatLength) {
		switch(i) {
		   case 0:
			   return "A2";
		   case 1:
			   return "E3";
		   default:
			   return "H6";
		}	
	}
	@Override
	public String askOrientation() {
		
		switch(i) {
			case 0:
				i++;
			   return "H";
		   default:
			   i++;
			   return "V";
		}
		   
	}
}
