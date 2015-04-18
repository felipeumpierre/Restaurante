package ui;

import classe.Garcom;
import classe.Mesas;
import repositorio.GarcomRepo;
import repositorio.MesasRepo;
import repositorio.ReservaRepo;
import util.Console;

public class ReservasUI
{
	public static void menu( ReservaRepo reserva, GarcomRepo garcom, MesasRepo mesa )
	{
		System.out.println( "-------------\nMenu Reservas\n" );
		System.out.println( "1- Verificar/reservar mesa disponível" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: check( reserva, garcom, mesa ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void check( ReservaRepo reserva, GarcomRepo garcom, MesasRepo mesa )
	{
		int check = Console.scanInt( "Quantas pessoas? " );
		
		Mesas available = mesa.checkTablesWithCapacity( check );
		
		if( available == null )
		{
			System.out.println( "--------------------------------" );
			System.out.println( "Não foram encontrados mesas para a quantidade de pessoas informada.\nVerifique caso não tenha nenhuma mesa cadastrada ou todas estão ocupadas." );
			menu( reserva, garcom, mesa );
		}
		
		boolean garcomFound = false, out = false;
		
		while( out == false )
		{
			String garcomCPF = Console.scanString( "Informe o CPF do garçom: " );
			
			for( Garcom g: garcom.getAll() )
			{
				if( g.getCpf().equals( garcomCPF ) )
				{
					reserva.addGarcom( g );
					reserva.addMesa( available );
					
					available.setOccuped( true );
					
					garcomFound = true;
					out = true;
					
					break;
				}
			}
			
			if( out == false )
			{
				char option = Console.scanChar( "Não foi encontrado um garçom com o CPF: " + garcomCPF + "\n\nDeseja procurar por outro CPF? (S/n)" );
				
				switch( option )
				{
					case 'n':
					case 'N': out = true;
				}
			}
		}
		
		if( garcomFound )
		{
			System.out.println( "--------------------------------" );
			System.out.println( reserva.toString() );
			System.out.println( "--------------------------------" );
	
			System.out.println( "Mesa reservada com sucesso!" );
		}
		menu( reserva, garcom, mesa );
	}
}
