package ui;

import repo.*;
import util.Console;

public class main
{
	public static void main( String[] args )
	{
		run();
	}

	private static void run()
	{
		ProductRepo productRepo = new ProductRepo();
		TableRepo tableRepo = new TableRepo();
		WaiterRepo waiterRepo = new WaiterRepo();
		
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Inicial" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Menu Mesas" ) );
			System.out.println( String.format( "| %-24s |", "2- Menu Produtos" ) );
			System.out.println( String.format( "| %-24s |", "3- Menu Garcons" ) );
			System.out.println( String.format( "| %-24s |", "4- Restaurante" ) );
			System.out.println( String.format( "| %-24s |", "0- Sair" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: new TableUI( tableRepo ).run(); break;
				case 2: new ProductUI( productRepo ).run(); break;
				case 3: new WaiterUI( waiterRepo ).run(); break;
				case 4: new RestaurantUI( tableRepo, productRepo, waiterRepo ).run(); break;
				case 0: break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
	}
}
