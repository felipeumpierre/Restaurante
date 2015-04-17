package ui;

import classe.Garcom;
import repositorio.GarcomRepo;
import util.Console;

public class GarcomUI 
{	
	public static void menu( GarcomRepo garcom )
	{
		System.out.println( "-------------\nMenu Garçom\n" );
		System.out.println( "1- Adicionar Garçom" );
		System.out.println( "2- Listar Garçons" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: add( garcom ); break;
			case 2: list( garcom ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void add( GarcomRepo garcom )
	{
		System.out.println( "-------------\n\tNovo Garçom\n" );
		
		String name = Console.scanString( "Nome: " );
		String cpf = Console.scanString( "CPF: " );
		double salary = Console.scanDouble( "Salário: " );
		
		garcom.addGarcom( new Garcom( name, cpf, salary ) );
			
		System.out.println( "\nGarçom adicionado com sucesso!" );
		
		menu( garcom );
	}
	
	public static void list( GarcomRepo garcom )
	{
		System.out.println( "-------------\nListagem de Garçons\n" );
		
		for( Garcom g: garcom.getAll() )
		{
			System.out.println( g.toString() );
		}
		
		System.out.println( "\nFim de garçons." );
		
		menu( garcom );
	}
}