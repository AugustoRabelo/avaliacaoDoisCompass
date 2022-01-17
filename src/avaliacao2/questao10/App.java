package avaliacao2.questao10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import avaliacao2.questao10.ConnectionFactory;
import avaliacao2.questao10.Emoticon;
import avaliacao2.questao10.EmoticonDAO;

import java.util.regex.Matcher;

public class App {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperaConexao()) {
			EmoticonDAO emoticonDao = new EmoticonDAO(connection);

			Emoticon emoticon = new Emoticon();
			Scanner sc = new Scanner(System.in);

			String inputUsuario = sc.next();
			int contCarinhaFeliz = 0;
			int contCarinhaTriste = 0;

			if (inputUsuario.contains(":-)")) {

				Matcher matcher = Pattern.compile("[:]+[-]+[)]").matcher(inputUsuario);
				while (matcher.find()) {
					contCarinhaFeliz++;
					System.out.println(matcher.group());
				}
				System.out.println(contCarinhaFeliz);
			} else if (inputUsuario.contains(":-("))
				;

			Matcher matcher = Pattern.compile("[:]+[-]+[(]").matcher(inputUsuario);
			while (matcher.find()) {
				contCarinhaTriste++;
				System.out.println(matcher.group());
			}
			System.out.println(contCarinhaTriste);

			if (contCarinhaFeliz == contCarinhaTriste) {
				emoticon.setSentimento("neutro");
				System.out.println("neutro");
			} else if (contCarinhaFeliz > contCarinhaTriste) {
				emoticon.setSentimento("divertido");
				System.out.println("divertido");
			} else {
				emoticon.setSentimento("chateado");
				System.out.println("chateado");
			}
			emoticonDao.inserir(emoticon);
		}
	}
}