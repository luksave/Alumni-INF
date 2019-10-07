package br.ufg.inf.alumniinf.negocio.autenticacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.alumniinf.negocio.sistema.AlumniINFSystem;
import br.ufg.inf.alumniinf.utils.WriterCSV;

public class User {

	private String nomeCompleto;
	private List<String[]> registro = new ArrayList<String[]>();
	private File registroSenhas = new File("cadastro/registroCadastros.csv");
	
	public User(String fullName, int passwordSize) {
		this.nomeCompleto = fullName;
		
		String user  = AlumniINFSystem.generateUsername(fullName);
		String senha = AlumniINFSystem.generatePassword(passwordSize);
		
		String input[] = {user, senha};
		registro.add(input);
		
		WriterCSV.Writer(registroSenhas, registro);
		
	}
	
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	
}
