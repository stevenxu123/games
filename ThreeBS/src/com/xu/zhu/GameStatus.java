package com.xu.zhu;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import cardgame.Card;

/**
 * GameStatus is an Object sent from the server (ThreeBS) to the clients
 * (ThreeBSPlayer) to notify players of the status of the game
 */
public class GameStatus implements Serializable {
	private static final long serialVersionUID = 3800688439723567333L;
	
	public final int activePlayerNum;
	public final String activePlayerName;
	
	public final int numCardsOnField;
	public final Collection<Card> cardsShowing;

	public GameStatus(int activePlayerNum, String activePlayerName, 
					  int numCardsOnField, Collection<Card> cardsShowing) {
		this.activePlayerNum = activePlayerNum;
		this.activePlayerName = activePlayerName;
		this.numCardsOnField = numCardsOnField;
		this.cardsShowing = Collections.unmodifiableCollection(cardsShowing);
	}
}
