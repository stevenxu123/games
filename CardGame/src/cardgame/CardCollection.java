package cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public abstract class CardCollection {
	private List<Card> cards;
	private Random rand = new Random();
	
	public CardCollection() {
		this(new ArrayList<Card>());
	}
	public CardCollection(List<Card> cards) {
		this.cards = cards;
	}
	
	public int size() {
		return cards.size();
	}
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	public void clear() {
		cards.clear();
	}
	public void add(Card card) {
		cards.add(card);
	}
	public void addAll(Collection<Card> cards) {
		cards.addAll(cards);
	}
	public boolean contains(Card card) {
		return cards.contains(card);
	}
	public boolean containsAll(Collection<Card> cards) {
		return cards.containsAll(cards);
	}
	public boolean remove(Card card) {
		return cards.remove(card);
	}
	public boolean removeAll(Collection<Card> cards) {
		return cards.removeAll(cards);
	}
	
	protected int randIndex() {
		return rand.nextInt(size());
	}
	public Card randCard() {
		return cards.get(randIndex());
	}
	
	public void shuffle() {
		for (int i = size()-1; i > 0; i--) {
			int rand = new Random().nextInt(i+1);
			
			// swap
			Card temp = cards.get(i);
			cards.set(i, cards.get(rand));
			cards.set(rand, temp);
		}
	}
	
	/** Removes and returns a card from the CardCollection */
	public abstract Card draw();
	
	public abstract Card peek();
	public abstract List<Card> peek(int n);

}
