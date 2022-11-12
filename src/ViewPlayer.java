import java.util.Scanner;

public class ViewPlayer {

	public String askName() {
		Scanner nameScanner = new Scanner(System.in);
		System.out.println("Introdueix el teu nom");
		String name = nameScanner.nextLine();
		return name;
	}
	
	public void showNameError() {
		System.out.println("Nom introduit incorrecte");
	}
	public String askAttack() {
		Scanner move = new Scanner(System.in);
		System.out.println("Introdueix on vols atacar \n");
		String atac = move.nextLine();
		return atac;
	}
	
	public void showResultAttack(int result) {
		switch (result) {
		case 0:
			System.out.println("Aigua");
			return;
		case 1:
			System.out.println("Coordenades mal introduides");
			return;
		case 2:
			System.out.println("Columna Incorrecte");
			return;
		case 3:
			System.out.println("Fila Incorrecte");
			return;
		case 4:
			System.out.println("Vaixell tocat!");
			return;	
		}
	}
	
	public void showWinner(Player p) {
		System.out.println(p.getName() + " ha guanyat la partida!");
		System.out.println("------------------------------");
	}
}
