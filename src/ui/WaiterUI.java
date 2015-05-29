package ui;

import java.util.InputMismatchException;

import entity.Waiter;
import repo.WaiterRepo;
import util.Console;

public class WaiterUI 
{
	private WaiterRepo waiter = new WaiterRepo();
	
	public WaiterUI( WaiterRepo w )
	{
		this.waiter = w;
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Garcom" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Adicionar garcom" ) );
			System.out.println( String.format( "| %-24s |", "2- Listar garcons" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: addWaiter(); break;
				case 2: listWaiter(); break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	private void addWaiter()
	{
		System.out.println( "\n--- Adicionando novo garcom ---\n" );
		
		String name = Console.scanString( "Nome: " );
		String cpf = Console.scanString( "CPF: " );
		
		int opt = 0;
		double salary = 0;
		
		do
		{
			try
			{
				salary = Console.scanDouble( "Salario: " );

				opt = 0;
			}
			catch( InputMismatchException e )
			{
				System.out.println( "- Você deve informar valor monetario." );
				
				opt = 1;
			}
		}
		while( opt != 0 );
		
		this.waiter.addWaiter( new Waiter( name, cpf, salary ) );
		System.out.println( "\nGarcom adicionado com sucesso!" );
		
		System.out.println( "\n--- Fim de cadastro de garcom ---" );
	}
	
	public void listWaiter()
	{
		System.out.println( "\n--- Listar garcons ---\n" );	
		System.out.println( this.waiter.toString() );		
		System.out.println( "--- Fim da listagem de garcons ---" );
	}
}
