package classe;

import java.util.ArrayList;

public class Mesas 
{
	private int number, total, used;
	private boolean occuped = false;
	private Garcom garcom;
	private ArrayList<Produtos> produto = new ArrayList<Produtos>();

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
		this.used();
	}

	public int getUsed()
	{
		return used;
	}

	public void used()
	{
		this.used++;
	}

	public Garcom getGarcom()
	{
		return garcom;
	}

	public void setGarcom( Garcom garcom )
	{
		this.garcom = garcom;
	}

	public ArrayList<Produtos> getProdutos()
	{
		return produto;
	}

	public Produtos getProduto( int index )
	{
		return this.produto.get( index );
	}
	
	public void removeProduto( int index )
	{
		this.produto.remove( index );
	}
	
	public void setProdutos( Produtos produto )
	{
		this.produto.add( produto );
	}

	public String toString()
	{
		String message = "#" + this.getNumber();
		message += "\nTotal de ocupantes: " + this.getTotal();
		message += "\nStatus da mesa: " + ( this.isOccuped() ? "Ocupada" : "Desocupada" );
		message += "\nMesa usada " + this.getUsed() + " vez(es)" + "\n";		
		
		return message;
	}
}
 