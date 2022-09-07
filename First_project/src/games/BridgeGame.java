package games;

import java.util.Random;
import java.util.Scanner;

import asciiArtSet.asciiArtSet_bridge;
import model.MemberDAO;

public class BridgeGame {
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	MemberDAO dao = new MemberDAO();
	asciiArtSet_bridge bridgePrint = new asciiArtSet_bridge();
	
	private String[][] words;
	private int[] wordNum;
	private int chance;
	private boolean isRunning;
	
	public BridgeGame() 
	{
		words = new String[7][2];
		wordNum = new int[7];
		chance = 7;
		isRunning = true;
	}

	public void run_bridgeGame() {

		System.out.println("네번째 게임은 다리 건너기 게임입니다. \n" + "맞춤법이 맞는 단어들을 입력해 다리를 건너면 성공입니다. \n"
				+ "맞춤법이 틀린 당신은 한국에서 살아갈 수 없습니다... 안녕....\n" + "당신이 건너야 할 다리를 보여드리겠습니다. 총 7개의 발판을 건너야 합니다. \n"
				+ "Good Luck\n");

		System.out.println(bridgePrint.basic);

		setWords();

		System.out.println("맞춤법이 맞는 단어를 입력해주세요\n");
		
		int i =0;
		
		while (chance != 0 && isRunning) {
			System.out.println();
			System.out.println("문제 입니다 >> " + words[chance - 1][0] + " or " + words[chance - 1][1]);
			System.out.print("단어를 정확히 입력해주세요 >>");
			String answer = sc.next();

			System.out.println();
			if (words[chance - 1][1].equals(answer)) {
				if(chance != 1) {
					System.out.println(bridgePrint.success[i++]); 
					System.out.println("정답입니다.한 칸 전진하였습니다.\n");
					chance--;
				}else {
					System.out.println(bridgePrint.success[i++]); 
					System.out.println("다리건너기를 완료 하였습니다. 고생하셨습니다");
					break;
				}
			} else {
				System.out.println("수고 하셨습니다. 탈락.");
				System.out.println(bridgePrint.fail);
				isRunning = false;

			}

		}
		
		System.out.println("다음 게임을 넘어가시려면 Enter를 눌러주세요");
		
		sc.close();

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
			
			for (int j = 0; j < words[i].length; j++)
				if(words[i][j] == null)
					words[i][j] = dao.selectWordWrongAnswer(wordNum[i]);
		}
	}
}
