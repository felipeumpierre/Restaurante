package repo;

import java.util.ArrayList;

import dao.ProductDaoImpl;
import entity.Product;

public class ProductRepo
{
	private ProductDaoImpl dao;
	private ArrayList<Product> product;
	
	public ProductRepo()
	{
		product = new ArrayList<Product>();
		dao = new ProductDaoImpl();
	}
	
	public void addProduct( Product p )
	{
		dao.insert( p );
	}
	
	public void addProductToArray( Product p )
	{
		product.add( p );
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

	public Product getProductById( int id )
	{
		Product p = dao.findById( id );
		
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
		
		result.append( "+-----+--------+--------------+----------+\n" );
		result.append( String.format( "| %-3s | %-6s | %-12s | %-8s |\n", "Id", "Código", "Nome", "Preço" ) );
		result.append( "+-----+--------+--------------+----------+\n" );
		
		if( dao.findAll().size()> 0 )
		{
			for( Product p: dao.findAll() )
			{
				result.append( p.toString() );
			}
		}
		else
		{
			result.append( String.format( "| %-30s |\n", "Nenhum resultado encontrado" ) );
		}
			
		result.append( "+-----+--------+--------------+----------+" );
		
		return result.toString();
	}
	
	public String toStringArray()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( "+-----+--------+--------------+----------+\n" );
		result.append( String.format( "| %-3s | %-6s | %-12s | %-8s |\n", "Id", "Código", "Nome", "Preço" ) );
		result.append( "+-----+--------+--------------+----------+\n" );
		
		if( product.size()> 0 )
		{
			for( Product p: product )
			{
				result.append( p.toString() );
			}
		}
		else
		{
			result.append( String.format( "| %-30s |\n", "Nenhum resultado encontrado" ) );
		}
			
		result.append( "+-----+--------+--------------+----------+" );
		
		product.clear();
		
		return result.toString();
	}
}
