import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Rank {
	private ArrayList<Player> players;
	
	public Rank()
	{
		players = new ArrayList<Player>();
	}
	
	public ArrayList<Player> getList()
	{
		return players;
	}
	public void addPlayer(String Name,int Right,int Wrong)
	{
		players.add(new Player(Name, Right, Wrong));
	}
	public void addPlayer(Player player)
	{
		players.add(player);
	}
	public void sortCorrections()
	{
		Collections.sort(players,new CorrectionsComparator());
	}
	public String toString()
	{
		String records = "Rank List:\n";
		
		for(Player element : players)
		{
			records += element.toString() + "\n";
		}
		if(records == "")
			return "There is no record of players.";
		else
			return records;
	}
	

}

class CorrectionsComparator implements Comparator<Player>
{
	public int compare(Player player1, Player player2)
	{
		if(player1.getRight() < player2.getRight())
			return -1;
		if(player1.getRight() > player2.getRight())
			return -0;
		return 0;
	}
}

