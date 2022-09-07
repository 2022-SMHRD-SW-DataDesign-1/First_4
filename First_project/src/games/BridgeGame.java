package games;

import java.util.Random;
import java.util.Scanner;

import asciiArtSet.asciiArtSet_bridge;
import asciiArtSet.asciiArtSet_public;
import model.MemberDAO;
import model.MemberDTO;

public class BridgeGame {
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	MemberDAO dao = new MemberDAO();
	asciiArtSet_bridge bridgePrint = new asciiArtSet_bridge();
	asciiArtSet_public ascpub = new asciiArtSet_public();
	
	private String[][] words;
	private String[] answer;
	private int[] wordNum;
	private int chance;
	private boolean isRunning;
	
	public BridgeGame() 
	{
		words = new String[7][2];
		answer = new String[7];
		wordNum = new int[7];
		chance = 7;
		isRunning = true;
	}

	public int run_bridgeGame(int score, MemberDTO dto) {

		System.out.println("네번째 게임은 다리 건너기 게임입니다. \n" + "맞춤법이 맞는 단어들을 입력해 다리를 건너면 성공입니다. \n"
				+ "맞춤법이 틀린 당신은 한국에서 살아갈 수 없습니다... 안녕....\n" + "당신이 건너야 할 다리를 보여드리겠습니다. 총 7개의 발판을 건너야 합니다. \n"
				+ "Good Luck\n");

		System.out.println(bridgePrint.bridge_basic);

		setWords();

		System.out.println("맞춤법이 맞는 단어를 입력해주세요\n");
		
		int i =0;
		
		while (chance != 0 && isRunning) {
			System.out.println();
			System.out.println("문제 입니다 >> " + words[chance - 1][0] + " or " + words[chance - 1][1]);
			System.out.print("단어를 정확히 입력해주세요 >>");
			
			String input = sc.next();

			System.out.println();
			if (answer[chance - 1].equals(input)) {
				if(chance != 1) {
					System.out.println(bridgePrint.success[i++]); 
					System.out.println("정답입니다.한 칸 전진하였습니다.\n");
					score += 150;
					chance--;
				}else {
					System.out.println(bridgePrint.success[i++]); 
					System.out.println("다리건너기를 완료 하였습니다. 고생하셨습니다");
					System.out.println(ascpub.gameWin);
					ascpub.Sleep(1000);
					break;
				}
			} else {
				System.out.println("수고 하셨습니다. 탈락.");
				System.out.println(ascpub.gameover);
				ascpub.Sleep(2000);
				
				System.out.println(bridgePrint.fail);
				isRunning = false;
				dto.setLife(0);
			}

		}
		
		return score;
		
	}
	
	public void setWords() 
	{
		for (int i = 0; i < wordNum.length; i++)
		{
			wordNum[i] = rd.nextInt(24)+1;
			for (int j = 0; j < i; j++)
				if (wordNum[i] == wordNum[j])
				{
					i--;
					break;
				}
		}
		
		for (int i = 0; i < words.length; i++)
		{
			int prontback = rd.nextInt(1);
			words[i][prontback] = dao.selectWordAnswer(wordNum[i]);
			answer[i] = dao.selectWordAnswer(wordNum[i]);
			
			for (int j = 0; j < words[i].length; j++)
				if(words[i][j] == null)
					words[i][j] = dao.selectWordWrongAnswer(wordNum[i]);
		}
	}
}
