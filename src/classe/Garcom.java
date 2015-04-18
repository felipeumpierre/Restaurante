package classe;

public class Garcom
{
	private String name, cpf;
	private double salary;
	
	public Garcom( String name, String cpf, double salary )
	{
		this.setName( name );
		this.setCpf( cpf );
		this.setSalary( salary );
	}
	
	public Garcom()
	{
		
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName( String name ) 
	{
		this.name = name;
	}
	
	public String getCpf() 
	{
		return cpf;
	}
	
	public void setCpf( String cpf ) 
	{
		this.cpf = cpf;
	}
	
	public double getSalary() 
	{
		return salary;
	}
	
	public void setSalary( double salary ) 
	{
		this.salary = salary;
	}
	
	public String toString()
	{
		return "\nNome: " + this.getName() + "\n" +
				"CPF: " + this.getCpf() + "\n" +
				"Salário: " + this.getSalary() + "\n";
	}
}
