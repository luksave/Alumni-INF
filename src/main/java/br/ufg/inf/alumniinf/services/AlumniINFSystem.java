package br.ufg.inf.alumniinf.services;

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
    
	public static String generateUsername(String name){

		Random rand = new Random();
		int    num  = rand.nextInt(100);

		String user = name.substring(0,(name.length()-1)) + name.charAt(0) + num;
		
		int index = user.indexOf(' ');
		
		user = name.substring(0,(index-1)) + name.substring((index+1), name.length()-1)+ num;
		
		//System.out.println("Nome de usuário gerado: " +user);
		return user;
		
	}
	
	
	public static String generatePassword(int size){
		if (size < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(size);
        
        for (int i = 0; i < size; i++) {
            int  rndCharAt = random.nextInt(PASSWORD_ALLOW.length());
            char rndChar   = PASSWORD_ALLOW.charAt(rndCharAt);
        
            sb.append(rndChar);

        }

        //System.out.println("Senha gerada: " +sb.toString());
		return sb.toString();	    
        
	}
	
	
	public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        
        return letters.stream().collect(Collectors.joining());
        
    }
	
	
}
