package cardgame;

public class Card {
	public enum Rank {
		TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
		EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

		private String name;
		private Rank(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
	}
	public enum Suit {
		CLUBS("\u2663"), DIAMONDS("\u2666"), HEARTS("\u2665"), SPADES("\u2660");
		
		private String name;
		private Suit(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}
	}
	
	private final Rank rank;
	private final Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return rank.toString() + suit.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Card) {
			Card temp = (Card) o;
			return this.rank == temp.rank && this.suit == temp.suit;
		}
		return false;
	}
}
