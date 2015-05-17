package ui;

import java.util.InputMismatchException;

import entity.Product;
import entity.Table;
import entity.Waiter;
import repo.*;
import util.Console;

public class RestaurantUI
{
	private TableRepo table = new TableRepo();
	private WaiterRepo waiter = new WaiterRepo();
	private ProductRepo product = new ProductRepo();
	
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
			System.out.println( String.format( "| %-35s |", "2- Adicionar garçom para mesa" ) );
			System.out.println( String.format( "| %-35s |", "3- Adicionar produtos para mesa." ) );
			System.out.println( String.format( "| %-35s |", "4- Listar informações da mesa." ) );
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
				System.out.println( "- Você deve informar o número de pessoas." );
				
				opt = 1;
			}
		}
		while( opt != 0 );
		
		Table t = table.checkAvailableTableByCapacity( capacity );
		
		if( t instanceof Table )
		{
			System.out.println( "Mesa Nro." + t.getNumber() + " disponível." );
			System.out.println( "- Trocando status da mesa nro." + t.getNumber() + " para ocupado.\n" );
			
			t.setAvailable( false );
			
			opt = 0;
			
			do
			{
				String cpf = Console.scanString( "Informe o CPF do garçom que vai atender esta mesa: " );
				
				Waiter w = waiter.getWaiterByCpf( cpf );
				
				if( w instanceof Waiter )
				{	
					t.getRequest().addWaiter( w );
					
					System.out.println( "O Garçom " + w.getName() + " está atendendo esta mesa.\n" );
				}
				else
				{
					System.out.println( "Não foi encontrado nenhum garçom." );
					opt = Console.scanInt( "1- Tentar novamente\n0- Sair\nInforme a opcao: " );
				}
			}
			while( opt != 0 );
			
			addProduct( t );
			
			System.out.println( t.toString() );
			System.out.println( t.getRequest().toString() );
		}
		else
		{
			System.out.println( "Nenhuma mesa foi encontrada para a quantidade de pessoas informadas." );
		}
		
		System.out.println( "\n---- Fim da verificação de mesa para cliente ----" );
	}

	public void addWaiter()
	{
		System.out.println( "\n---- Adicionando garçom para uma mesa ----" );
		
		int number = inputCheckTableNumber( "Informe o número da mesa: ", "- Você deve informar o número da mesa." );
		
		Table t = table.getTableByNumber( number );
		
		if( t instanceof Table )
		{
			if( t.getRequest().getWaiter() instanceof Waiter )
			{
				System.out.println( "Esta mesa já possui um garçom." );
			}
			else
			{
				String cpf = Console.scanString( "Informe o CPF do garçom: " );
				
				Waiter w = waiter.getWaiterByCpf( cpf );
				
				t.getRequest().addWaiter( w );
				
				System.out.println( "Garçom adicionado com sucesso!" );
			}
		}
		
		System.out.println( "\n---- Fim da adição de um garçom para uma mesa ----" );
	}
	
	public void addProductToTable()
	{
		System.out.println( "\n---- Adicionando produtos para uma mesa ----" );
		
		int number = inputCheckTableNumber( "Informe o número da mesa: ", "- Você deve informar o número da mesa." );
		
		Table t = table.getTableByNumber( number );
		
		if( t instanceof Table )
		{
			addProduct( t );
		}
		else
		{
			System.out.println( "\n- Não foi encontrado a mesa nro." + number );
		}
		
		System.out.println( "\n---- Fim da adição de produtos para uma mesa ----" );
	}
	
	public void listTable()
	{
		System.out.println( "\n---- Listando informações da mesa ----" );
		
		int number = inputCheckTableNumber( "Informe o número da mesa: " , "- Você deve informar o número da mesa." );
		
		Table t = table.getTableByNumber( number );
		
		if( t instanceof Table )
		{
			System.out.println( table.toStringByTable( t ) );
			System.out.println( t.getRequest().toString() );
		}
		
		System.out.println( "\n---- Fim da listagem das informações da mesa ----" );
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
	
	private void addProduct( Table t )
	{
		System.out.println( "\n---- Adicionando produtos para um pedido ----" );
		
		int opt = 0;
		
		do
		{
			int code = inputCheckTableNumber( "\nInforme o código do produto | 0- Sair: ", "- Você deve informar um número." );
			
			if( code != 0 )
			{
				Product p = product.getProductByCode( code );
				
				if( p instanceof Product )
				{
					t.getRequest().addProduct( p );
					
					System.out.println( "- Produto " + p.getName() + " adicionado com sucesso!" );
				}
				else
				{
					System.out.println( "- Produto não encontrado." );
				}
				
				opt = 1;
			}
			else
			{
				opt = code;
			}
		}
		while( opt != 0 );
		
		System.out.println( "\n---- Fim da adição de produtos para um pedido ----" );
	}
}