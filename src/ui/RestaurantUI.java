package ui;

import java.util.ArrayList;
import java.util.InputMismatchException;

import entity.Product;
import entity.Table;
import entity.TableRequest;
import entity.TableRequestProduct;
import entity.Waiter;
import repo.*;
import util.Console;

public class RestaurantUI
{
	private TableRepo table = new TableRepo();
	private WaiterRepo waiter = new WaiterRepo();
	private ProductRepo product = new ProductRepo();
	private TableRequestRepo tableRequestRepo = new TableRequestRepo();
	private TableRequestProductRepo tableRequestProductRepo = new TableRequestProductRepo();
	
	public RestaurantUI( TableRepo t, ProductRepo p, WaiterRepo w )
	{
		table = t;
		waiter = w;
		product = p;
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+-------------------------------------+" );
			System.out.println( String.format( "| %-35s |", "Menu Restaurante" ) );
			System.out.println( "+-------------------------------------+" );
			System.out.println( String.format( "| %-35s |", "1- Verificar mesa para cliente" ) );
			System.out.println( String.format( "| %-35s |", "2- Adicionar garcom para mesa" ) );
			System.out.println( String.format( "| %-35s |", "3- Adicionar produtos para mesa." ) );
			System.out.println( String.format( "| %-35s |", "4- Listar informacoes da mesa." ) );
			System.out.println( String.format( "| %-35s |", "0- Voltar" ) );
			System.out.println( "+-------------------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: checkTableAvailableAndCapacity(); break;
				case 2: addWaiter(); break;
				case 3: addProductToTable(); break;
				case 4: listTable(); break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	public void checkTableAvailableAndCapacity()
	{
		System.out.println( "\n---- Verificando mesa para cliente ----" );
		
		int opt = 0;
		int capacity = 0;
				
		do
		{
			try
			{
				capacity = Console.scanInt( "Informe quantas pessoas para a mesa: " );
			}
			catch( InputMismatchException e )
			{
				System.out.println( "- Voce deve informar o numero de pessoas." );
				
				opt = 1;
			}
		}
		while( opt != 0 );
		
		Table t = table.checkAvailableTableByCapacity( capacity );
		TableRequest tr = new TableRequest();
		
		if( t instanceof Table )
		{
			System.out.println( "\nMesa Nro." + t.getNumber() + " disponivel." );
			System.out.println( "- Trocando status da mesa nro." + t.getNumber() + " para ocupado.\n" );
			
			t.setAvailable( 1 );
			
			table.save( t );
			
			opt = 0;
			
			do
			{
				String cpf = Console.scanString( "Informe o CPF do garcom que vai atender esta mesa: " );
				
				Waiter w = waiter.getWaiterByCpf( cpf );
				
				if( w instanceof Waiter )
				{	
					tr.setId( tableRequestRepo.add( t, w ) );
					
					System.out.println( "\nO Garcom " + w.getName() + " esta atendendo esta mesa." );
				}
				else
				{
					System.out.println( "Nao foi encontrado nenhum garcom.\n" );
					opt = Console.scanInt( "1- Tentar novamente\n0- Sair\nInforme a opcao: " );
				}
			}
			while( opt != 0 );
			
			addProduct( t, tr );
		}
		else
		{
			System.out.println( "Nenhuma mesa foi encontrada para a quantidade de pessoas informadas." );
		}
		
		System.out.println( "\n---- Fim da verificacao de mesa para cliente ----" );
	}

	public void addWaiter()
	{
		System.out.println( "\n---- Adicionando garcom para uma mesa ----" );
		
		int id = inputCheckTableNumber( "Informe o numero da mesa: ", "- Voce deve informar o numero da mesa." );
		
		TableRequest tr = tableRequestRepo.findByTableId( id );
		
		if( null != tr )
		{
			Waiter w = waiter.getWaiterById( tr.getWaiterId() );
			
			if( w instanceof Waiter )
			{
				System.out.println( "Esta mesa ja possui um garcom." );
			}
			else
			{
				String cpf = Console.scanString( "Informe o CPF do garcom: " );
				
				Waiter wtr = waiter.getWaiterByCpf( cpf );
				tr.setWaiterId( wtr.getId() );
				
				tableRequestRepo.save( tr );
								
				System.out.println( "Garcom adicionado com sucesso!" );
			}
		}
		else
		{
			System.out.println( "Você ainda não vinculou essa mesa com um cliente." );
			
			checkTableAvailableAndCapacity();
		}
		
		System.out.println( "\n---- Fim da adicao de um garcom para uma mesa ----" );
	}
	
	public void addProductToTable()
	{
		System.out.println( "\n---- Adicionando produtos para uma mesa ----" );
		
		int id = inputCheckTableNumber( "Informe o numero da mesa: ", "- Voce deve informar o numero da mesa." );
		
		TableRequest tr = tableRequestRepo.findByTableId( id );
		
		if( null != tr )
		{
			Table t = table.getTableByNumber( tr.getTableId() );
			
			if( t instanceof Table )
			{
				addProduct( t, tr );
			}
			else
			{
				System.out.println( "\n- Nao foi encontrado a mesa nro." + id );
			}
		}
		else
		{
			System.out.println( "Você ainda não vinculou essa mesa com um cliente." );
			
			checkTableAvailableAndCapacity();
		}
		
		System.out.println( "\n---- Fim da adicao de produtos para uma mesa ----" );
	}
	
	public void listTable()
	{
		System.out.println( "\n---- Listando informacoes da mesa ----" );
		
		int id = inputCheckTableNumber( "Informe o numero da mesa: " , "- Voce deve informar o numero da mesa." );
		
		TableRequest tr = tableRequestRepo.findByTableId( id );
		ArrayList<TableRequestProduct> trp = tableRequestProductRepo.findByTableRequestId( tr.getId() );
		
		if( trp.size() > 0 )
		{
			Table t = table.getTableByNumber( id );
			
			System.out.println( "\n" );
			System.out.println( table.toStringByTable( t ) );
			
			for( TableRequestProduct t_r : trp )
			{
				Product p = product.getProductById( t_r.getProductId() );
				product.addProductToArray( p );
			}
			
			System.out.println( product.toStringArray() );
		}
		
		System.out.println( "\n---- Fim da listagem das informacoes da mesa ----" );
	}
	
	private int inputCheckTableNumber( String scan, String error )
	{
		int opt = 0;
		int number = 0; 

		do
		{
			try
			{
				number = Console.scanInt( scan );
				
				opt = 0;
			}
			catch( InputMismatchException e )
			{
				System.out.println( error );
				
				opt = 1;
			}
		}
		while( opt != 0 );
		
		return number;
	}
	
	private void addProduct( Table t, TableRequest tr )
	{
		System.out.println( "\n---- Adicionando produtos para um pedido ----" );
		
		int opt = 0;
		
		do
		{
			int code = inputCheckTableNumber( "\nInforme o codigo do produto | 0- Sair: ", "- Voce deve informar um numero." );
			
			if( code != 0 )
			{
				Product p = product.getProductByCode( code );
				
				if( p instanceof Product )
				{
					tableRequestProductRepo.add( tr, p );
					
					System.out.println( "- Produto " + p.getName() + " adicionado com sucesso!" );
				}
				else
				{
					System.out.println( "- Produto nao encontrado." );
				}
				
				opt = 1;
			}
			else
			{
				opt = code;
			}
		}
		while( opt != 0 );
		
		System.out.println( "\n---- Fim da adicao de produtos para um pedido ----" );
	}
}