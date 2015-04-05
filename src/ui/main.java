package ui;

import repositorio.*;
import classe.*;

public class main 
{
	public static void main( String[] args ) 
	{
		MesasRepo mesasRepo = new MesasRepo();
		PedidoRepo pedidoRepo = new PedidoRepo();
		GarcomRepo garcomRepo = new GarcomRepo();
		ProdutosRepo produtosRepo = new ProdutosRepo();
		
		garcomRepo.addGarcom( new Garcom( "Felipe", "12345", 1000.00 ) );
		garcomRepo.addGarcom( new Garcom( "Vivian", "12345", 1200.00 ) );
		garcomRepo.addGarcom( new Garcom( "Eduardo", "12345", 1400.00 ) );
		
		// cliente #1
		Mesas available = mesasRepo.checkTablesWithCapacity( 3 );
		
		mesasRepo.reserveTable( available, garcomRepo.getGarcom( 0 ) );
		
		Pedido pedido = new Pedido();		
		pedido.setProdutosArrayList( produtosRepo.getProduto( 0 ) );
		pedido.setProdutosArrayList( produtosRepo.getProduto( 2 ) );
		
		available.addPedidos( pedido );
		
		available.toString();
	}
}