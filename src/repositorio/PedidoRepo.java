package repositorio;

import java.util.ArrayList;

import classe.Pedido;
import classe.Produtos;
import exception.InvalidStatusCode;

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
	
	public void changeStatusPedido( int status ) throws InvalidStatusCode
	{
		switch( status )
		{
			case 2:
				pedido.setStatus( status );
				break;
			default:
				throw new InvalidStatusCode( "Código inválido." );
		}
	}
}
