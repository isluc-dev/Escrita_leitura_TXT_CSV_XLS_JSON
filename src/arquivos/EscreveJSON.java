package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON {
	public static void main(String[] args) throws IOException {
		
		 Usuario usuario1 = new Usuario();
		 usuario1.setLoin("joão");
		 usuario1.setSenha("123");
		 usuario1.setNome("isis Emanuelly");
		 usuario1.setCpf("012.451.541-87");
		 
		 Usuario usuario2 = new Usuario();
		 usuario2.setLoin("lucas");
		 usuario2.setSenha("321");
		 usuario2.setNome("Lucas Emanuel");
		 usuario2.setCpf("068.384.114-88");
		 
		 List<Usuario> usuarios = new ArrayList<Usuario>();
		 usuarios.add(usuario1);
		 usuarios.add(usuario2);
		 
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 String jsonUser = gson.toJson(usuarios);
		 System.out.println(jsonUser);
		 
		 //escrever no arquivo
		 
		 FileWriter fileWriter = new FileWriter("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos\\filejson.json");
		 fileWriter.write(jsonUser);
		 fileWriter.flush();
		 fileWriter.close();
		 
		 
		 //##########################LENDO ARQUIVO GSON =====================================
		 
		 FileReader fileReader = new FileReader("C:\\Users\\lucas\\eclipse-workspace\\Arquivos\\src\\arquivos\\filejson.json");
		 
		   JsonArray jsonArray =  (JsonArray) JsonParser.parseReader(fileReader);
		   List<Usuario> liusuarios = new ArrayList<Usuario>();
		   
		   //cada jsonArray e um jsonEelement
		   for (JsonElement jsonElement : jsonArray) {
			   Usuario usuario = new  Gson().fromJson(jsonElement, Usuario.class);
			   liusuarios.add(usuario);
			
		}
		   System.out.println("leitura do araquivo json " + liusuarios);
	}

}
