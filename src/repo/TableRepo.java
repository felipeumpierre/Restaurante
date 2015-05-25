package repo;

import java.util.ArrayList;

import dao.TableDaoImpl;
import entity.Table;

public class TableRepo 
{
	private ArrayList<Table> table;
	private TableDaoImpl dao;
	
	public TableRepo()
	{
		table = new ArrayList<Table>();
		
		popuplate();
	}
	
	public boolean addTable( Table t )
	{
		if( !checkTableNumber( t.getNumber() ) )
		{
			dao.insert( t );
			
			return true;
		}
		
		return false;
	}
	
	public Table getTable( int index )
	{
		return table.get( index );
	}
	
	public Table getTableByNumber( int number )
	{
		Table t = dao.findByNumber( number );
		
		if( t instanceof Table )
		{
			return t;
		}
		
		return null;
	}
	
	public boolean checkTableNumber( int number )
	{
		for( Table t: table )
		{
			if( number == t.getNumber() )
			{
				return true;
			}
		}
		
		return false;
	}
	
	public Table checkAvailableTableByCapacity( int capacity )
	{
		for( Table t: table )
		{
			if( t.getCapacity() >= capacity && t.isAvailable() )
			{
				return t;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( "+-----+-----+--------------+\n" );
		result.append( String.format( "| %-3s | %-3s | %-12s |\n", "Nr", "Cp", "Status" ) );
		result.append( "+-----+-----+--------------+\n" );
		
		for( Table t: table )
		{
			result.append( t.toString() );
		}
		
		result.append( "+-----+-----+------------+" );
		
		return result.toString();
	}
	
	public String toStringByTable( Table t )
	{
		StringBuilder result = new StringBuilder();
		
		result.append( "+-----+-----+--------------+\n" );
		result.append( String.format( "| %-3s | %-3s | %-12s |\n", "Nr", "Cp", "Status" ) );
		result.append( "+-----+-----+--------------+\n" );
		
		result.append( t.toString() );
		
		result.append( "+-----+-----+--------------+" );
		
		return result.toString();
	}

	private void popuplate()
	{
		this.addTable( new Table( 1, 2 ) );
		this.addTable( new Table( 2, 1 ) );
		this.addTable( new Table( 3, 1 ) );
		this.addTable( new Table( 4, 2 ) );
		this.addTable( new Table( 5, 3 ) );
		this.addTable( new Table( 6, 4 ) );
		this.addTable( new Table( 7, 4 ) );
		this.addTable( new Table( 8, 6 ) );
		this.addTable( new Table( 9, 8 ) );
	}
}