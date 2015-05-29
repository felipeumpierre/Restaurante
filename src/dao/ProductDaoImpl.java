package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Product;

public class ProductDaoImpl extends Dao implements ProductDao
{
	private PreparedStatement ps;
	private Connection connect;
	
	public ProductDaoImpl()
	{
	}

	@Override
	public int insert( Product p )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( INSERT, Statement.RETURN_GENERATED_KEYS );
			ps.setInt( 1, p.getCode() );
			ps.setString( 2, p.getName() );
			ps.setDouble( 3, p.getPrice() );
			
			int result = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if( rs.next() )
			{
				p.setId( rs.getInt( 1 ) );
			}
			
			return result;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}

	@Override
	public int delete( int id )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( DELETE );
			ps.setInt( 1, id );
			
			return ps.executeUpdate();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}

	@Override
	public int update( Product p )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( UPDATE );
			ps.setInt( 1, p.getId() );
			ps.setInt( 2, p.getCode() );
			ps.setString( 3, p.getName() );
			ps.setDouble( 4, p.getPrice() );
			
			return ps.executeUpdate();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}

	@Override
	public ArrayList<Product> findAll()
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( FIND_ALL );
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Product> p = new ArrayList<Product>();
			
			while( rs.next() )
			{
				Product product = new Product( rs.getInt( "code" ), rs.getString( "name" ), rs.getDouble( "price" ) );
				product.setId( rs.getInt( "id" ) );
				
				p.add( product );
			}
			
			return p;
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}
	
	@Override
	public Product findByName( String name )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( FIND_BY_NAME );
			ps.setString( 1, name );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Product product = new Product( rs.getInt( "code" ), rs.getString( "name" ), rs.getDouble( "price" ) );
				product.setId( rs.getInt( "id" ) );
				
				return product;
			}
			else
			{
				return null;
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}

	@Override
	public Product findById( int id )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( FIND_BY_ID );
			ps.setInt( 1, id );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Product product = new Product( rs.getInt( "code" ), rs.getString( "name" ), rs.getDouble( "price" ) );
				product.setId( rs.getInt( "id" ) );
				
				return product;
			}
			else
			{
				return null;
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}

	@Override
	public Product findByCode( int code ) 
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( FIND_BY_CODE );
			ps.setInt( 1, code );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Product product = new Product( rs.getInt( "code" ), rs.getString( "name" ), rs.getDouble( "price" ) );
				product.setId( rs.getInt( "id" ) );
				
				return product;
			}
			else
			{
				return null;
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		finally
		{
			close( ps );
			close( connect );
		}
	}
}
