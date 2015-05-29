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
		result.append( String.format( "| %-3s | %-12s | %-12s | %-8s |\n", "Id", "Nome", "Cpf", "Salário" ) );
		result.append( "+-----+--------------+--------------+----------+\n" );
		
		for( Waiter w: dao.findAll() )
		{
			result.append( w.toString() );
		}
		
		result.append( "+-----+--------------+--------------+----------+\n" );
		
		return result.toString();
	}
}
