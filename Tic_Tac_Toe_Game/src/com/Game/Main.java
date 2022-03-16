package com.Game;

import java.util.Scanner;

public class Main extends Game{
public static void main(String[] args) {
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		int choise=0;
		int gamecount=0;
		Scanner scan = new Scanner(System.in);		
			
		System.out.println("\n\n\n\t\t\t Welcome to tic tac toe.\n\n\n");
		System.out.print("\t\t\t Enter Player Name :  ");
		String name = scan.nextLine();
		player1.setPlayerName(name);
			
		Start:
		 while(true) {
			  choise=0;
			System.out.println("\n\n\n\t\t\t Welcome to tic tac toe.\n\n\n");
			System.out.println("\t\t\t\t 1. New Game");
			System.out.println("\t\t\t\t 2. Player Statistcs");
			System.out.println("\t\t\t\t 3. Exit Game");
			
			choise = scan.nextInt();
			
			switch(choise) {
				case 1: 
					System.out.println("\n\n\n\t\t\t Welcome to tic tac toe - New Game\n\n\n");
					System.out.println("\t\t\t\t 1. Vs computer");
					System.out.println("\t\t\t\t 2. Vs Another Player");
					System.out.println("\t\t\t\t 3.Back to main manu");
					int ch = scan.nextInt();
					if(ch==1) {
						playerVsComputer(player1);
					}
					else if(ch == 2) {
						scan.nextLine();
						System.out.print("Enter player 2 name:   ");
						String name2 = scan.nextLine();
						gamecount++;
						 if(!(name2.equals(player2.getPlayerName())) && gamecount > 1) {
							 player2.setPlayerName(name2);
							 player2.setLongStreak(0);
							 player2.setPlayerTotalLoss(0);
							 player2.setPlayerTotalWin(0);
							 
						 }
						
						PlayerVsPlayer(player1,player2);
					}
					else if(ch == 3) {
						continue Start;
					}
					break;
				case 2:
					PlayerStatistcs(player1, player2);
					System.out.println("\n\n\t\t\t\t Press anykey for goto main manu");
					if(scan.next().charAt(0)>=0) {
						continue Start;
					}
					break;
				case 3:
					break Start;
			}
			
			
		}
		
	scan.close();
	
}

}
