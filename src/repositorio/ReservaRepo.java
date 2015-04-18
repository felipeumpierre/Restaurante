package repositorio;

import java.util.ArrayList;
import classe.*;

public class ReservaRepo
{
	private ArrayList<Mesas> mesaRepo;
	private ArrayList<Garcom> garcomRepo;
	private ArrayList<Pedido> pedidoRepo;
	
	public ReservaRepo()
	{
		mesaRepo = new ArrayList<Mesas>();
		garcomRepo = new ArrayList<Garcom>();
		pedidoRepo = new ArrayList<Pedido>();
	}

	public ArrayList<Mesas> getMesaRepo()
	{
		return mesaRepo;
	}

	public void addMesa( Mesas mesa )
	{
		this.mesaRepo.add( mesa );
	}

	public ArrayList<Garcom> getGarcomRepo()
	{
		return garcomRepo;
	}

	public void addGarcom( Garcom garcom ) 
	{
		this.garcomRepo.add( garcom );
	}

	public ArrayList<Pedido> getPedidoRepo() 
	{
		return pedidoRepo;
	}

	public void addPedido( Pedido pedido ) 
	{
		this.pedidoRepo.add( pedido );
	}
	
	@Override
	public String toString()
	{
		String message = "";
		
		message += "\nMesa:";
		
		for( Mesas m: this.getMesaRepo() )
		{
			message += m.toString();
		}
		
		message += "\nGarçom que está atendendo:";
		
		for( Garcom g: this.getGarcomRepo() )
		{
			message += g.toString();
		}
		
		return message;
	}
}
