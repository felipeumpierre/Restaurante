package repositorio;

import java.util.ArrayList;
import classe.Mesas;


public class MesasRepo 
{
	private ArrayList<Mesas> mesasArrayList;

	public MesasRepo()
	{
		mesasArrayList = new ArrayList<Mesas>();
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
	
}
