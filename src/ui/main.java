package ui;

import repositorio.*;
import util.Console;
import classe.*;
import ui.*;

public class main 
{
	public static MesasRepo mesasRepo = new MesasRepo();
	public static ProdutosRepo produtosRepo = new ProdutosRepo();
	public static GarcomRepo garcomRepo = new GarcomRepo();
	public static PedidoRepo pedidoRepo = new PedidoRepo();
	public static ReservaRepo reservaRepo = new ReservaRepo();
	
	public static void main( String[] args ) 
	{
		menu();
		
		/*
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
		
		mesasRepo.leaveTable( available );		
		mesasRepo.reserveTable( available, garcomRepo.getGarcom( 1 ) );
		
		mesasRepo.leaveTable( available );		
		mesasRepo.reserveTable( available, garcomRepo.getGarcom( 2 ) );
		
		Pedido pedido = new Pedido();		
		pedido.setProdutosArrayList( produtosRepo.getProduto( 0 ) );
		pedido.setProdutosArrayList( produtosRepo.getProduto( 6 ) );
		
		available.addPedidos( pedido );
		
		pedido.setProdutosArrayList( produtosRepo.getProduto( 1 ) );
		
		available.addPedidos( pedido );
		
		available.toString();
		*/
	}
	
	public static void menu()
	{
		System.out.println( "-------------\nMenu\n" );
		System.out.println( "1- Menu de Garçom" );
		System.out.println( "2- Menu de Mesa" );
		System.out.println( "3- Menu de Produtos" );
		System.out.println( "4- Menu de Reserva" );
		System.out.println( "5- Menu de Pedidos" );
		System.out.println( "6- Gerar Relatórios" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
		
		switch( option )
		{
			case 1: GarcomUI.menu( garcomRepo ); break;
			case 2: MesasUI.menu( mesasRepo ); break;
			case 3: ProdutosUI.menu( produtosRepo ); break;
			case 4: ReservasUI.menu( reservaRepo, garcomRepo, mesasRepo ); break;
			case 5: PedidosUI.menu( pedidoRepo, reservaRepo, produtosRepo ); break;
			case 6: RelatoriosUI.menu( mesasRepo, produtosRepo, garcomRepo ); break;
		}
	}
}