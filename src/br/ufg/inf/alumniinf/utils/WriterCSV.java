package br.ufg.inf.alumniinf.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;; //Usar como exemplo de dependência no Maven!

public class WriterCSV {
	private static CSVWriter writer = null;

	public static void Writer(File passwordRecord, String[] record) {

		// Objeto para leitura de um arquivo CSV
		try {
			writer = new CSVWriter(new FileWriter(passwordRecord, true));
		
			// Armazena em uma linha do arquivo CSV o registro de usuário e senha
			writer.writeNext(record);
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public CSVWriter getWriter() {
		return writer;
		
	}

	public void setWriter(CSVWriter writer) {
		WriterCSV.writer = writer;
		
	}
	
}
