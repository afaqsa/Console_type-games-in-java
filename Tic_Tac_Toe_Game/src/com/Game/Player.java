package com.Game;

public class Player {

	private boolean playerTurn = true;
	private int playerTotalWin = 0;
	private int playerTotalLoss = 0;
	private String playerName;
	private int longStreak=0;
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getLongStreak() {
		return longStreak;
	}

	public void setLongStreak(int longStreak) {
		this.longStreak = longStreak;
	}

	public boolean isPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	public int getPlayerTotalWin() {
		return playerTotalWin;
	}

	public void setPlayerTotalWin(int playerTotalWin) {
		this.playerTotalWin = playerTotalWin;
	}

	public int getPlayerTotalLoss() {
		return playerTotalLoss;
	}

	public void setPlayerTotalLoss(int playerTotalLoss) {
		this.playerTotalLoss = playerTotalLoss;
	}
	
	public void WinningMatch() {
		playerTotalWin += 1;
	}
	public void LossingMatch() {
		playerTotalLoss += 1;
	}
}
