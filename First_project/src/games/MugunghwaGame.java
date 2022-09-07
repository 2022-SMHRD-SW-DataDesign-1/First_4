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
		len = 30;
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
				ascpub.Sleep(2000);
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
			ascpub.Sleep(2000);
		}
		else 
		{
			System.out.println(ascpub.gunShot);
			ascpub.Sleep(1500);
			
			System.out.println(ascpub.gameover);
			ascpub.Sleep(3000);
			
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
			if (ranIndex != 0)
				if(MugungStatus[ranIndex] == 0)
					MugungStatus[ranIndex] = 1;
				else
					i--;
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
				{
					System.out.println(i + " " + j + " " + cnt);
					MugungStatus[j] = 1;
				} 
				cnt = 0;
			}
		}
	}

}
