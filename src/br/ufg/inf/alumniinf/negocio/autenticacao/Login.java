package br.ufg.inf.alumniinf.negocio.autenticacao;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.io.File;

import br.ufg.inf.alumniinf.utils.ReaderCSV;

public class Login {

	static Scanner scanner = new Scanner(System.in);
	static Console console = System.console();
	
	private static File registroCadastro = new File("cadastro/registroCadastros.csv");
	
	public static Boolean realizarLogin(){
		
		ReaderCSV reader = new ReaderCSV(registroCadastro);
		//Lendo da linha 1 até a última linha no csv (quantidade de cadastros)
		List<String[]> listaDadosCadastro = reader.getLinhas().subList(0, Register.quantidadeCadastros);
		
		System.out.print("Usuário: ");
		String user = scanner.nextLine();
		
		System.out.print("Senha: ");
		String pass = scanner.nextLine();

		scanner.close();
		
		int linhaAtual = 0;
		
		for (Iterator<String[]> iterator = listaDadosCadastro.iterator(); iterator.hasNext();) {
			String[] userAtual = reader.getLinhas().get(linhaAtual);
			
			//System.out.print("Registro atual: " +userAtual[0] + " - " +userAtual[1]);
			
			if(userAtual[0].equals(user) && userAtual[1].equals(pass)) return true;
		
			linhaAtual++;
			
		}
		
		
		
		return false;
		
	}
	
}
