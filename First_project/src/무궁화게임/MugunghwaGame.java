package ¹«±ÃÈ­°ÔÀÓ;

import java.util.Random;
import java.util.Scanner;

public class MugunghwaGame
{
	private static boolean isRun = true;
	private static int len = 100;
	private static int [] MugungStatus = new int[len];
	
	public static void main(String[] args) 
	{
		Random r = new Random(); 
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) 
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
				for (int j = i - cnt + r.nextInt(cnt) + 1; j < i; j++) 
					MugungStatus[j] = 1;
				cnt = 0;
			}
		}
		
		int percent = 0;
		String run = "";
		String stop = " ";
		
		for(int i = 0; i < MugungStatus.length; i++, percent++)
		{
			if(MugungStatus[i] == 0)
				System.out.println("¹«±ÃÈ­");
			else if(MugungStatus[i] == 1)
				System.out.println("¹«±ÃÈ­ ²ÉÀÌ~");
			else 
			{
				System.out.println("¹«±ÃÈ­ ²ÉÀÌ ÇÇ¾ú½À´Ï´Ù!");
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
			System.out.println("°ÔÀÓ¿¡¼­ ½Â¸®ÇÏ¼Ì½À´Ï´Ù.");
		else
			System.out.println("°ÔÀÓ ¿À¹ö");
		
		sc.close();
	}

}
