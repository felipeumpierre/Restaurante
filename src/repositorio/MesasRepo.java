package repositorio;

import java.util.ArrayList;

import classe.Garcom;
import classe.Mesas;

public class MesasRepo 
{
	private ArrayList<Mesas> mesasArrayList;

	public MesasRepo()
	{
		mesasArrayList = new ArrayList<Mesas>();
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
		
	public void reserveTable( Mesas mesa, Garcom garcom )
	{
		if( !mesa.isOccuped() )
		{
			mesa.setOccuped( true );
			mesa.setGarcom( garcom );
			mesa.used();
		}
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

}
