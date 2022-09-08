package musicPlayer;

import javazoom.jl.player.MP3Player;

public class musicCon 
{
	public String [] pathSet = {"C:\\Users\\smhrd\\Desktop\\bgm_최종\\1.시작.mp3", // 0
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\2.메인화면_공용.mp3",//1
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\3-1.무궁화.mp3",//2
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\3-2.무궁화꽃이.mp3",//3
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\3-3.피었습니다.mp3",//4
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\4.달고나bgm.mp3",//5
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\5-1.줄다리기bgm.mp3",//6
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\5-2.줄다리기한문제틀릴때마다.mp3",//7
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\5-3.줄다리기탈락비명.mp3",//8
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\6-1.징검다리bgm.mp3",//9
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\6-2.징검다리탈락시.mp3",//10
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\7-1.게임실패(총)_공용.mp3",//11
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\7-2.최종탈락시_공용.mp3",//12
								"C:\\Users\\smhrd\\Desktop\\bgm_최종\\8.우승시.mp3"//13
								};
	
	public void playMusic(MP3Player p, int pathNum) 
	{
		p.play(pathSet[pathNum]);
	}
}

