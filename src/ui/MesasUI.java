package ui;

import classe.Mesas;
import repositorio.MesasRepo;
import util.Console;

public class MesasUI
{	
	public static void menu( MesasRepo mesa )
	{
		System.out.println( "-------------\nMenu Mesa\n" );
		System.out.println( "1- Adicionar Mesa" );
		System.out.println( "2- Listar Mesas" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: add( mesa ); break;
			case 2: list( mesa ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void add( MesasRepo mesa )
	{
		System.out.println( "-------------\n\tNova Mesa\n" );
		
		int numero = Console.scanInt( "Número: " );
		int total = Console.scanInt( "Total de pessoas: " );
		
		mesa.addMesas( new Mesas( numero, total ) );
			
		System.out.println( "\nMesa adicionada com sucesso!" );
		
		menu( mesa );
	}
	
	public static void list( MesasRepo mesa )
	{
		System.out.println( "-------------\nListagem de Mesas\n" );
		
		for( int i = 0; i < mesa.size(); i++ )
		{
			Mesas m = mesa.getMesa( i );

			m.toString();
		}
		
		System.out.println( "\nFim de mesas." );
		
		menu( mesa );
	}
}