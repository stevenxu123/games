package com.xu.zhu;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cardgame.*;
import cardgame.Card.Rank;
import cardgame.Card.Suit;

public class ThreeBS {
	private static final int DEFAULT_PORT = 9001;
	
	private Deck deck;
	private ThreeBSPlayer self = new ThreeBSPlayer();
	private List<ThreeBSPlayer> players = new ArrayList<ThreeBSPlayer>();
	private List<Thread> playerThreads = new ArrayList<Thread>();
	private boolean isWaitingForPlayers;
	private boolean isRunning;
	
	private ThreeBS() {
		deck = new Deck();
		deck.shuffle();
		
		isWaitingForPlayers = true;
		isRunning = true;
	}

	public static void main(String[] args) {
		// Start a game of 3-card BS
		ThreeBS game = new ThreeBS();
		
//		// io stuff
//		try {
//			ServerSocket server = new ServerSocket(DEFAULT_PORT);
//			Socket channel = server.accept();
//			
//			PrintWriter out = new PrintWriter(channel.getOutputStream());
//			Reader reader = new InputStreamReader(channel.getInputStream());
//			BufferedReader in = new BufferedReader(reader);
//			
//			String data = in.readLine();
//			out.println("Hey! I heard you over this socket!");
//		} catch (IOException e) {
//			
//		}
//		game.startGame(2,3);
		List<Card> temp = new ArrayList<Card>();
		temp.add(new Card(Rank.ACE, Suit.SPADES));
		temp.add(new Card(Rank.THREE, Suit.HEARTS));
		
		Collection<Card> cards = Collections.unmodifiableCollection(temp);
		for (Card card : cards) {
			System.out.println(card);
		}
		System.out.println("██ ██ ██");
	}
	
	public void acceptClients(ServerSocket server, int maxClients) {
		Socket socket = null;
		for (int i = 0; i < maxClients; i++) {
			try {
				socket = server.accept();
				
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				Reader reader = new InputStreamReader(socket.getInputStream());
				BufferedReader in = new BufferedReader(reader);
				
				
			} catch (IOException e) {
				System.err.println("Error creating socket connection");
				System.exit(1);
			}
		}
	}
	
	public void startGame(int numPlayers, int numCards) {
		players.add(self);
		
		while (isWaitingForPlayers) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		// players have joined; start game
		deck.deal(players, numCards);
		
		while (isRunning) {
			
		}
	}
	
	public static void startServer(Console console) {
		System.out.println("ThreeBS Game v1.0");
		System.out.println("~~~~~~~~~~~~~~~~~\n");
		
	}
	public void addPlayer(ThreeBSPlayer player) {
		players.add(player);
	}
}
