package repositorio;

import java.util.ArrayList;
import classe.Mesas;


public class MesasRepo 
{
	private ArrayList<Mesas> mesasArrayList;

	public MesasRepo()
	{
		mesasArrayList = new ArrayList<Mesas>();
		
		generateMesas();
	}
	
	public void reserveTable( Mesas mesa )
	{
		if( mesa.isOccuped() )
		{
			mesa.setOccuped( true );
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
	
	private void generateMesas()
	{
		mesasArrayList.add( new Mesas( 1, 5 ) );
		mesasArrayList.add( new Mesas( 2, 2 ) );
		mesasArrayList.add( new Mesas( 3, 4 ) );
		mesasArrayList.add( new Mesas( 4, 6 ) );
		mesasArrayList.add( new Mesas( 5, 2 ) );
	}
}
