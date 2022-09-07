package games;

import java.util.Random;
import java.util.Scanner;

import asciiArtSet.asciiArtSet_public;
import asciiArtSet.asciiArtSet_tug;
import model.MemberDAO;
import model.MemberDTO;

public class tug_of_war {
	
	private int quizMax;
	private String[] ask;
	private String[] answer;
	private String[] quizType;
	private int[] quizNum;
	
	private Random rd = new Random();
	private MemberDAO dao = new MemberDAO();
	
	asciiArtSet_tug linePrint = new asciiArtSet_tug();
	asciiArtSet_public ascpub = new asciiArtSet_public();
	
	public tug_of_war() 
	{
		quizMax = 30;
		ask = new String[quizMax];
		answer = new String[quizMax];
		quizType = new String[quizMax];
		quizNum = new int[quizMax];
	}
	
	public int run_tug_of_war(int score, MemberDTO dto) {

		Scanner sc = new Scanner(System.in);
		
		
		int life = 3;
		boolean isRunning = true;

		System.out.println(
				"세번째 게임은 줄다리기 게임입니다.\n" + "일정 시간 마다 줄은 왼쪽으로 움직입니다.\n" + "당신은 제한시간내에 문제를 풀어 줄을 오른쪽으로 모두 끌어당기면 성공하게 됩니다\n"
						+ "연속해서 퀴즈를 틀리게 되면 당신은 800km 밑으로 떨어지게 됩니다..\n" + "Good Luck\n");
		
		System.out.println(linePrint.line[life]);
		
		setQuiz();
		
		for(int i = 0; life != 0 && isRunning; i++) {

			if (life > 5)
			{
				System.out.println("줄다리기 게임을 통과하셨습니다 축하합니다");
				System.out.println(ascpub.gameWin);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isRunning = false;
				break;
			}
			
			System.out.println("문제 입니다. 신중히 생각하고 정확히 적어주세요.\n" + quizType[quizNum[i]]+ " " + ask[quizNum[i]]);
			String input = sc.next();

			if (answer[quizNum[i]].equals(input))
			{
				System.out.println("정답입니다\n");
				life++;
				score+=100;
				System.out.println(linePrint.line[life]);
			}
			else
			{
				System.out.println("오답입니다\n");
				life--;
				score-=100;
				System.out.println(linePrint.line[life]);
			}
		}
		
		if (life == 0) {
			System.out.println(ascpub.gameover);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dto.setLife(0);
		}
		
		return score;
		
	}
	
	public void setQuiz() 
	{
		
		for (int i = 0; i < quizNum.length; i++)
		{
			quizNum[i] = rd.nextInt(quizMax);
			for (int j = 0; j < i; j++)
				if (quizNum[i] == quizNum[j])
				{
					i--;
					break;
				}
		}
		
		for (int i = 0; i < quizNum.length; i++) {
			ask[i] = dao.selectQuizQuestion(quizNum[i] + 1);
			answer[i] = dao.selectQuizAnswer(quizNum[i] + 1);
			quizType[i] = dao.selectQuizType(quizNum[i] + 1);
		}
		
	}

}
