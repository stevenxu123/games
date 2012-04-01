package com.xu.zhu;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import cardgame.Card;

/**
 * Move is an Object sent from a client (ThreeBSPlayer) to the server
 * (ThreeBS) indicating what move the player has made
 */
public class Move implements Serializable {
	private static final long serialVersionUID = 236925954124358597L;
	
	public final boolean isCallBs;
	public final Collection<Card> cardsPlayed;
	
	public Move(boolean isCallBs, Collection<Card> cardsPlayed) {
		this.isCallBs = isCallBs;
		this.cardsPlayed = Collections.unmodifiableCollection(cardsPlayed);
	}
}
