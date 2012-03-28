package com.xu.zhu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import cardgame.*;

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
		
		// io stuff
		try {
			ServerSocket server = new ServerSocket(DEFAULT_PORT);
			Socket channel = server.accept();
			
			PrintWriter out = new PrintWriter(channel.getOutputStream());
			Reader reader = new InputStreamReader(channel.getInputStream());
			BufferedReader in = new BufferedReader(reader);
			
			String data = in.readLine();
			out.println("Hey! I heard you over this socket!");
		} catch (IOException e) {
			
		}
		game.startGame(2,3);
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
		for (int i = 0; i < numPlayers - 1; i++) {
			playerThreads.add(new Thread(new ThreeBSPlayer()));
		}
		
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
	
	public void addPlayer(ThreeBSPlayer player) {
		players.add(player);
	}
}
