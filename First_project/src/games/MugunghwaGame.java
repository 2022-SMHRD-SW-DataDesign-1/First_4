package games;

import java.util.Random;
import java.util.Scanner;

import asciiArtSet.asciiArtSet_mugung;
import asciiArtSet.asciiArtSet_public;
import javazoom.jl.player.MP3Player;
import model.MemberDTO;
import musicPlayer.musicCon;

public class MugunghwaGame
{
	Random r = new Random(); 
	Scanner sc = new Scanner(System.in);
	
	private boolean isRun;
	private int len;
	private int [] MugungStatus;
	
	asciiArtSet_mugung doll_image = new asciiArtSet_mugung();
	asciiArtSet_public ascpub = new asciiArtSet_public();
	
	musicCon mc = new musicCon();
	
	public MugunghwaGame()
	{
		isRun = true;
		len = 30;
		MugungStatus = new int[len];
	}
	
	public int run_MugunghwaGame(int score, MemberDTO dto, MP3Player mp3) 
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
				if(!mp3.isPlaying())
					mc.playMusic(mp3, 2);
				System.out.println(percent * (100/len) + "%에 도달했습니다.");
				System.out.println(doll_image.doll_back);
			}
			else if(MugungStatus[i] == 1) 
			{
				if(!mp3.isPlaying())
					mc.playMusic(mp3, 3);
				System.out.println(percent * (100/len) + "%에 도달했습니다.");
				System.out.println(doll_image.doll_side);
			}
			else 
			{
				if(!mp3.isPlaying())
					mc.playMusic(mp3, 4);
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
			if(mp3.isPlaying()) 
			{
				mp3.stop();
				mc.playMusic(mp3, 11);
			}
			System.out.println(ascpub.gunShot);
			ascpub.Sleep(1500);
			
			if(mp3.isPlaying()) 
			{
				mp3.stop();
				mc.playMusic(mp3, 12);
			}
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
		for (int i = 0; i < 4; i++) 
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
					MugungStatus[j] = 1;
				} 
				cnt = 0;
			}
		}
	}

}
