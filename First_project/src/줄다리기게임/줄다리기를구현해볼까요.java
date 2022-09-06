package 줄다리기게임;

import java.util.Random;
import java.util.Scanner;

public class 줄다리기를구현해볼까요 {

	public static void main(String[] args) {

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"세번째 게임은 줄다리기 게임입니다.\n" + "일정 시간 마다 줄은 왼쪽으로 움직입니다.\n" + "당신은 제한시간내에 문제를 풀어 줄을 오른쪽으로 모두 끌어당기면 성공하게 됩니다\n"
						+ "연속해서 퀴즈를 틀리게 되면 당신은 800km 밑으로 떨어지게 됩니다..\n" + "Good Luck\n");

		System.out.println
		("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" 
		+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"
		+ "░░████████░░░░░░░░░░██░░ ♣ ░██░░\n"		
		+ "░░████████░░░░░░░░░░██░░░░░░██░░\n" 
		+ "░░████████░░░░░░░░░░██████████░░\n" 
		+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"
		+ "░░░░░░░░░██████████████░░░░░░░░░\n"	
		+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"
		+ "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" 
		+ "██████████░░░░░░░░░░░░██████████\n"
		+ "██████████░░░░░░░░░░░░██████████\n"
		+ "██████████░░░░░░░░░░░░██████████\n"			
		+ "██████████░░░░░░░░░░░░██████████\n" 
		+ "██████████░░░░░░░░░░░░██████████\n"
		+ "██████████░░░░░░░░░░░░██████████\n" 
		+ "██████████░░░░░░░░░░░░██████████\n"

		);

		String[] ask = { "미국의 수도는 어디일까요?", "일본의 수도는 어디일까요?", "필리핀의 수도는 어디일까요?", "중국의 수도는 어디일까요?", "영국의 수도는 어디일까요?" };
		String[] answer = { "워싱턴", "도쿄", "마닐라", "베이징", "런던" };

		int[] Quiz = new int[5];

		for (int i = 0; i < Quiz.length; i++) {
			Quiz[i] = rd.nextInt(5);
			for (int j = 0; j < i; j++) {
				if (Quiz[i] == Quiz[j]) {
					i--;
					break;
				}
			}
		}
		int i = 0;
		int life = 3;
		boolean isRunning = true;
		while (life != 0 && isRunning) {

			if (life > 5) {
				System.out.println("줄다리기 게임을 통과하셨습니다 축하합니다");
				isRunning = false;
				break;
			}
			System.out.println("문제 입니다. 신중히 생각하고 정확히 적어주세요.\n" + ask[Quiz[i]]);
			String input = sc.next();

			if (answer[Quiz[i]].equals(input)) {
				System.out.println("정답입니다\n");
				life++;
				System.out.println(new 줄_출력배열().line[life]);
			} else {
				life--;
				System.out.println(new 줄_출력배열().line[life]);
			}
			i++;

		}
		if (life == 0) {
			System.out.println("GAME OVER");
		}

	}

}
