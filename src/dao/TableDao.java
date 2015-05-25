package dao;

import java.util.ArrayList;

import entity.Table;

public interface TableDao
{
	public int insert( Table t );
	public int delete( int id );
	public int update( Table t );
	public ArrayList<Table> findAll();
	public Table findById( int id );
	public Table findByNumber( int number );
}
