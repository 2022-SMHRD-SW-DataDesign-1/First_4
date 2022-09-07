package games;

import java.util.Scanner;

import asciiArtSet.asciiArtSet_dalgo;

public class DalgonaGame {
	
	private int dalgo[][];
	private int user_x;
	private int user_y;
	private int time;
	private int life;
	private boolean dalgoSuccess;
	private boolean isRunning;
	
	asciiArtSet_dalgo frame = new asciiArtSet_dalgo();
	
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

	public void run_DalgonaGame() {
		// 달고나 전체의 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("○△□○△□ 달고나 ○△□○△□ ");
		System.out.println("달고나게임을 시작하겟습니다 \r\n" + "달고나 게임은 제한시간내에 원하시는 모양을 방향키입력후 지정된루트로 이동을 하여야 성공하는 게임입니다\r\n"
				+ "방향키 입력중 지정된루트에 도달하지 못하면 실패를 하니 게임을 즐겨주시기 바랍니다 ");

		System.out.println("달고나뽑기 원하시는 모양을 선택하세요");
		System.out.print("[1] ㅁ (난이도 : 하)  [2] ◇ (난이도 : 중)  [3] ♡ (난이도 : 상) >>");
		int shapes = sc.nextInt();
		
		setUserPoint(shapes);

		// user가 움직이는 좌표

		long before = System.currentTimeMillis();
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
				System.out.println("life가 모두 소비되어 실패히셨습니다!");
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
		
		if (dalgoSuccess) {
			System.out.println("달고나성공!");
			System.out.println("성공하셨습니다 다음 게임으로 넘어가겠습니다");
		} else {
			System.out.println("게임 오버");
		}
		
		sc.close();

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

