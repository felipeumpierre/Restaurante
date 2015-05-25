package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Waiter;

public class WaiterDaoImpl extends Dao implements WaiterDao
{
	private PreparedStatement ps;
	private Connection connect;
	
	private static final String DELETE = "DELETE FROM waiter WHERE id = ?";
	private static final String FIND_ALL = "SELECT * FROM waiter ORDER BY id";
	private static final String FIND_BY_ID = "SELECT * FROM waiter WHERE id = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM waiter WHERE name = ?";
	private static final String FIND_BY_CPF = "SELECT * FROM waiter WHERE cpf = ?";
	private static final String INSERT = "INSERT INTO waiter ( name, cpf, salary ) VALUES( ?, ?, ? )";
	private static final String UPDATE = "UPDATE waiter SET name = ?, cpf = ?, Salary = ? WHERE id = ?";
	
	public WaiterDaoImpl()
	{
		connect = getConnection();
	}
	
	@Override
	public int insert( Waiter w )
	{
		try
		{
			ps = connect.prepareStatement( INSERT );
			ps.setString( 0, w.getName() );
			ps.setString( 1, w.getCpf() );
			ps.setDouble( 2, w.getSalary() );
			
			int result = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if( rs.next() )
			{
				w.setId( rs.getInt( 1 ) );
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
	public int update( Waiter w )
	{
		try
		{
			ps = connect.prepareStatement( UPDATE );
			ps.setInt( 0, w.getId() );
			ps.setString( 1, w.getName() );
			ps.setString( 2, w.getCpf() );
			ps.setDouble( 3, w.getSalary() );
			
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
	public Waiter findByName( String name )
	{
		try
		{
			ps = connect.prepareStatement( FIND_BY_NAME );
			ps.setString( 0, name );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Waiter waiter = new Waiter( rs.getString( "name" ), rs.getString( "cpf" ), rs.getDouble( "salary" ) );
				waiter.setId( rs.getInt( "id" ) );
				
				return waiter;
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
	public ArrayList<Waiter> findAll()
	{
		try
		{
			ps = connect.prepareStatement( FIND_ALL );
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Waiter> w = new ArrayList<Waiter>();
			
			while( rs.next() )
			{
				Waiter waiter = new Waiter( rs.getString( "name" ), rs.getString( "cpf" ), rs.getDouble( "salary" ) );
				waiter.setId( rs.getInt( "id" ) );
				
				w.add( waiter );
			}
			
			return w;
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
	public Waiter findById( int id )
	{
		try
		{
			ps = connect.prepareStatement( FIND_BY_ID );
			ps.setInt( 0, id );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Waiter waiter = new Waiter( rs.getString( "name" ), rs.getString( "cpf" ), rs.getDouble( "salary" ) );
				waiter.setId( rs.getInt( "id" ) );
				
				return waiter;
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
	public Waiter findByCpf( String cpf ) 
	{
		try
		{
			ps = connect.prepareStatement( FIND_BY_CPF );
			ps.setString( 0, cpf );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Waiter waiter = new Waiter( rs.getString( "name" ), rs.getString( "cpf" ), rs.getDouble( "salary" ) );
				waiter.setId( rs.getInt( "id" ) );
				
				return waiter;
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
