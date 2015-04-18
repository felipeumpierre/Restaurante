package ui;

import classe.Produtos;
import classe.Mesas;
import repositorio.PedidoRepo;
import repositorio.ProdutosRepo;
import repositorio.ReservaRepo;
import util.Console;

public class PedidosUI
{
	public static void menu( PedidoRepo pedido, ReservaRepo reserva, ProdutosRepo produtos )
	{
		System.out.println( "-------------\nMenu Pedidos\n" );
		System.out.println( "1- Adicionar produto a um Pedido" );
		System.out.println( "2- Remover produto de um Pedido" );
		System.out.println( "3- Listar itens do pedido" );
		System.out.println( "4- Finalizar pedido" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: add( pedido, reserva, produtos ); break;
			case 2: remove( pedido, reserva, produtos ); break;
			case 3: list( pedido, reserva, produtos ); break;
			case 4: checkout( pedido, reserva, produtos ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void add( PedidoRepo pedido, ReservaRepo reserva, ProdutosRepo produtos )
	{
		System.out.println( "-------------\nAdicionando produtos no pedido\n" );
		
		int mesaCode = Console.scanInt( "Informe o número da mesa: " );
		
		for( Mesas m: reserva.getMesaRepo() )
		{
			if( m.getNumber() == mesaCode )
			{
				boolean out = false, found = false;
				int totalAdd = 0;
				
				while( out == false )
				{
					int code = Console.scanInt( "Informe o código do produto: " );
					
					for( Produtos p: produtos.getProdutos() )
					{
						if( p.getCode() == code )
						{
							m.setProdutos( p );
							
							found = true;
							totalAdd++;
						}
					}
					
					char option;
					
					if( found == false )
					{
						option = Console.scanChar( "Não foi encontrado nenhum produto com esse código " + code + ".\nDeseja procurar novamente? (S/n) " );
					}
					else
					{
						option = Console.scanChar( "Foi encontrado e adicionado no pedido. Deseja adicionar outro produto? (S/n) " );
					}			
					
					switch( option )
					{
						case 'n':
						case 'N': out = true;
					}
				}
			}
		}
		
		System.out.println( "-------------\nProdutos adicionados\n" );
		
		for( Mesas m: reserva.getMesaRepo() )
		{
			for( Produtos p: m.getProdutos() )
			{
				System.out.println( p.toString() );
			}
		}
		
		menu( pedido, reserva, produtos );
	}

	public static void remove( PedidoRepo pedido, ReservaRepo reserva, ProdutosRepo produtos )
	{
		boolean out = false;
		
		while( out == false )
		{
			int code = Console.scanInt( "Informe o código do produto que você deseja remover: " );
			
			for( Mesas m: reserva.getMesaRepo() )
			{
				for( int i = 0; i < m.getProdutos().size(); i++ )
				{
					if( m.getProduto( i ).getCode() == code )
					{
						m.removeProduto( i );
						
						System.out.println( "Removido com sucesso!" );
					}
				}
			}
			
			char option = Console.scanChar( "Continuar? (S/n)" );
			
			switch( option )
			{
				case 'n':
				case 'N': out = true;
			}
		}
		
		menu( pedido, reserva, produtos );
	}

	public static void list( PedidoRepo pedido, ReservaRepo reserva, ProdutosRepo produtos )
	{
		for( Mesas m: reserva.getMesaRepo() )
		{
			for( Produtos p: m.getProdutos() )
			{
				System.out.println( p.toString() );
			}
		}
		
		menu( pedido, reserva, produtos );
	}

	public static void checkout( PedidoRepo pedido, ReservaRepo reserva, ProdutosRepo produtos )
	{
		System.out.println( "Em desenvolvimento." );
		
		menu( pedido, reserva, produtos );
	}
}