package repositorio;

import java.util.ArrayList;

import classe.Garcom;

public class GarcomRepo
{
	private ArrayList<Garcom> garcomArrayList;
	
	public GarcomRepo()
	{
		garcomArrayList = new ArrayList<Garcom>();
	}
	
	public void addGarcom( Garcom garcom )
	{
		garcomArrayList.add( garcom );
	}
	
	public void removeGarcom( int index )
	{
		garcomArrayList.remove( index );
	}
}
