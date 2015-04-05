package repositorio;

import java.util.ArrayList;
import classe.Produtos;

public class ProdutosRepo
{
	private ArrayList<Produtos> produtosArrayList;
	
	public ProdutosRepo()
	{
		produtosArrayList = new ArrayList<Produtos>();
		
		generateProdutos();
	}
	
	public void addProdutos( Produtos produtos )
	{
		produtosArrayList.add( produtos );
	}
	
	public Produtos getProduto( int index )
	{
		return produtosArrayList.get( index );
	}
	
	private void generateProdutos()
	{
		produtosArrayList.add( new Produtos( 1, "Produto #1", 100.00 ) );
		produtosArrayList.add( new Produtos( 2, "Produto #2", 200.00 ) );
		produtosArrayList.add( new Produtos( 3, "Produto #3", 300.00 ) );
		produtosArrayList.add( new Produtos( 4, "Produto #4", 400.00 ) );
	}
}
