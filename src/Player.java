
public class Player {
	private String name;
	private int right;
	private int wrong;
	
	public Player(String Name,int Right, int Wrong)
	{
		name = Name;
		right = Right;
		wrong = Wrong;
	}
	
	//set and get player name
	public void setName(String Name)
	{
		name = Name;
	}
	public String getName()
	{
		return name;
	}
	
	//set and get player right time
	public void setRight(int Right)
	{
		right = Right;
	}
	public int getRight()
	{
		return right;
	}
	
	//set and get player wrong time
	public void setWrong(int Wrong)
	{
		wrong = Wrong;
	}
	public int getWrong()
	{
		return wrong;
	}
	
	
	public String toString()
	{
		return "Player: " + name + "  "+ right + "right" + "  and "+ wrong + " "+ "wrong";   
	}
}
