package facade;

import java.util.ArrayList;

import dao.Methods;

public class DaoFacade<T, E> implements Methods<E>
{
	private T instance;
	
	public DaoFacade( T cl )
	{
		instance = cl;
	}
	
	@Override
	public int insert( E t ) 
	{
		return ( ( Methods<E> ) instance ).insert( t );
	}

	@Override
	public int delete( int id )
	{
		return ( ( Methods<E> ) instance ).delete( id );
	}

	@Override
	public int update( E t ) 
	{
		return ( ( Methods<E> ) instance ).update( t );
	}

	@Override
	public ArrayList<E> findAll() 
	{
		return ( ( Methods<E> ) instance ).findAll();
	}

	@Override
	public E findById( int id ) 
	{
		return ( ( Methods<E> ) instance ).findById( id );
	}

	@Override
	public E findByNumber( int number ) 
	{
		return ( ( Methods<E> ) instance ).findByNumber( number );
	}
}
