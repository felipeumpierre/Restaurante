package repo;

import dao.WaiterDaoImpl;
import entity.Waiter;

public class WaiterRepo
{
	private WaiterDaoImpl dao;
	
	public WaiterRepo()
	{
		dao = new WaiterDaoImpl();
	}
	
	public void addWaiter( Waiter w )
	{
		dao.insert( w );
	}
	
	public Waiter getWaiterByName( String name )
	{
		Waiter w = dao.findByName( name );
		
		if( w instanceof Waiter )
		{
			return w;
		}
		
		return null;
	}
	
	public Waiter getWaiterById( int id )
	{
		Waiter w = dao.findById( id );
		
		if( w instanceof Waiter )
		{
			return w;
		}
		
		return null;
	}
	
	public Waiter getWaiterByCpf( String cpf )
	{
		for( Waiter w: dao.findAll() )
		{
			if( w.getCpf().equalsIgnoreCase( cpf ) )
			{
				return w;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		result.append( "+-----+--------------+--------------+----------+\n" );
		result.append( String.format( "| %-3s | %-12s | %-12s | %-8s |\n", "Id", "Nome", "CPF", "Salario" ) );
		result.append( "+-----+--------------+--------------+----------+\n" );
		
		if( dao.findAll().size() > 0 )
		{
			for( Waiter w: dao.findAll() )
			{
				result.append( w.toString() );
			}
		}
		else
		{
			result.append( String.format( "| %-44s |\n", "Nenhum resultado encontrado" ) );
		}
		
		result.append( "+-----+--------------+--------------+----------+\n" );
		
		return result.toString();
	}
}
