package cardgame;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import cardgame.Card.Rank;
import cardgame.Card.Suit;

public class Deck extends CardCollection {
	public static final int SIZE = 52;
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>(SIZE);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
	}
	
	public Card draw() {
		if (deck.isEmpty()) {
			return null;
		}
		// bottom of the deck = 0 index
		return deck.remove(deck.size() - 1);
	}
	
	/** Returns the top card */
	@Override
	public Card peek() {
		if (deck.isEmpty()) {
			return null;
		}
		return deck.get(deck.size() - 1);
	}

	/** Returns the top n cards */
	@Override
	public List<Card> peek(int n) {
		int size = deck.size();
		return deck.subList(size-n, size);
	}
	
	/** Puts a card on top of the deck if it is not already in the deck */
	public boolean push(Card card) {
		if (deck.contains(card)) {
			return false;
		}
		deck.add(card);
		return true;
	}

	public void deal(Collection<? extends Player> players) {
		int handSize = size() / players.size();
		int cardsLeft = size() % players.size();
		deal(players, handSize);
		
		for (Player player : players) {
			if (cardsLeft > 0) {
				player.drawFromDeck(this);
				cardsLeft--;
			}
		}
		
	}
	public void deal(Collection<? extends Player> players, int numCards) {
		for (int i = 0; i < numCards; i++) {
			for (Player player : players) {
				player.drawFromDeck(this);
			}
		}
	}
}
