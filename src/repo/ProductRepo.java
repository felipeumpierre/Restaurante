package repo;

import dao.ProductDaoImpl;
import entity.Product;
import entity.Table;

public class ProductRepo
{
	private ProductDaoImpl dao;
	
	public ProductRepo()
	{
		dao = new ProductDaoImpl();
		
		populate();
	}
	
	public void addProduct( Product p )
	{
		dao.insert( p );
	}
	
	public Product getProduct( int index )
	{
		return dao.findById( index );
	}
	
	public Product getProductByName( String name )
	{
		Product p = dao.findByName( name );
		
		if( p instanceof Product )
		{
			return p;
		}
		
		return null;
	}
	
	public Product getProductByCode( int code )
	{
		Product p = dao.findByCode( code );
		
		if( p instanceof Product )
		{
			return p;
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( "+-----+-----+--------------+\n" );
		result.append( String.format( "| %-3s | %-3s | %-3s | %-12s |\n", "Id", "Nr", "Cp", "Status" ) );
		result.append( "+-----+-----+--------------+\n" );
		
		for( Product p: dao.findAll() )
		{
			result.append( p.toString() );
		}
		
		result.append( "+-----+-----+--------------+\n" );
		
		return result.toString();
	}

	private void populate()
	{
		this.addProduct( new Product( 1, "Produto #1", 100.00 ) );
	}
}
