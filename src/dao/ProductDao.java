package dao;

public interface ProductDao
{
	static final String DELETE = "DELETE FROM restaurante.product WHERE id = ?;";
	static final String FIND_ALL = "SELECT * FROM restaurante.product ORDER BY id;";
	static final String FIND_BY_ID = "SELECT * FROM restaurante.product WHERE id = ?;";
	static final String FIND_BY_CODE = "SELECT * FROM restaurante.product WHERE code = ?;";
	static final String FIND_BY_NAME = "SELECT * FROM restaurante.product WHERE name = ?;";
	static final String INSERT = "INSERT INTO restaurante.product ( code, name, price ) VALUES( ?, ?, ? );";
	static final String UPDATE = "UPDATE restaurante.product SET code = ?, name = ?, price = ? WHERE id = ?;";
}
