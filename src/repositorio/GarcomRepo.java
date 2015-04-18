package repositorio;

import java.util.ArrayList;

import classe.Garcom;

public class GarcomRepo
{
	private ArrayList<Garcom> garcomArrayList;
	
	public GarcomRepo()
	{
		garcomArrayList = new ArrayList<Garcom>();
		
		generate();
	}
	
	public void addGarcom( Garcom garcom )
	{
		garcomArrayList.add( garcom );
	}
	
	public Garcom getGarcom( int index )
	{
		return garcomArrayList.get( index );
	}
	
	public void removeGarcom( int index )
	{
		garcomArrayList.remove( index );
	}
	
	public ArrayList<Garcom> getAll()
	{
		return garcomArrayList;
	}
	
	public void generate()
	{
		this.addGarcom( new Garcom( "Felipe", "1", 23 ) );
		this.addGarcom( new Garcom( "Eduardo", "2", 23 ) );
		this.addGarcom( new Garcom( "Vivian", "3", 23 ) );
		this.addGarcom( new Garcom( "Ana", "4", 23 ) );
		this.addGarcom( new Garcom( "Walter", "5", 23 ) );
	}
}
