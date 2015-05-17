package repo;

import java.util.ArrayList;
import entity.Product;

public class ProductRepo
{
	private ArrayList<Product> product;
	
	public ProductRepo()
	{
		product = new ArrayList<Product>();
		
		populate();
	}
	
	public void addProduct( Product p )
	{
		product.add( p );
	}
	
	public Product getProduct( int index )
	{
		return product.get( index );
	}
	
	public Product getProductByName( String name )
	{
		for( Product p: product )
		{
			if( p.getName().equalsIgnoreCase( name ) )
			{
				return p;
			}
		}
		
		return null;
	}
	
	public Product getProductByCode( int code )
	{
		for( Product p: product )
		{
			if( code == p.getCode() )
			{
				return p;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		for( Product p: product )
		{
			result.append( p.toString() );
		}
		
		return result.toString();
	}

	private void populate()
	{
		this.addProduct( new Product( 1, "Produto #1", 100.00 ) );
		this.addProduct( new Product( 2, "Produto #2", 20.00 ) );
		this.addProduct( new Product( 3, "Produto #3", 10.00 ) );
		this.addProduct( new Product( 4, "Produto #4", 140.00 ) );
		this.addProduct( new Product( 5, "Produto #5", 50.00 ) );
		this.addProduct( new Product( 6, "Produto #6", 8.00 ) );
		this.addProduct( new Product( 7, "Produto #7", 4.50 ) );
	}
}
