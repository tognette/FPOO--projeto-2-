package br.org.game.view;

import java.util.Scanner;


import br.org.game.dao.CrudDAO;
import br.org.game.model.Game;

public class TelaMain {

	public static void main(String[] args) {
	CrudDAO inserir_game = new CrudDAO();
		
		Scanner entrada = new Scanner(System.in);
		Game game1 = new Game();
	
		System.out.println("Digite o numero de acordo com a acao que deseja realizar!!");
		System.out.println("- 1 - Create");
		System.out.println("- 2 - Update ");
		System.out.println("- 3 - Read");
		System.out.println("- 4 - Delete");
		int escolha = entrada.nextInt();
		
		switch(escolha) {
		case 1 :
		System.out.println("Insira o id do game:");
		game1.setId(entrada.nextInt());
		System.out.println("Insira o nome o game: ");
		game1.setNome(entrada.next());
		System.out.println("Insira o preco do game: ");
		game1.setPreco(entrada.nextFloat());
		System.out.println("Insira a categoria do jogo: ");
		game1.setCategoria(entrada.next());
		inserir_game.create(game1);
		System.out.println("Id: " + game1.getId());
		System.out.println("Nome: " + game1.getNome());
		System.out.println("Preco: " + game1.getPreco());
		System.out.println("Categoria: " + game1.getCategoria());

		break;
		
		case 2 :
			game1.setNome("Fifa 23");
			game1.setPreco(350);
			System.out.println("Insira o id o game a ser mudado: ");
			game1.setId(entrada.nextInt());
			System.out.println("Insira o preco do game a ser mudado: ");
			game1.setPreco(entrada.nextFloat());
			game1.setCategoria(entrada.next());
		inserir_game.update(game1);
		System.out.println("Nome: " + game1.getNome());
		System.out.println("Preco: " + game1.getPreco());
		break;
		
		case 3 :
		System.out.println("lendo lista...");
		for(Game olho : inserir_game.read()) {
			System.out.println("Dados do game: "+ olho.getId() + olho.getCategoria()+ " " + olho.getNome() + " " + olho.getPreco());
		}
		break;
		
		case 4 :
		CrudDAO remover_game = new CrudDAO();
		System.out.println("insira o numero do game a ser excluio: ");
		remover_game.delete(entrada.nextInt());
		System.out.println("Game removido com sucesso!");
		break;
		}

	}

}
