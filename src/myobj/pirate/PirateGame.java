package myobj.pirate;

import java.util.Scanner;

public class PirateGame {
	
	Scanner sc;
	private Settings env;
	
	
	public PirateGame(Settings setting) {
		env = setting;
		sc = new Scanner(System.in);
	}
	
	public void start() {
		while (true) {
			sc.nextLine();
		}
	}
}
