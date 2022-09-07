package games;

import java.util.Random;
import java.util.Scanner;

public class MugunghwaGame
{
	Random r = new Random(); 
	Scanner sc = new Scanner(System.in);
	
	private boolean isRun;
	private int len;
	private int [] MugungStatus;
	
	public MugunghwaGame()
	{
		isRun = true;
		len = 50;
		MugungStatus = new int[len];
	}
	
	public void run_MugunghwaGame() 
	{
		setMugungStat();
		
		int percent = 0;
		String run = "";
		String stop = " ";
		
		for(int i = 0; i < MugungStatus.length; i++, percent++)
		{
			if(MugungStatus[i] == 0)
				System.out.println("무궁화");
			else if(MugungStatus[i] == 1)
				System.out.println("무궁화 꽃이~");
			else 
			{
				System.out.println("무궁화 꽃이 피었습니다!");
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				if(isRun)
					break;
				else
					isRun = true;
			}
			
			String input = sc.nextLine();
			
			if(stop.equals(input) && isRun)
				isRun = false;
			if(run.equals(input) && !isRun)
				isRun = true;
			
		}

		if(percent == MugungStatus.length)
			System.out.println("게임에서 승리하셨습니다.");
		else
			System.out.println("게임 오버");
		
	}
	
	public void setMugungStat() 
	{
		for (int i = 0; i < 5; i++) 
		{
			int ranIndex = r.nextInt(len/3)*3;
			if(MugungStatus[ranIndex] == 0)
				MugungStatus[ranIndex] = 1;
			else
				i--;
		}
		
		int cnt = 0;
		
		for (int i = 0; i < MugungStatus.length; i++) 
		{
			if(MugungStatus[i] == 0)
				cnt++;
			else if(MugungStatus[i] == 1) 
			{
				MugungStatus[i]++;
				for (int j = i - cnt + r.nextInt(cnt)/2 + 1; j < i; j++) 
					MugungStatus[j] = 1;
				cnt = 0;
			}
		}
	}

}
