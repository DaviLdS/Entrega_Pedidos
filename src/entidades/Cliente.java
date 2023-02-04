package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String nome;
	private String email;
	private Date aniversario;
	
	public Cliente() {
	}

	public Cliente(String nome, String email, Date aniversario) {
		this.nome = nome;
		this.email = email;
		this.aniversario = aniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAniversario() {
		return aniversario;
	}

	@Override
	public String toString() {
		return "Cliente: " + nome + " ("+sdf.format(aniversario)+") - "+email;
	}

	

	

	
}