package repositorio;

import java.util.ArrayList;

import classe.Mesas;
import classe.Pedido;

public class MesasRepo 
{
	private ArrayList<Mesas> mesasArrayList;
	private ArrayList<Pedido> pedidoArrayList;

	public MesasRepo()
	{
		mesasArrayList = new ArrayList<Mesas>();
		
		generate();
	}
	
	public void addMesas( Mesas mesa )
	{
		mesasArrayList.add( mesa );
	}
	
	public Mesas getMesa( int index )
	{
		return mesasArrayList.get( index );
	}
	
	public int size()
	{
		return mesasArrayList.size();
	}
	
	public ArrayList<Pedido> getPedido()
	{
		return pedidoArrayList;
	}

	public void addPedido( Pedido pedido )
	{
		this.pedidoArrayList.add( pedido );
	}

	public void leaveTable( Mesas mesa )
	{
		if( mesa.isOccuped() )
		{
			mesa.setOccuped( false );
		}
	}
	
	public Mesas checkTablesWithCapacity( int capacity )
	{
		for( Mesas mesa: mesasArrayList )
		{
			if( ( mesa.getTotal() >= capacity ) && ( !mesa.isOccuped() ) )
			{
				return mesa;
			}
		}
		
		return null;
	}

	public void generate()
	{
		this.addMesas( new Mesas( 1, 2 ) );
		this.addMesas( new Mesas( 2, 2 ) );
		this.addMesas( new Mesas( 3, 4 ) );
		this.addMesas( new Mesas( 4, 6 ) );
	}
}
