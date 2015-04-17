package ui;

import classe.Garcom;
import classe.Mesas;
import repositorio.GarcomRepo;
import repositorio.MesasRepo;
import util.Console;

public class ReservasUI
{
	public static void menu( MesasRepo mesa, GarcomRepo garcom )
	{
		System.out.println( "-------------\nMenu Reservas\n" );
		System.out.println( "1- Verificar/reservar mesa disponível" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: check( mesa, garcom ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void check( MesasRepo mesa, GarcomRepo garcom )
	{
		int check = Console.scanInt( "Quantas pessoas? " );
		String garcomCPF = Console.scanString( "Informe o CPF do garçom: " );
		
		Mesas available = mesa.checkTablesWithCapacity( check );
				
		for( Garcom g: garcom.getAll() )
		{
			if( g.getCpf().equals( garcomCPF ) )
			{
				mesa.reserveTable( available, g );
				mesa.reserveTable( available, g );

				break;
			}
		}

		System.out.println( "Mesa reservada com sucesso!" );
		
		menu( mesa, garcom );
	}
}
