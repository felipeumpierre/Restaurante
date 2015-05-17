package ui;

import java.util.InputMismatchException;

import entity.Table;
import repo.TableRepo;
import util.Console;

public class TableUI
{
	private TableRepo table = new TableRepo();
	
	public TableUI( TableRepo t )
	{
		this.table = t;
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Mesa" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Adicionar mesa" ) );
			System.out.println( String.format( "| %-24s |", "2- Listar mesas" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: addTable(); break;
				case 2: listTable(); break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	private void addTable()
	{
		System.out.println( "\n--- Adicionando nova mesa ---\n" );
		
		int opt = 0;
		int number = 0, capacity = 0;
		
		do
		{
			try
			{
				number = Console.scanInt( "Número: " );

				opt = 0;
			}
			catch( InputMismatchException e )
			{
				System.out.println( "- Você deve informar um número." );
				
				opt = 1;
			}
		}
		while( opt != 0 );
		
		opt = 0;
		
		do
		{
			try
			{
				capacity = Console.scanInt( "Capacidade: " );

				opt = 0;
			}
			catch( InputMismatchException e )
			{
				System.out.println( "- Você deve informar um número para a capacidade." );
				
				opt = 1;
			}
		}
		while( opt != 0 );
			
		boolean ok = this.table.addTable( new Table( number, capacity ) );
		
		if( ok )
		{
			System.out.println( "\nMesa Nro." + number + " cadastrada com sucesso!" );
		}
		else
		{
			System.out.println( "\nMesa Nro." + number + " já foi cadastrada." );
		}
		
		System.out.println( "\n--- Fim de cadastro de mesa ---" );
	}
	
	public void listTable()
	{
		System.out.println( "\n--- Listar mesas ---\n" );	
		System.out.println( this.table.toString() );		
		System.out.println( "--- Fim da listagem de mesas ---" );
	}
}
