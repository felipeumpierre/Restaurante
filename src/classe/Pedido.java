package classe;

import java.util.ArrayList;
import java.util.Date;

public class Pedido
{
	private int code, table, status;
	private Date dateTime;
	private Garcom garcom;
	private ArrayList<Produtos> produtosArrayList;
	
	public int getCode() 
	{
		return code;
	}
	
	public void setCode( int code ) 
	{
		this.code = code;
	}
	
	public int getTable() 
	{
		return table;
	}
	
	public void setTable( int table ) 
	{
		this.table = table;
	}
	
	public Date getDateTime() 
	{
		return dateTime;
	}
		
	public Garcom getGarcom() 
	{
		return garcom;
	}
	
	public void setGarcom( Garcom garcom ) 
	{
		this.garcom = garcom;
	}
	
	public ArrayList<Produtos> getProdutosArrayList() 
	{
		return produtosArrayList;
	}
	
	public void setProdutosArrayList( Produtos produtos ) 
	{
		this.produtosArrayList.add( produtos );
	}

	public int getStatus() 
	{
		return status;
	}

	public void setStatus( int status ) 
	{
		this.status = status;
	}
}
