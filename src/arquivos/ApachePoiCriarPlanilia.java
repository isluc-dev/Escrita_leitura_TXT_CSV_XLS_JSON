package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiCriarPlanilia {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos\\arquivo_excel.xls");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
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
		
		Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setNome("Maria do Socorro de Sousa");
		pessoa4.setIdade(44);
		
		// essa lista pode vir de um banco de dados ou de qualquer fonte de dados
		List<Pessoa> pssoas = new ArrayList<Pessoa>();
		pssoas.add(pessoa1);
		pssoas.add(pessoa2);
		pssoas.add(pessoa3);
		pssoas.add(pessoa4);
		
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();//usado para escrever a planilia
		
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("planilia de pessoas jdev treinamento");// creia planilia
		
		int numeroLinha = 0;
		for (Pessoa p : pssoas) {
			
			Row linha = linhaPessoa.createRow(numeroLinha++);// ROW E LINHA : crinado a linha na planilia
			
			int celula = 0;
				Cell cellNome = linha.createCell(celula++);// CELL E CELULA : criando celula 1
				cellNome.setCellValue(p.getNome());
				
				Cell cellEmail = linha.createCell(celula++);// CELL E CELULA : criando celula 2
				cellEmail.setCellValue(p.getEmail());
				
				
				Cell cellIdade = linha.createCell(celula++);// CELL E CELULA : criando celula 3
				cellIdade.setCellValue(p.getIdade());
			
			
			
		}//terminlou de fazer a planilia
		
		FileOutputStream saida = new FileOutputStream(file);
		
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("planilia foi criada");
		
		
		
	}

}
