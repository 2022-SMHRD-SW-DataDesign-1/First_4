package musicPlayer;

import javazoom.jl.player.MP3Player;

public class musicCon 
{
	public String [] pathSet = {"C:\\Users\\smhrd\\Desktop\\bgm_����\\1.����.mp3", // 0
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\2.����ȭ��_����.mp3",//1
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\3-1.����ȭ.mp3",//2
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\3-2.����ȭ����.mp3",//3
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\3-3.�Ǿ����ϴ�.mp3",//4
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\4.�ް�bgm.mp3",//5
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\5-1.�ٴٸ���bgm.mp3",//6
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\5-2.�ٴٸ����ѹ���Ʋ��������.mp3",//7
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\5-3.�ٴٸ���Ż�����.mp3",//8
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\6-1.¡�˴ٸ�bgm.mp3",//9
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\6-2.¡�˴ٸ�Ż����.mp3",//10
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\7-1.���ӽ���(��)_����.mp3",//11
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\7-2.����Ż����_����.mp3",//12
								"C:\\Users\\smhrd\\Desktop\\bgm_����\\8.��½�.mp3"//13
								};
	
	public void playMusic(MP3Player p, int pathNum) 
	{
		p.play(pathSet[pathNum]);
	}
}

