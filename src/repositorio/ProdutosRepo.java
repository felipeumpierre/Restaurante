package repositorio;

import java.util.ArrayList;

import classe.Produtos;

public class ProdutosRepo
{
	private ArrayList<Produtos> produtosArrayList;
	
	public ProdutosRepo()
	{
		produtosArrayList = new ArrayList<Produtos>();
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
	
	public int size()
	{
		return produtosArrayList.size();
	}
}
