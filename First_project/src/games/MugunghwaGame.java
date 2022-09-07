package games;

import java.util.Random;
import java.util.Scanner;

import asciiArtSet.asciiArtSet_mugung;
import asciiArtSet.asciiArtSet_public;
import model.MemberDTO;

public class MugunghwaGame
{
	Random r = new Random(); 
	Scanner sc = new Scanner(System.in);
	
	private boolean isRun;
	private int len;
	private int [] MugungStatus;
	
	asciiArtSet_mugung doll_image = new asciiArtSet_mugung();
	asciiArtSet_public ascpub = new asciiArtSet_public();
	
	public MugunghwaGame()
	{
		isRun = true;
		len = 50;
		MugungStatus = new int[len];
	}
	
	public int run_MugunghwaGame(int score, MemberDTO dto) 
	{
		setMugungStat();
		
		int percent = 0;
		String run = "";
		String stop = " ";
		
		long gameStart = System.currentTimeMillis();
		for(int i = 0; i < MugungStatus.length; i++, percent++)
		{
			if(MugungStatus[i] == 0) 
			{
				System.out.println(percent * (100/len) + "%에 도달했습니다.");
				System.out.println(doll_image.doll_back);
			}
			else if(MugungStatus[i] == 1) 
			{
				System.out.println(percent * (100/len) + "%에 도달했습니다.");
				System.out.println(doll_image.doll_side);
			}
			else 
			{
				System.out.println(doll_image.doll_front);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(isRun)
					break;
				else
					isRun = true;
				score += 100;
			}
			
			String input = sc.nextLine();
			
			if(stop.equals(input) && isRun)
				isRun = false;
			if(run.equals(input) && !isRun)
				isRun = true;
			
		}

		if(percent == MugungStatus.length) 
		{
			System.out.println("게임에서 승리하셨습니다.");
			System.out.println(ascpub.gameWin);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else 
		{
			System.out.println(ascpub.gunShot);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(ascpub.gameover);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dto.setLife(0);
		}
		long gameEnd = System.currentTimeMillis();
		
		if(gameEnd - gameStart > 0)
			score += (30000 - (gameEnd - gameStart))/10;
		
		return score;
	}
	
	public void setMugungStat() 
	{
		for (int i = 0; i < 5; i++) 
		{
			int ranIndex = r.nextInt(len/3)*3;
			if(MugungStatus[ranIndex] == 0)
				MugungStatus[ranIndex] = 1;
			else
				i--;
		}
		
		int cnt = 0;
		
		for (int i = 0; i < MugungStatus.length; i++) 
		{
			if(MugungStatus[i] == 0)
				cnt++;
			else if(MugungStatus[i] == 1) 
			{
				MugungStatus[i]++;
				for (int j = i - cnt + r.nextInt(cnt)/2+1; j < i; j++) 
					MugungStatus[j] = 1;
				cnt = 0;
			}
		}
	}

}
