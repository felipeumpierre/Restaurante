package dao;

import java.util.ArrayList;

public interface Methods<T>
{
	public int insert( T t );
	public int delete( int id );
	public int update( T t );
	public ArrayList<T> findAll();
	public T findById( int id );
	public T findByNumber( int number );
}
