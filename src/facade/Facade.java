package facade;

import dao.Dao;
import dao.ProductDaoImpl;
import dao.TableDaoImpl;
import dao.WaiterDaoImpl;

public abstract class Facade
{
	public Dao Facade( DaoType type )
	{		
		switch( type )
		{
			case TABLE: return table();
			case WAITER: return waiter();
			case PRODUCT: return product();
			default: return null;
		}
	}
	
	private TableDaoImpl table()
	{
		return new TableDaoImpl();
	}
	
	private WaiterDaoImpl waiter()
	{
		return new WaiterDaoImpl();
	}
	
	private ProductDaoImpl product()
	{
		return new ProductDaoImpl();
	}
	
	static enum DaoType
	{
		TABLE, WAITER, PRODUCT
	}
}
