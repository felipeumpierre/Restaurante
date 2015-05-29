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
	
	public WaiterDaoImpl()
	{
	}
	
	@Override
	public int insert( Waiter w )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( INSERT, ps.RETURN_GENERATED_KEYS );
			ps.setString( 1, w.getName() );
			ps.setString( 2, w.getCpf() );
			ps.setDouble( 3, w.getSalary() );
			
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
	public int update( Waiter w )
	{
		try
		{
			connect = getConnection();
			ps = connect.prepareStatement( UPDATE );
			ps.setInt( 1, w.getId() );
			ps.setString( 2, w.getName() );
			ps.setString( 3, w.getCpf() );
			ps.setDouble( 4, w.getSalary() );
			
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
			connect = getConnection();
			ps = connect.prepareStatement( FIND_BY_NAME );
			ps.setString( 1, name );
			
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
			connect = getConnection();
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
			connect = getConnection();
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
			connect = getConnection();
			ps = connect.prepareStatement( FIND_BY_CPF );
			ps.setString( 1, cpf );
			
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
