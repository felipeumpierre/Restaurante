package ui;

import repositorio.*;
import classe.*;

public class main 
{
	public static void main( String[] args ) 
	{
		MesasRepo mesasRepo = new MesasRepo();
		PedidoRepo pedidoRepo = new PedidoRepo();
		GarcomRepo garcomRepo = new GarcomRepo();
		
		garcomRepo.addGarcom( new Garcom( "Felipe", "12345", 1000.00 ) );
		garcomRepo.addGarcom( new Garcom( "Vivian", "12345", 1200.00 ) );
		garcomRepo.addGarcom( new Garcom( "Eduardo", "12345", 1400.00 ) );
		
		// cliente #1
		mesasRepo.checkTablesWithCapacity( 3 );
	}
}