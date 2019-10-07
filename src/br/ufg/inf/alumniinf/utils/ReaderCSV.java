package br.ufg.inf.alumniinf.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader; //Usar como exemplo de dependência no Maven!

public class ReaderCSV {

	private CSVReader reader = null;
	private List<String[]> linhas = null;

	public ReaderCSV(File registroSenhas) {

		// Objeto para leitura de um arquivo CSV
		try {
			reader = new CSVReader(new FileReader(registroSenhas));
		
			// Armazena cada linha do arquivo CSV em uma posição de uma lista de vetores de strings
			// Cada posição é um vetor de strings, com uma posição para cada informação da linha
			linhas = reader.readAll();
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

	public CSVReader getReader() {
		return reader;
		
	}

	public void setReader(CSVReader reader) {
		this.reader = reader;
		
	}

	public List<String[]> getLinhas() {
		return linhas;
		
	}

	public void setLinhas(List<String[]> linhas) {
		this.linhas = linhas;
		
	}
}
