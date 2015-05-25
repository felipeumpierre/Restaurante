package dao;

import java.util.ArrayList;

import entity.Product;

public interface ProductDao
{
	public int insert( Product t );
	public int delete( int id );
	public int update( Product t );
	public ArrayList<Product> findAll();
	public Product findById( int id );
	public Product findByName( String name );
	public Product findByCode( int code );
}
