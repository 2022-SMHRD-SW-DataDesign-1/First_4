package games;

import asciiArtSet.asciiArtSet_public;

public class storyIntro
{

	asciiArtSet_public ascpub = new asciiArtSet_public();
	
	public void intro() 
	{
		for (int i = 0; i < ascpub.title_animation.length; i++) {
			System.out.println(ascpub.title_animation[i]); 
			ascpub.Sleep(400);
		}
		
		System.out.println(ascpub.gameTitle);
		System.out.println("JDBC에 쫓기는 스마트인재개발원의 사람들이 서바이벌 게임에 뛰어든다.\n"
						 + "대기업 취업조건으로 새로운 삶을 시작하기 위해.\n"
						 + "하지만 모두가 승자가 될 순 없는 법.\n"
						 + "탈락하는 이들은 치명적인 결과를 각오해야 한다.");
		System.out.println("총 4개의 스테이지를 이겨내야 대기업에 취직할 수 있는 자격을 갖게된다.");
		System.out.println("당신의 목숨은 1개이니 침착하게 스테이지를 진행해 주시기 바랍니다.");
		ascpub.Sleep(4000);
	}
	
}
