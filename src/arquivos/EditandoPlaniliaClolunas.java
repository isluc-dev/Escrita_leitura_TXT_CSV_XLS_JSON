package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class EditandoPlaniliaClolunas {
	
	public static void main(String[] args) throws IOException {
	
		File file = new File("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);//preparando a entrada de arquivos xls
		HSSFSheet planilia = hssfWorkbook.getSheetAt(0);//pegando a planilia
		
		Iterator<Row> linhasItaretor = planilia.iterator();
		
		while(linhasItaretor.hasNext()) {
			Row linha = linhasItaretor.next();//dados da pessoa na linha
			 int numeroCelula = linha.getPhysicalNumberOfCells();//quantidade de celula
			 
			 Cell cell = linha.createCell(numeroCelula);//cria nova celula na linha
			 cell.setCellValue("5.487,20");
			
		}
		entrada.close();
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		System.out.println("planilia atualizada");
		
	}

}
