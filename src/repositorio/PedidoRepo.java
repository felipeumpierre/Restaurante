package repositorio;

import java.util.ArrayList;

import classe.Pedido;
import classe.Produtos;

public class PedidoRepo
{
	private Pedido pedido;
	
	public PedidoRepo()
	{
		pedido = new Pedido();
	}
	
	public void addProdutos( Produtos produtos )
	{
		pedido.setProdutosArrayList( produtos );
	}
	
	public ArrayList<Produtos> getProdutos()
	{
		return pedido.getProdutosArrayList();
	}
}
