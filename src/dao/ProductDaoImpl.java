package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Product;

public class ProductDaoImpl extends Dao implements ProductDao
{
	private PreparedStatement ps;
	private Connection connect;
	
	private static final String DELETE = "DELETE FROM product WHERE id = ?";
	private static final String FIND_ALL = "SELECT * FROM product ORDER BY id";
	private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
	private static final String FIND_BY_CODE = "SELECT * FROM product WHERE code = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM waiter WHERE name = ?";
	private static final String INSERT = "INSERT INTO product ( code, name, price ) VALUES( ?, ?, ? )";
	private static final String UPDATE = "UPDATE product SET code = ?, name = ?, price = ? WHERE id = ?";
	
	public ProductDaoImpl()
	{
		connect = getConnection();
	}

	@Override
	public int insert( Product p )
	{
		try
		{
			ps = connect.prepareStatement( INSERT );
			ps.setInt( 0, p.getCode() );
			ps.setString( 1, p.getName() );
			ps.setDouble( 2, p.getPrice() );
			
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
			ps = connect.prepareStatement( DELETE );
			ps.setInt( 0, id );
			
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
			ps = connect.prepareStatement( UPDATE );
			ps.setInt( 0, p.getId() );
			ps.setInt( 1, p.getCode() );
			ps.setString( 2, p.getName() );
			ps.setDouble( 2, p.getPrice() );
			
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
			ps = connect.prepareStatement( FIND_BY_NAME );
			ps.setString( 0, name );
			
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
			ps = connect.prepareStatement( FIND_BY_ID );
			ps.setInt( 0, id );
			
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
			ps = connect.prepareStatement( FIND_BY_CODE );
			ps.setInt( 0, code );
			
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
