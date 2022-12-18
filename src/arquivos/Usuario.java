package arquivos;

import java.io.Serializable;

public class Usuario  implements Serializable{
	
 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loin;
	private String senha;
	private String nome;
	private String cpf;
	
	@Override
	public String toString() {
		return "Usuario [loin=" + loin + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLoin() {
		return loin;
	}
	public void setLoin(String loin) {
		this.loin = loin;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	

}
