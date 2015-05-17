package ui;

import java.util.InputMismatchException;

import entity.Product;
import repo.ProductRepo;
import util.Console;

public class ProductUI 
{
	private ProductRepo product = new ProductRepo();
	
	public ProductUI( ProductRepo p )
	{
		this.product = p;
	}
	
	public void run()
	{
		int opt = 0;
		
		do
		{
			System.out.println( "\n+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "Menu Produto" ) );
			System.out.println( "+--------------------------+" );
			System.out.println( String.format( "| %-24s |", "1- Adicionar produto" ) );
			System.out.println( String.format( "| %-24s |", "2- Listar produtos" ) );
			System.out.println( String.format( "| %-24s |", "0- Voltar" ) );
			System.out.println( "+--------------------------+" );
			
			opt = Console.scanInt( "Escolha uma opcao: " );
			
			switch( opt )
			{
				case 1: addProduct(); break;
				case 2: listProduct(); break;
				default: System.out.println( "\n- Opcao invalida!" ); break;
			}
		}
		while( opt != 0 );
	}
	
	private void addProduct()
	{
		System.out.println( "\n--- Adicionando novo produto ---\n" );
		
		int opt = 0;
		int code = 0;
		double price = 0;
		
		do
		{
			try
			{
				code = Console.scanInt( "Código: " );

				opt = 0;
			}
			catch( InputMismatchException e )
			{
				System.out.println( "- Você deve informar um número." );
				
				opt = 1;
			}
		}
		while( opt != 0 );
		
		String name = Console.scanString( "Nome: " );
		
		opt = 0;
		
		do
		{
			try
			{
				price = Console.scanDouble( "Preço: " );
				
				opt = 0;
			}
			catch( InputMismatchException e )
			{
				System.out.println( "- Você deve informar um valor monetário." );
				
				opt = 1;
			}
		}
		while( opt != 0 );	
		
		this.product.addProduct( new Product( code, name, price ) );
		System.out.println( "\nGarçom adicionado com sucesso!" );
		
		System.out.println( "\n--- Fim de cadastro de produto ---" );
	}
	
	public void listProduct()
	{
		System.out.println( "\n--- Listar produtos ---\n" );	
		System.out.println( this.product.toString() );		
		System.out.println( "--- Fim da listagem de produtos ---" );
	}
}
