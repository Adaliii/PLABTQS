import java.util.Scanner;

public class MockViewBoard extends ViewBoard {
	public int numTest = 0;
	public int i = 0;
	@Override
	public String askPositionBoat(int boatLength) {
		if(numTest==0) {
			switch(i) {
			   case 0:
				   return "A2";
			   case 1:
				   return "E3";
			   default:
				   return "H6";
			}
		}
		else if(numTest == 1) {
			switch(i) {
			   case 0:
				   i++;
				   return "a";
			   case 1:
				   i++;
				   return "X1";
			   case 2:
				   i++;
				   return "AX";
			   default:
				   return "A2";
			}
		}
		else if(numTest == 2){
			switch(i) {
			   default:
				   i++;
				   return "A2";
			}
		}
		else if(numTest==3){
			switch(i) {
			   case 0:
				   i++;
				   return "H8";
			   default:
				   return "H7";
			}
		}
		else {
			switch(i) {
			   case 0:
				   i++;
				   return "H8";
			   default:
				   return "G8";
			}
		}
			
	}
	@Override
	public String askOrientation() {
		if(numTest ==0) {
			switch(i) {
			case 0:
				i++;
			   return "H";
			case 1:
				i++;
				return "GG";
			case 2:
				i++;
				return "G";
		   default:
			   i++;
			   return "V";
		   }
		}
		else if(numTest == 1) {
			i++;
			return "H";
		}
		else if(numTest == 2){
			i++;
			return "V";
			
		}
		else if(numTest == 3){
					i++;
				   return "V";
			
		}
		else {
			i++;
			return "H";
		}
		
		   
	}
}
