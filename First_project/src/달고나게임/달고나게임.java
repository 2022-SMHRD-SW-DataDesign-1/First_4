package 달고나게임;

import java.util.Scanner;

public class 달고나게임 {

	public static void main(String[] args) {
		// 달고나 전체의 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("○△□○△□ 달고나 ○△□○△□ ");
		System.out.println("달고나게임을 시작하겟습니다 \r\n" + "달고나 게임은 제한시간내에 원하시는 모양을 방향키입력후 지정된루트로 이동을 하여야 성공하는 게임입니다\r\n"
				+ "방향키 입력중 지정된루트에 도달하지 못하면 실패를 하니 게임을 즐겨주시기 바랍니다 ");

		int dalgo[][] = new int[10][10];
		int dalgo1[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						  { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
						  { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
						  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int dalgo2[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				           { 0, 1, 1, 1, 0, 0, 1, 1, 1, 0 },
				           { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
				           { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
				           { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
				           { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
				           { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
				           { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
				           { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		int dalgo3[][] = { { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
						   { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
						   { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
						   { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
						   { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
						   { 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
						   { 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
						   { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
						   { 0, 0, 0, 1, 1, 1, 1, 0, 0, 0 },
						   { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };


		String[] shape = { "□", "■", "○" };
		
		int user_x = 1;
		int user_y = 1;
		int time = 0;
		int life = 2;


		System.out.println("달고나뽑기 원하시는 모양을 선택하세요");
		System.out.print("[1] ㅁ (난이도 : 하)  [2] ◇ (난이도 : 중)  [3] ♡ (난이도 : 상) >>");
		int shapes = sc.nextInt();
		for (int i = 0; i < dalgo.length; i++) {
			for (int j = 0; j < dalgo[i].length; j++) {
				if (shapes == 1) {
					dalgo[i][j] = dalgo1[i][j];
					time = 15000;

				} else if (shapes == 2) {
					dalgo[i][j] = dalgo2[i][j];
					user_x = 1;
					user_y = 2;
					time = 20000;

				} else if (shapes == 3) {
					dalgo[i][j] = dalgo3[i][j];
					user_x = 4;
					user_y = 0;
					time = 25000;

				}
			}
		}
		
		dalgo[user_y][user_x] = 2;

		// user가 움직이는 좌표

		long before = System.currentTimeMillis();
		while (true) {
			for (int i = 0; i < dalgo.length; i++) {
				for (int j = 0; j < dalgo[i].length; j++) {
					if (dalgo[i][j] == 0)
						System.out.print(shape[0] + " ");
					else if (dalgo[i][j] == 1)
						System.out.print(shape[1] + " ");
					else if (dalgo[i][j] == 2)
						System.out.print(shape[2] + " ");
				}
				System.out.println();
			}
			System.out.print("좌표를 움직이시요>>");
			String move = sc.next();
			long now = System.currentTimeMillis();
			if (now - before > time)
				break;
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
			if(life == 0) {
				System.out.println("life가 모두 소비되어 실패히셨습니다!");
				break;
			}
		}

		boolean dalgoSuccess = true;
		for (int i = 0; i < dalgo.length; i++) {
			for (int j = 0; j < dalgo[i].length; j++) {
				if (dalgo[i][j] == 1) {
					dalgoSuccess = false;
					break;
				}
			}
		}
		if (dalgoSuccess) {
			System.out.println("달고나성공!");
			System.out.println("성공하셨습니다 다음 게임으로 넘어가겠습니다");
		} else {
			System.out.println("게임 오버");
		}

	}

}

