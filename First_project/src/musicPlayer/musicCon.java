package musicPlayer;

import javazoom.jl.player.MP3Player;

public class musicCon 
{
	private String path = ".\\music\\";
	
	public String [] musicNameSet = {"1.����.mp3", // 0
								"2.����ȭ��_����.mp3",//1
								"3-1.����ȭ.mp3",//2
								"3-2.����ȭ����.mp3",//3
								"3-3.�Ǿ����ϴ�.mp3",//4
								"4.�ް�bgm.mp3",//5
								"5-1.�ٴٸ���bgm.mp3",//6
								"5-2.�ٴٸ����ѹ���Ʋ��������.mp3",//7
								"5-3.�ٴٸ���Ż�����.mp3",//8
								"6-1.¡�˴ٸ�bgm.mp3",//9
								"6-2.¡�˴ٸ�Ż����.mp3",//10
								"7-1.���ӽ���(��)_����.mp3",//11
								"7-2.����Ż����_����.mp3",//12
								"8.��½�.mp3",//13
								"3-3.����ȭ�����Ǿ����ϴ�.mp3"//14
								};
	
	public void playMusic(MP3Player p, int pathNum) 
	{
		p.play(path+musicNameSet[pathNum]);
	}
}

