package ui;

import repositorio.*;
import util.Console;

public class RelatoriosUI 
{
	public static void menu( MesasRepo mesa, ProdutosRepo produto, GarcomRepo garcom )
	{
		System.out.println( "-------------\nMenu Relatórios\n" );
		System.out.println( "1- Vendas" );
		System.out.println( "2- Mesas" );
		System.out.println( "3- Garçons" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: sells( mesa, produto, garcom ); break;
			case 2: tables( mesa, produto, garcom ); break;
			case 3: waiters( mesa, produto, garcom ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void sells( MesasRepo mesa, ProdutosRepo produto, GarcomRepo garcom )
	{
		System.out.println( "Não implementado ainda." );
		menu( mesa, produto, garcom );
	}
	
	public static void tables( MesasRepo mesa, ProdutosRepo produto, GarcomRepo garcom )
	{
		System.out.println( "Não implementado ainda." );
		menu( mesa, produto, garcom );
	}
	
	public static void waiters( MesasRepo mesa, ProdutosRepo produto, GarcomRepo garcom )
	{
		System.out.println( "Não implementado ainda." );
		menu( mesa, produto, garcom );
	}
}