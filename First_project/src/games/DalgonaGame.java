package games;

import java.util.Scanner;

import asciiArtSet.asciiArtSet_dalgo;
import asciiArtSet.asciiArtSet_public;
import javazoom.jl.player.MP3Player;
import model.MemberDTO;
import musicPlayer.musicCon;

public class DalgonaGame {
	
	private int dalgo[][];
	private int user_x;
	private int user_y;
	private int time;
	private int life;
	private boolean dalgoSuccess;
	private boolean isRunning;
	
	asciiArtSet_dalgo frame = new asciiArtSet_dalgo();
	asciiArtSet_public ascpub = new asciiArtSet_public();
	
	musicCon mc = new musicCon();
	
	public DalgonaGame() 
	{
		dalgo = new int[10][10];
		user_x = 0;
		user_y = 0;
		time = 0;
		life = 2;
		dalgoSuccess = true;
		isRunning = true;
	}

	public int run_DalgonaGame(int score, MemberDTO dto, MP3Player mp3) {
		// 달고나 전체의 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두번째 게임을 시작합니다.");
		System.out.println("○△□○△□ 달고나 ○△□○△□");
		System.out.println("달고나 게임은 제한시간내에 원하시는 모양을 w, a, s, d를 입력 후 지정된루트로 이동을 하여야 성공하는 게임입니다.\n"
						 + "제한시간 내에 달고나를 완성하지 못하면 탈락하니 신중히 게임을 즐겨주시기 바랍니다.");

		System.out.println("달고나뽑기 원하시는 모양을 선택하세요");
		System.out.print("[1] ㅁ (난이도 : 하)  [2] ♡ (난이도 : 중)  [3] ◇ (난이도 : 상) >>");
		System.out.println(frame.dalgo_select);
		int shapes = sc.nextInt();
		
		setUserPoint(shapes);

		// user가 움직이는 좌표

		long before = System.currentTimeMillis();
		
		if(mp3.isPlaying()) 
			mp3.stop();
		mc.playMusic(mp3, 5);
		
		while (isRunning) {
			
			dalgoSuccess = true;
			
			for (int i = 0; i < dalgo.length; i++) {
				for (int j = 0; j < dalgo[i].length; j++) {
					if (dalgo[i][j] == 0)
						System.out.print(frame.shape[0] + " ");
					else if (dalgo[i][j] == 1)
						System.out.print(frame.shape[1] + " ");
					else if (dalgo[i][j] == 2)
						System.out.print(frame.shape[2] + " ");
				}
				System.out.println();
			}
			
			System.out.println("■모양을 따라가세요.(경로이탈 2회시 자동으로 탈락됩니다)");
			System.out.println("[a : 왼쪽] [w : 위] [d : 오른쪽] [s : 아래]");
			System.out.print("좌표를 움직이시요>>");
			String move = sc.next();
			
			switch (move) {
			case "a": // left
				user_x--;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				break;
			case "d": // right
				user_x++;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				if (user_x >= 10)
					user_x = 10 - 1;
				break;
			case "w": // up
				user_y--;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				if (user_y < 0)
					user_y = 0;
				break;
			case "s": // down
				user_y++;
				if (dalgo[user_y][user_x] == 0) {
					life--;}
				dalgo[user_y][user_x] = 2;
				if (user_y >= 10) {
					user_y = 10 - 1;}
				
				break;
			}
			
			long now = System.currentTimeMillis();
			if (now - before > time)
				break;
			
			if(life == 0) {
				System.out.println("달고나가 깨졌습니다.");
				dalgoSuccess = false;
				break;
			}
			
			for (int i = 0; i < dalgo.length; i++) {
				for (int j = 0; j < dalgo[i].length; j++) {
					if (dalgo[i][j] == 1) {
						dalgoSuccess = false;
						break;
					}
				}
			}
			
			if(dalgoSuccess)
				break;
		}
		long gameEnd = System.currentTimeMillis();
		
		if (dalgoSuccess) {
			System.out.println("달고나성공!");
			
			System.out.println(frame.dalgo_success);
			ascpub.Sleep(2000);
			
			System.out.println(ascpub.gameWin);
			ascpub.Sleep(3000);
			
			if(shapes == 1) 
			{
				score += 100;
				if(time - (gameEnd - before) > 0)
					score += time - (gameEnd - before);
			}
			else if(shapes == 2) 
			{
				score += 300;
				if(time - (gameEnd - before) > 0)
					score += time - (gameEnd - before);
			}
			else if(shapes == 3) 
			{
				score += 500;
				if(time - (gameEnd - before) > 0)
					score += time - (gameEnd - before);
			}
			
			System.out.println("성공하셨습니다 다음 게임으로 넘어가겠습니다");
		} else {
			System.out.println("[탈락]");
			
			if(mp3.isPlaying()) 
				mp3.stop();
			mc.playMusic(mp3, 11);
			
			System.out.println(ascpub.gunShot);
			ascpub.Sleep(1500);
			
			if(mp3.isPlaying()) 
				mp3.stop();
			mc.playMusic(mp3, 12);
			
			System.out.println(ascpub.gameover);
			ascpub.Sleep(3000);
			
			dto.setLife(0);
		}
		
		return score;
		
	}
	
	public void setUserPoint(int shapes)
	{
		if(shapes == 1) 
		{
			dalgo = frame.dalgo1;
			user_x = 1;
			user_y = 1;
			time = 15000;
		}
		else if(shapes == 2) 
		{
			dalgo = frame.dalgo2;
			user_x = 1;
			user_y = 2;
			time = 20000;
		}
		else if(shapes == 3) 
		{
			dalgo = frame.dalgo3;
			user_x = 4;
			user_y = 0;
			time = 25000;
		}
		
		dalgo[user_y][user_x] = 2;
	}

}

