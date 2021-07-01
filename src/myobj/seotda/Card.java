package myobj.seotda;

import java.util.ArrayList;

public class Card {
	public static ArrayList<String> card = new ArrayList<>();
	
	public Card() {
		for(int i = 1 ; i < 11; i++) {
			String number = Integer.toString(i);
			card.add("일반" + number);	
		}
		card.add("광1");
		card.add("특2");
		card.add("광3");
		card.add("특4");
		card.add("특5");
		card.add("특6");
		card.add("특7");
		card.add("광8");
		card.add("특9");
		card.add("특10");	

	}
	@Override
	public String toString() {
		return String.format("%s",card);
	}

}


