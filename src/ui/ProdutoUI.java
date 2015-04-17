package ui;

import util.Console;

public class ProdutoUI 
{
	public static void main( String[] args ) 
	{
		
	}
	
	public void run()
	{
		System.out.println( "\nMenu de produtos\n" );
		System.out.println( "Escolha uma opção:\n" );
		System.out.println( "1- Adicionar novo produto\n" );
		System.out.println( "2- Listar produtos cadastrados\n" );
		
		int option = Console.scanInt( "Digite a opção desejada: " );
	}
	
	public void addProduct()
	{
		System.out.println( "\nAdicionando produto\n" );
		
	}
}