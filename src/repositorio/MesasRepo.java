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
	
	/**
	 * 
	 * 
	 * @param capacity
	 * @return ArrayList<Mesas>
	 */
	public ArrayList<Mesas> checkTablesWithCapacity( int capacity )
	{
		ArrayList<Mesas> tablesThatCanUse = new ArrayList<Mesas>();
		
		for( Mesas mesa: mesasArrayList )
		{
			if( mesa.getTotal() >= capacity )
			{
				tablesThatCanUse.add( mesa );
			}
		}
		
		return tablesThatCanUse;
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
