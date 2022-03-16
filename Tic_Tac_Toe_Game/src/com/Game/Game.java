package com.Game;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	
	
private static char[][] gameBoard =  new char[3][3];
	
private static boolean playing1 = false;
private static boolean playing2 = false;
	
	
	
	public static void resetGameBorad() {
		char value = 49;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = value;
				value++;
			}
		}
		playing1 = false;
		playing2 = false;
		
		
	}
		
	public static void printGameBoard() {
		System.out.println("\n");
		System.out.println("----------");
		for (int i = 0; i < 3; i++) {
			
				System.out.println( "| "+gameBoard[i][0] + " | "+ gameBoard[i][1] + " | "+gameBoard[i][2]+" | ");
				System.out.println("----------");
		}
	}
	public static boolean isGameEnd() {
		 if((gameBoard[0][0] == 'X' && gameBoard[0][1] == 'X' && gameBoard[0][2] == 'X') ||
			(gameBoard[1][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[1][2] == 'X') ||
			(gameBoard[2][0] == 'X' && gameBoard[2][1] == 'X' && gameBoard[2][2] == 'X') ||
			
			(gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') ||
			(gameBoard[0][1] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][1] == 'X') ||
			(gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') ||
			
			(gameBoard[0][0] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][2] == 'X') ||
			(gameBoard[0][2] == 'X' && gameBoard[1][1] == 'X' && gameBoard[2][0] == 'X') ) {
			 playing1 = true;
			 return true;
			 
		 }
		 if((gameBoard[0][0] == 'O' && gameBoard[0][1] == 'O' && gameBoard[0][2] == 'O') ||
			(gameBoard[1][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[1][2] == 'O') ||
			(gameBoard[2][0] == 'O' && gameBoard[2][1] == 'O' && gameBoard[2][2] == 'O') ||
					
			(gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') ||
			(gameBoard[0][1] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][1] == 'O') ||
			(gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') ||
					
			(gameBoard[0][0] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][2] == 'O') ||
			(gameBoard[0][2] == 'O' && gameBoard[1][1] == 'O' && gameBoard[2][0] == 'O') ) {
					playing2 = true;
					 return true;
					 
			}
		 
		 int count=0;
		 
			 for (int i = 0; i < gameBoard.length; i++) {
				 for (int j = 0; j < gameBoard[i].length; j++) {
					if(gameBoard[i][j]=='X' || gameBoard[i][j]=='O') {
						count++;
					}
					else {
						count=0;
						break;
					}
						
				}
			}
		 if(count==9) {
			
			 return true;
		 }
			 return false;
	}
	public static boolean checkSpace(int index,char[] mark) {
		switch(index) {
		case 1: if( gameBoard[0][0] != mark[0] &&gameBoard[0][0] != mark[1] ) return true;
				else return false;
		
		case 2: if( gameBoard[0][1] != mark[0] &&gameBoard[0][1] != mark[1] ) return true;
				else return false;
		
		case 3:  if( gameBoard[0][2] != mark[0] &&gameBoard[0][2] != mark[1] ) return true;
		else return false;
		
		case 4:  if( gameBoard[1][0] != mark[0] &&gameBoard[1][0] != mark[1] ) return true;
		else return false;
		
		case 5:  if( gameBoard[1][1] != mark[0] &&gameBoard[1][1] != mark[1] ) return true;
		else return false;
		
		case 6: if( gameBoard[1][2] != mark[0] &&gameBoard[1][2] != mark[1] ) return true;
		else return false;
		
		case 7:  if( gameBoard[2][0] != mark[0] &&gameBoard[2][0] != mark[1] ) return true;
		else return false;

		case 8:  if( gameBoard[2][1] != mark[0] &&gameBoard[2][1] != mark[1] ) return true;
		else return false;
		case 9:  if( gameBoard[2][2] != mark[0] &&gameBoard[2][2] != mark[1] ) return true;
		else return false;
		default: return false;
		}
	}
	
	public static void insertMarkAt(int index,char mark) {
		switch(index) {
		case 1: gameBoard[0][0] = mark;
		break;
		case 2: gameBoard[0][1] = mark;
		break;
		case 3: gameBoard[0][2] = mark;
		break;
		case 4: gameBoard[1][0] = mark;
		break;
		case 5: gameBoard[1][1] = mark;
		break;
		case 6: gameBoard[1][2] = mark;
		break;
		case 7: gameBoard[2][0] = mark;
		break;
		case 8: gameBoard[2][1] = mark;
		break;
		case 9: gameBoard[2][2] = mark;
		break;
		}
	}
	public static void playerVsComputer(Player play1) {
		
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);		
		int posi;
		int checkStrak =0;
		char[] sign = {'X','O'};
		resetGameBorad();
		Start:
		while(true) {
			
			if(play1.isPlayerTurn()) {
			 again:
				while(true) {
					printGameBoard();
					System.out.print("\nEnter Box no(1-9) :  ");
					 posi =  scan.nextInt();
					 if(!(posi >= 1 && posi <= 9 )) {
						 System.out.println("Again Enter Number between(1-9) :");
						 continue again;
					}
					if(checkSpace(posi, sign)) {
						insertMarkAt(posi, sign[0]);
						play1.setPlayerTurn(false);
						break;
					}
					else {
						System.out.println("\n Envalide box no Enter again::");
						
					}
				}
				
			}
			else {
				while(true) {
					
					posi = rand.nextInt(9)+1;
				
					
					if(checkSpace(posi, sign)) {
						printGameBoard();
						System.out.println("Computer Trun :: " + posi);
						insertMarkAt(posi, sign[1]);
						play1.setPlayerTurn(true);
						
						break;
					}
				}
			}
			
			
			if(isGameEnd()) {
				printGameBoard();
				if(!playing1&&!playing2) {
					System.out.println("\n\n\t\tThe game is draw ::");
					checkStrak=0;
				}
				else if(playing1) {
					System.out.println(play1.getPlayerName()+" Won the game ");
					play1.WinningMatch();
					checkStrak++;
					if(play1.getLongStreak()<checkStrak) {
						play1.setLongStreak(checkStrak);
					}
				}
				else if(playing2) {
					System.out.println("Computer won the game");
					play1.LossingMatch();
					checkStrak =0;
				}
				
				System.out.println("Enter 1 to play again or 0 for quit ");
				int ch = scan.nextInt();
				if(ch==1) {
					
					resetGameBorad();
					continue Start;
				}
				else
				  break Start;
			}
			
		}
	
		
	}
	
	
	public static void PlayerStatistcs(Player player1, Player player2) {
	
		if(player1.getPlayerName() != null) {
			System.out.println("\n\n\t\t\tPlayer Statics -"+player1.getPlayerName());
			System.out.println("\t\t No. of Wins = "+ player1.getPlayerTotalWin());
			System.out.println("\t\t No. of Loss = "+ player1.getPlayerTotalLoss());
			System.out.println("\t\t No. of Longest Streak = "+player1.getLongStreak());
		}
		if(player2.getPlayerName() != null) {
			System.out.println("\n\n\t\t\tPlayer Statics -"+player2.getPlayerName());
			System.out.println("\t\t No. of Wins = "+ player2.getPlayerTotalWin());
			System.out.println("\t\t No. of Loss = "+ player2.getPlayerTotalLoss());
			System.out.println("\t\t No. of Longest Streak = "+player2.getLongStreak());

		}
		
		
		
	}

	public static void PlayerVsPlayer(Player player1, Player player2) {
		Scanner scan = new Scanner(System.in);		
		int posi;
		int checkStreak_1=0;
		int checkStreak_2=0;
		char[] sign = {'X','O'};
		resetGameBorad();
		Start:
		while(true) {
			
			if(player1.isPlayerTurn()) {
			 again:
				while(true) {
					printGameBoard();
					System.out.println("\nPlayer 1 turn ::\nEnter Box no(1-9) :  ");
					 posi =  scan.nextInt();
					 if(!(posi >= 1 && posi <= 9 )) {
						 System.out.println("Again Enter Number between(1-9) :");
						 continue again;
					}
					if(checkSpace(posi, sign)) {
						insertMarkAt(posi, sign[0]);
						player1.setPlayerTurn(false);
						break;
					}
					else {
						System.out.println("\n Envalide box no Enter again::");
						printGameBoard();
					}
				}
				
			}
			else {
			again1:
				while(true) {
					printGameBoard();
					System.out.println("\nPlayer 2 turn ::\n Enter box no (1-9): ");
					posi = scan.nextInt();
					if(!(posi >= 1 && posi <= 9 )) {
						
						 System.out.println("Again Enter Number between(1-9) :");
						 continue again1;
					}
					if(checkSpace(posi, sign)) {
						insertMarkAt(posi, sign[1]);
						player1.setPlayerTurn(true);
						break;
					}
					else {
						System.out.println("\n Envalide box no Enter again::");
						printGameBoard();
					}
				}
			}
			if(isGameEnd()) {
				printGameBoard();
				if(!playing1&&!playing2) {
					System.out.println("\n\n\t\tThe game is draw ::");
					checkStreak_1=0;
					checkStreak_2 =0;
				}
				
				else if(playing1) {
					System.out.println(player1.getPlayerName()+" Won the game ");
					player1.WinningMatch();
					player2.LossingMatch();
					checkStreak_1++;
					if(player1.getLongStreak()<checkStreak_1) {
						player1.setLongStreak(checkStreak_1);
					}
					checkStreak_2=0;
				}
				else if(playing2){
					System.out.println(player2.getPlayerName()+ " won the game");
					player2.WinningMatch();
					player1.LossingMatch();
					checkStreak_2++;
					if(player2.getLongStreak()<checkStreak_2) {
						player2.setLongStreak(checkStreak_2);
					}
					checkStreak_1=0;
				}
				System.out.println("Enter 1 to play again or 0 for quit ");
				int choise = scan.nextInt();
				if(choise==1) {
					resetGameBorad();
					continue Start;
				}
				else
				  break Start;
			}
			
		}
		
		
		
	}

	
}
