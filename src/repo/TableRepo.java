package repo;

import dao.TableDaoImpl;
import entity.Table;

public class TableRepo 
{
	private TableDaoImpl dao;
	
	public TableRepo()
	{
		dao = new TableDaoImpl();
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
	
	public void save( Table t )
	{
		dao.update( t );
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
		for( Table t: dao.findAll() )
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
		for( Table t: dao.findAll() )
		{
			if( t.getCapacity() >= capacity && ( t.getAvailable() == 1 ) )
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
		
		result.append( "+-----+-----+-----+------------+\n" );
		result.append( String.format( "| %-3s | %-3s | %-3s | %-10s |\n", "Id", "Nr", "Cp", "Status" ) );
		result.append( "+-----+-----+-----+------------+\n" );
		
		if( dao.findAll().size() > 0 )
		{
			for( Table t: dao.findAll() )
			{
				result.append( t.toString() );
			}
		}
		else
		{
			result.append( String.format( "| %-24s |\n", "Nenhum resultado encontrado" ) );
		}
		
		result.append( "+-----+-----+-----+------------+\n" );
		
		return result.toString();
	}
	
	public String toStringByTable( Table t )
	{
		StringBuilder result = new StringBuilder();
		
		result.append( "+-----+-----+-----+------------+\n" );
		result.append( String.format( "| %-3s | %-3s | %-3s | %-10s |\n", "Id", "Nr", "Cp", "Status" ) );
		result.append( "+-----+-----+-----+------------+\n" );
		
		result.append( t.toString() );
		
		result.append( "+-----+-----+-----+------------+\n" );
		
		return result.toString();
	}
}