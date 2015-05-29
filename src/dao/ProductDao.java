package dao;

import java.util.ArrayList;

import entity.Product;

public interface ProductDao
{
	static final String DELETE = "DELETE FROM restaurante.product WHERE id = ?;";
	static final String FIND_ALL = "SELECT * FROM restaurante.product ORDER BY id;";
	static final String FIND_BY_ID = "SELECT * FROM restaurante.product WHERE id = ?;";
	static final String FIND_BY_CODE = "SELECT * FROM restaurante.product WHERE code = ?;";
	static final String FIND_BY_NAME = "SELECT * FROM restaurante.product WHERE name = ?;";
	static final String INSERT = "INSERT INTO restaurante.product ( code, name, price ) VALUES( ?, ?, ? );";
	static final String UPDATE = "UPDATE restaurante.product SET code = ?, name = ?, price = ? WHERE id = ?;";
	
	public int insert( Product t );
	public int delete( int id );
	public int update( Product t );
	public ArrayList<Product> findAll();
	public Product findById( int id );
	public Product findByName( String name );
	public Product findByCode( int code );
}
