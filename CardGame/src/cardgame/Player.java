package cardgame;

public class Player {
	private Hand hand;

	public Player() {
		this(new Hand());
	}
	public Player(Hand hand) {
		this.hand = hand;
	}
	
	public Card drawFromDeck(Deck deck) {
		Card card = deck.draw();
		hand.add(card);
		return card;
	}
	
	public Hand getHand() {
		return hand;
	}
}
