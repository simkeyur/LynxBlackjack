package edu.uta.teamargus.lynxblackjack;

public class CardSet {

	public String[] highcards =new String[]{"J","Q","K","A"};
	public String[] hearts = new String[12];
	public String[] spades = new String[12];
	public String[] clubs = new String[12];
	public String[] diamonds = new String[12];
	public CardSet(){
		for(int i=2;i<10;i++){
			hearts[i-2]=Integer.toString(i);
			spades[i-2]=Integer.toString(i);
			clubs[i-2]=Integer.toString(i);
			diamonds[i-2]=Integer.toString(i);
		}
		for(int q=0;q<highcards.length;q++){
			hearts[q+9]=highcards[q];
			spades[q+9]=highcards[q];
			clubs[q+9]=highcards[q];
			diamonds[q+9]=highcards[q];
		}
	}
}
