package avaliacao2.questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner (System.in);

		Produto produto = new Produto ();

		try(Connection connection = new ConnectionFactory().recuperaConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);


			System.out.println("Bem vindo ao Sistema!");
			System.out.println("Digite a opção desejada:");
			System.out.println("1 - para INSERIR uma nova oferta");
			System.out.println("2 - para ATUALIZAR uma oferta");
			System.out.println("3 - para DELETAR uma oferta");
			System.out.println("4 - para LISTAR itens de acordo com palavra chave");
			System.out.println("5 - para SAIR");

			int entrada = sc.nextInt();
			int i;
			if(entrada == 1) {

				System.out.println("Digite as 3 novas ofertas!");


				for(i=0; i < 3; i++) {

					System.out.println("Digite o nome do produto: ");
					produto.setNome(sc.next());
					System.out.println("Digite a descrição do produto: ");
					produto.setDescricao(sc.next());
					System.out.println("Digite o valor do desconto: ");
					produto.setDesconto(sc.next());
					System.out.println("Digite a data da inserção(padrão aaaa-mm-dd)");
					produto.setDataInicio(sc.next());
					System.out.println(
							"Nome: " + produto.getNome() +
							"\nDescrição: " + produto.getDescricao() +
							"\nDesconto: " + produto.getDesconto() +
							"\nData: " + produto.getDataInicio()
							);
				}

				produtoDao.inserir(produto);


			} else if (entrada == 2) { 
				System.out.println("Digite o ID da oferta que deseja atualizar: ");
				
				
				

			} else if (entrada == 3) {
				System.out.println("Digite o ID do produto que deseja excluir: ");
				produtoDao.deletar(sc.nextInt());


			} else if (entrada == 4) {
				System.out.println("Digite palavra chave para listagem de produtos: ");
				produtoDao.listar();

			} else if (entrada == 5){
				System.out.println("Programa finalizado!");

			}

		}

	}

}
