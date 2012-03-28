package com.xu.zhu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import cardgame.Player;

public class ThreeBSPlayer extends Player {
	
	public InetAddress ip;
	public static final int PORT = 9001;
	
	public ThreeBSPlayer() {
		super();
	}

	// connect to the server at the given IP
	public void connect() {
		
		try {
			Socket socket = new Socket(ip, PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		ThreeBSPlayer player = new ThreeBSPlayer();
		System.out.print("Enter IP Address: "); 
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    player.ip = InetAddress.getByName(br.readLine().trim());
		    System.out.println(player.ip.getHostAddress());
		} catch (UnknownHostException e) {
			System.err.println("Invalid IP");
			//e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
