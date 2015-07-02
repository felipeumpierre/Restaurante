package dao;

public interface TableDao
{
	static final String DELETE = "DELETE FROM restaurante.table WHERE number = ?;";
	static final String FIND_ALL = "SELECT * FROM restaurante.table ORDER BY id;";
	static final String FIND_BY_ID = "SELECT * FROM restaurante.table WHERE id = ?;";
	static final String FIND_BY_NUMBER = "SELECT * FROM restaurante.table WHERE number = ?;";
	static final String INSERT = "INSERT INTO restaurante.table ( number, capacity ) VALUES( ?, ? );";
	static final String UPDATE = "UPDATE restaurante.table SET number = ?, capacity = ? WHERE id = ?;";
}