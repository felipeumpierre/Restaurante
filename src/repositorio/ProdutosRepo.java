package repositorio;

import java.util.ArrayList;

import classe.Produtos;

public class ProdutosRepo
{
	private ArrayList<Produtos> produtosArrayList;
	
	public ProdutosRepo()
	{
		produtosArrayList = new ArrayList<Produtos>();
		
		generate();
	}
	
	public void addProdutos( Produtos produtos )
	{
		produtosArrayList.add( produtos );
	}
	
	public Produtos getProduto( int index )
	{
		try
		{
			return produtosArrayList.get( index );
		}
		catch( IndexOutOfBoundsException e )
		{
			throw new IndexOutOfBoundsException( "O produto selecionado não existe." );
		}
	}
	
	public ArrayList<Produtos> getProdutos()
	{
		return produtosArrayList;
	}
	
	public int size()
	{
		return produtosArrayList.size();
	}
	
	public void generate()
	{
		this.addProdutos( new Produtos( 1, "Produto tal", 10.00 ) );
		this.addProdutos( new Produtos( 2, "Produto tal2", 10.00 ) );
		this.addProdutos( new Produtos( 3, "Produto tal3", 10.00 ) );
		this.addProdutos( new Produtos( 4, "Produto tal4", 10.00 ) );
		this.addProdutos( new Produtos( 5, "Produto tal5", 10.00 ) );
	}
}
