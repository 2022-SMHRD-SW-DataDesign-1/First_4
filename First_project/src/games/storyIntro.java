package games;

import asciiArtSet.asciiArtSet_public;
import javazoom.jl.player.MP3Player;
import musicPlayer.musicCon;

public class storyIntro
{

	asciiArtSet_public ascpub = new asciiArtSet_public();
	musicCon mc = new musicCon();
	
	public void intro(MP3Player mp3) 
	{
		if(mp3.isPlaying()) 
			mp3.stop();
		mc.playMusic(mp3, 1);
		for (int i = 0; i < ascpub.title_animation.length; i++) {
			System.out.println(ascpub.title_animation[i]); 
			ascpub.Sleep(400);
		}
		System.out.println(ascpub.gameTitle);
		System.out.println("JDBC�� �ѱ�� ����Ʈ���簳�߿��� ������� �����̹� ���ӿ� �پ���.\n"
						 + "���� ����������� ���ο� ���� �����ϱ� ����.\n"
						 + "������ ��ΰ� ���ڰ� �� �� ���� ��.\n"
						 + "Ż���ϴ� �̵��� ġ������ ����� �����ؾ� �Ѵ�.");
		System.out.println("�� 4���� ���������� �̰ܳ��� ������ ������ �� �ִ� �ڰ��� ���Եȴ�.");
		System.out.println("����� ����� 1���̴� ħ���ϰ� ���������� ������ �ֽñ� �ٶ��ϴ�.\n");
		ascpub.Sleep(4000);
	}
	
}
