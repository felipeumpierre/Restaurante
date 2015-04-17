package ui;

import classe.Produtos;
import repositorio.ProdutosRepo;
import util.Console;

public class ProdutosUI 
{	
	public static void menu( ProdutosRepo produtos )
	{
		System.out.println( "-------------\nMenu Produtos\n" );
		System.out.println( "1- Adicionar Produto" );
		System.out.println( "2- Listar Produtos" );
		System.out.println( "0- Voltar" );
		
		int option = Console.scanInt( "\nEscolha uma opção: " );
				
		switch( option )
		{
			case 1: add( produtos ); break;
			case 2: list( produtos ); break;
			case 0: main.menu(); break;
		}
	}
	
	public static void add( ProdutosRepo produtos )
	{
		System.out.println( "-------------\n\tNovo Produto\n" );
		
		int code = Console.scanInt( "Código: " );
		String name = Console.scanString( "Nome: " );
		double price = Console.scanDouble( "Preço: " );
		
		produtos.addProdutos( new Produtos( code, name, price ) );
			
		System.out.println( "\nProduto adicionado com sucesso!" );
		
		menu( produtos );
	}
	
	public static void list( ProdutosRepo produtos )
	{
		System.out.println( "-------------\nListagem de Produtos\n" );
		
		for( int i = 0; i < produtos.size(); i++ )
		{
			Produtos p = produtos.getProduto( i );

			System.out.println( p.toString() );
		}
		
		System.out.println( "\nFim de produtos." );
		
		menu( produtos );
	}
}