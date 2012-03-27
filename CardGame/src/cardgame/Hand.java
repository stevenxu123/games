package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand extends CardCollection {
	private ArrayList<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
	}
	public Hand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	@Override
	public Card peek() {
		if (isEmpty()) {
			return null;
		}
		return hand.get(new Random().nextInt(size()));
	}
	
	@Override
	public List<Card> peek(int n) {
		int size = size();
		if (size < n) {
			return hand;
		}
		shuffle();
		return hand.subList(size-n, size);
	}
	
	@Override
	public Card draw() {
		if (isEmpty()) {
			return null;
		}
		return hand.remove(randIndex());
	}
}
