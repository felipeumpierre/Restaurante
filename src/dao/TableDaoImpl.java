package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Table;

public class TableDaoImpl extends Dao implements TableDao
{
	private PreparedStatement ps;
	private Connection connect;
	
	private static final String DELETE = "DELETE FROM table WHERE id = ?";
	private static final String FIND_ALL = "SELECT * FROM table ORDER BY id";
	private static final String FIND_BY_ID = "SELECT * FROM table WHERE id = ?";
	private static final String FIND_BY_NUMBER = "SELECT * FROM table WHERE number = ?";
	private static final String INSERT = "INSERT INTO table ( number, capacity ) VALUES( ?, ? )";
	private static final String UPDATE = "UPDATE table SET number = ?, capacity = ? WHERE id = ?";
	
	public TableDaoImpl()
	{
		connect = getConnection();
	}

	@Override
	public int insert( Table t )
	{
		try
		{
			ps = connect.prepareStatement( INSERT );
			ps.setInt( 0, t.getNumber() );
			ps.setInt( 1, t.getCapacity() );
			
			int result = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			
			if( rs.next() )
			{
				t.setId( rs.getInt( 1 ) );
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
	public int update( Table t )
	{
		try
		{
			ps = connect.prepareStatement( UPDATE );
			ps.setInt( 0, t.getId() );
			ps.setInt( 1, t.getNumber() );
			ps.setInt( 2, t.getCapacity() );
			
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
	public ArrayList<Table> findAll()
	{
		try
		{
			ps = connect.prepareStatement( FIND_ALL );
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Table> t = new ArrayList<Table>();
			
			while( rs.next() )
			{
				Table table = new Table( rs.getInt( "number" ), rs.getInt( "capacity" ) );
				table.setId( rs.getInt( "id" ) );
				
				t.add( table );
			}
			
			return t;
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
	public Table findById( int id )
	{
		try
		{
			ps = connect.prepareStatement( FIND_BY_ID );
			ps.setInt( 0, id );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Table table = new Table( rs.getInt( "number" ), rs.getInt( "capacity" ) );
				table.setId( rs.getInt( "id" ) );
				
				return table;
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
	public Table findByNumber( int number )
	{
		try
		{
			ps = connect.prepareStatement( FIND_BY_NUMBER );
			ps.setInt( 0, number );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() )
			{
				Table table = new Table( rs.getInt( "number" ), rs.getInt( "capacity" ) );
				table.setId( rs.getInt( "id" ) );
				
				return table;
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
