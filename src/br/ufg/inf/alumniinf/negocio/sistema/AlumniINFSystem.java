package br.ufg.inf.alumniinf.negocio.sistema;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AlumniINFSystem {

	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final String PASSWORD_ALLOW_BASE_SHUFFLE = shuffleString(PASSWORD_ALLOW_BASE);
    private static final String PASSWORD_ALLOW = PASSWORD_ALLOW_BASE_SHUFFLE;
	
    private static SecureRandom random = new SecureRandom();
    
	public static String generateUsername(String nome){

		Random rand = new Random();
		int    num  = rand.nextInt(100);

		String usuario = nome.substring(0,(nome.length()-1)) + nome.charAt(0) + num;
		
		System.out.println("Nome de usuário gerado: " +usuario);
		return usuario;
		
	}
	
	
	public static String generatePassword(int tamanho){
		if (tamanho < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            int  rndCharAt = random.nextInt(PASSWORD_ALLOW.length());
            char rndChar   = PASSWORD_ALLOW.charAt(rndCharAt);
            sb.append(rndChar);

        }

        System.out.println("Senha gerada: " +sb.toString());
		return sb.toString();	    
        
	}
	
	
	public static String shuffleString(String string) {
        List<String> letras = Arrays.asList(string.split(""));
        Collections.shuffle(letras);
        
        return letras.stream().collect(Collectors.joining());
        
    }
	
	
}
