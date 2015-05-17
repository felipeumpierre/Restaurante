package repo;

import java.util.ArrayList;

import entity.Product;
import entity.Waiter;

public class RequestRepo
{
	private Waiter waiter;
	private ArrayList<Product> product;
	
	public RequestRepo()
	{
		product = new ArrayList<Product>();
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
		product.add( p );
	}
	
	public Product getProduct( int index )
	{
		return product.get( index );
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		if( waiter instanceof Waiter )
		{
			result.append( "+--------------+----------+----------+\n" );
			result.append( String.format( "| %-12s | %-8s | %-8s |\n", "Nome", "CPF", "Salário" ) );
			result.append( "+--------------+----------+----------+\n" );
			result.append( waiter.toString() );
			result.append( "+--------------+----------+----------+\n" );
		}
		
		if( product.size() > 0 )
		{
			result.append( "+--------------+--------+\n" );
			result.append( String.format( "| %-12s | %-6s |\n", "Nome", "Preço" ) );
			result.append( "+--------------+--------+\n" );
			
			for( Product p: product )
			{
				result.append( p.toString() );
			}
			
			result.append( "+--------------+--------+" );
		}
		
		return result.toString();
	}
}
