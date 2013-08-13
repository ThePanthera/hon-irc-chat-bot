package brain;

import org.pircbotx.PircBotX;
import irc.irc;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
		// IRC Bot, Settings vars.
		PircBotX bot = new PircBotX();
		bot.setName("Honbot");
		bot.connect("irc.marek.ca");
		bot.joinChannel("#honbot");
		
		
		// End IRC Bot
	}

}
