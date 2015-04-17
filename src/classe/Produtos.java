package classe;

public class Produtos 
{
	private int code, sale;
	private String name;
	private double price;
	private String[] type = { "comida", "bebida", "sobremesa", "outro" };
	
	public Produtos( int code, String name, double price )
	{
		this.setCode( code );
		this.setName( name );
		this.setPrice( price );
	}
	
	public int getCode() 
	{
		return code;
	}
	
	public void setCode( int code ) 
	{
		this.code = code;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName( String name ) 
	{
		this.name = name;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice( double price ) 
	{
		this.price = price;
	}
	
	public String[] getType() 
	{
		return type;
	}
	
	public void setType( String[] type ) 
	{
		this.type = type;
	}
	
	public int getSale()
	{
		return this.sale;
	}
	
	public void saled()
	{
		this.sale++;
	}
	
	public String toString()
	{
		return "\tProduto #" + this.getCode() + "\n" +
				"\t\tNome: " + this.getName() + "\n" +
				"\t\tPreço: " + this.getPrice() + "\n";
	}
}
