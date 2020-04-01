
/****
 * 
 * random number and color generator. 
 * supports GamePanel and GameLetterPanel
 *
 */
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.awt.*;
public class RanLet 
{
	private String letter ="ABCDEFGHIJKLMNOPQRSTUVWXZY";
	private int width=780;
	private Random rand = new Random();
	public int ranLet()
	{
		
		int $ranNumber = 20 + rand.nextInt(width);
		return $ranNumber;
	}
	public String ranLetLetter() 
	{
		int ranNumNumber = rand.nextInt(10);
		String Num =  letter.substring(ranNumNumber, ranNumNumber+1);
		return Num;
	}
	
	
	public Color ranLetColor() {
		int ranColorRed = 0 + rand.nextInt(256);
		int ranColorBlue = 0 + rand.nextInt(256);
		int ranColorGreen = 0 + rand.nextInt(256);
	    Color  c = new Color(ranColorRed, ranColorBlue, ranColorGreen);
	    return c;
	}


}

