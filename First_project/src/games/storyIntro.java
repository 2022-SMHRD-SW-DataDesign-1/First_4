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
		System.out.println("JDBC�� �ѱ�� ����Ʈ���簳�߿��� ������� �����̹� ���ӿ� �پ���.\n"
						 + "���� ����������� ���ο� ���� �����ϱ� ����.\n"
						 + "������ ��ΰ� ���ڰ� �� �� ���� ��.\n"
						 + "Ż���ϴ� �̵��� ġ������ ����� �����ؾ� �Ѵ�.");
		System.out.println("�� 4���� ���������� �̰ܳ��� ������ ������ �� �ִ� �ڰ��� ���Եȴ�.");
		System.out.println("����� ����� 1���̴� ħ���ϰ� ���������� ������ �ֽñ� �ٶ��ϴ�.");
		ascpub.Sleep(4000);
	}
	
}
