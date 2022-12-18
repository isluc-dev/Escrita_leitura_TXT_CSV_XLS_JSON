package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2Leitura {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos\\arquivo_excel.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);// prepara a entrada do arquivo para ler
		
		HSSFSheet planilia = hssfWorkbook.getSheetAt(0);/* pega a primeira planilia */
		
		Iterator<Row> linhaIterator = planilia.iterator();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(linhaIterator.hasNext()) {/*enquanto tiver linha */
			
			Row linha = linhaIterator.next();/*dados da pessoa na linha */
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celulas.hasNext()) {//enquanto tiver celula 
				Cell cell = celulas.next();
				
				switch(cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1 :
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
					
					
				}
				
			}//fim das celulas da linha 
			
			pessoas.add(pessoa);
		}
		entrada.close();//terminou de ler o arquivo
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
			
		}
	}

}
