
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameLetterPanel extends JPanel implements Runnable
{
	public static Thread letterThread = null;
	private int y =10;
	static long nLetterDropped = 1;
	RanLet rn = new RanLet();
	int ranLet = rn.ranLet();
	String Letter = rn.ranLetLetter();
	Color letColor = rn.ranLetColor();
	
	
	GameLetterPanel()
	{
		if (letterThread == null)
		{
			letterThread = new Thread(this);
			letterThread.start();
		}
	}
	
	public void run()
	{
		Thread myThread = Thread.currentThread();
		while (letterThread == myThread)
		{
			try
			{
				Thread.sleep(20);
			}
			catch(InterruptedException e) {
				
			}
			repaint();
			
		}
	}
	
	public String getLetter()
	{
		return this.Letter;
	}
	
	public void paint (Graphics g)
	{
		 g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 48));
	     g.setColor(Color.white);
	     g.drawString(Letter, ranLet, y);
	     y+=3;
	     Dimension d = getSize();
	     if (y>(d.width -10))
	     {
	    	 y=10;
	    	 GameLetterPanel.nLetterDropped +=1;
	    	 ranLet = rn.ranLet();
	    	 this.Letter = rn.ranLetLetter();
	    	 this.letColor = rn.ranLetColor();
	    	 
	     }
	     
	     g.setFont (new Font ("Arial", Font.BOLD+Font.ITALIC, 42));
	     g.setColor(letColor);
	     g.drawString(Letter, ranLet, y);
	     
	     String text = "Java Make Me Happy"; 
	     g.drawString(text, 60, 60); 
	}

	public static void stop() {		
		letterThread = null;
	}
}
