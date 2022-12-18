package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setNome("isis Emanuelly");
		pessoa1.setIdade(23);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setNome("Lucas Emanuel");
		pessoa2.setIdade(17);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setNome("Levy Luicca");
		pessoa3.setIdade(15);
		
		// essa lista pode vir de um banco de dados ou de qualquer fonte de dados
		List<Pessoa> pssoas = new ArrayList<Pessoa>();
		pssoas.add(pessoa1);
		pssoas.add(pessoa2);
		pssoas.add(pessoa3);
		
		
		
		File arquivo = new File("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		
		/*escrever_no_arquivo.write("meu texto do arquivo");
		escrever_no_arquivo.write("\n");
		escrever_no_arquivo.write("Isis Emanuelly e Lucas Emanuel");*/
		
		/*for(int i = 0; i <= 10; i++) {
			escrever_no_arquivo.write(" Meu primeiro arquivo de "+i+ "\n");
		}*/
		
		
		for (Pessoa pessoa : pssoas) {
			
			escrever_no_arquivo.write(pessoa.getNome()+ ";" + pessoa.getEmail()+ ";" + pessoa.getIdade()+ "\n");
			
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
