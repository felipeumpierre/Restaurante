package repo;

import dao.ProductDaoImpl;
import entity.Product;
import entity.Waiter;

public class RequestRepo
{
	private Waiter waiter;
	private ProductDaoImpl dao;
	
	public RequestRepo()
	{
	}
	
	public void addWaiter( Waiter w )
	{
		waiter = w;
	}
	
	public Waiter getWaiter()
	{
		return waiter;
	}
	
	public void addProduct( Product p )
	{
		dao.insert( p );
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		if( waiter instanceof Waiter )
		{
			result.append( "+--------------+----------+----------+\n" );
			result.append( String.format( "| %-12s | %-8s | %-8s |\n", "Nome", "CPF", "Salario" ) );
			result.append( "+--------------+----------+----------+\n" );
			result.append( waiter.toString() );
			result.append( "+--------------+----------+----------+\n" );
		}
		
		if( dao.findAll().size() > 0 )
		{
			result.append( "+--------------+--------+\n" );
			result.append( String.format( "| %-12s | %-6s |\n", "Nome", "Preco" ) );
			result.append( "+--------------+--------+\n" );
			
			for( Product p: dao.findAll() )
			{
				result.append( p.toString() );
			}
			
			result.append( "+--------------+--------+" );
		}
		
		return result.toString();
	}
}
