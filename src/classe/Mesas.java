package classe;

public class Mesas 
{
	private int number, total;
	private boolean occuped = false;
	private Pedido pedidos = new Pedido();
	private Garcom garcom = new Garcom();

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
	
	public void addPedidos( Pedido pedidos )
	{
		this.pedidos = pedidos;
	}
	
	public Pedido getPedidos()
	{
		return this.pedidos;
	}
	
	public Garcom getGarcom() 
	{
		return garcom;
	}

	public void setGarcom( Garcom garcom ) 
	{
		this.garcom = garcom;
	}

	public String toString()
	{
		System.out.println( "Pedidos: " );
		System.out.println( this.pedidos.toString() );
		
		System.out.println( "Garçom responsável: " );
		System.out.println( this.garcom.toString() );
		
		
		return "";
	}
}
 