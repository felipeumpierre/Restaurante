package dao;

import java.util.ArrayList;

import entity.Waiter;

public interface WaiterDao
{
	public int insert( Waiter w );
	public int delete( int id );
	public int update( Waiter w );
	public Waiter findByName( String name );
	public Waiter findByCpf( String cpf );
	public ArrayList<Waiter> findAll();
	public Waiter findById( int id );
}
