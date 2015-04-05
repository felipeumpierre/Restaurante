package classe;

public class Mesas 
{
	private int number, total;
	private boolean occuped = false;

	public Mesas( int number, int total )
	{
		this.setNumber( number );
		this.setTotal( total );
	}
	
	public int getNumber()
	{
		return number;
	}

	public void setNumber( int number ) 
	{
		this.number = number;
	}

	public int getTotal() 
	{
		return total;
	}

	public void setTotal( int total ) 
	{
		this.total = total;
	}

	public boolean isOccuped() 
	{
		return occuped;
	}

	public void setOccuped( boolean occuped )
	{
		this.occuped = occuped;
	}
}
