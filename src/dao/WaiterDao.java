package dao;

public interface WaiterDao
{
	static final String DELETE = "DELETE FROM restaurante.waiter WHERE cpf = ?";
	static final String FIND_ALL = "SELECT * FROM restaurante.waiter ORDER BY id";
	static final String FIND_BY_ID = "SELECT * FROM restaurante.waiter WHERE id = ?";
	static final String FIND_BY_NAME = "SELECT * FROM restaurante.waiter WHERE name = ?";
	static final String FIND_BY_CPF = "SELECT * FROM restaurante.waiter WHERE cpf = ?";
	static final String INSERT = "INSERT INTO restaurante.waiter ( name, cpf, salary ) VALUES( ?, ?, ? )";
	static final String UPDATE = "UPDATE restaurante.waiter SET name = ?, cpf = ?, salary = ? WHERE id = ?";
}
