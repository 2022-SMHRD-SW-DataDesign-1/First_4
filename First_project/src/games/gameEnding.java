package games;

import asciiArtSet.asciiArtSet_public;
import javazoom.jl.player.MP3Player;
import musicPlayer.musicCon;

public class gameEnding 
{
	asciiArtSet_public ascpub = new asciiArtSet_public();
	musicCon mc = new musicCon();
	
	public void ending(MP3Player mp3) 
	{
		if(mp3.isPlaying())
			mp3.stop();
		mc.playMusic(mp3, 13);
		
		System.out.println(ascpub.gameEnd);
		ascpub.Sleep(3000);
	}
}
