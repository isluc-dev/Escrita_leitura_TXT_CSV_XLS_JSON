package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerAquivoTxt {
	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaArquivos = new FileInputStream(
				new File("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos.txt"));

		Scanner lerArquivo = new Scanner(entradaArquivos, "UTF-8");
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();

			// deletanto a linha em branco
			if (linha != null & !linha.isEmpty()) {
				String[] dados = linha.split("\\;");
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
				pessoas.add(pessoa);
			
				 
				
			}

		}
		for (Pessoa pessoa : pessoas) {//poderia grava no bando de dados ou gera boleto etc..
			System.out.println(pessoa);
			
		}
		
	}

}
