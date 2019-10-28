package br.ufg.inf.alumniinf.client.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import br.ufg.inf.alumniinf.services.RegisterAlumnusUser;
import br.ufg.inf.alumniinf.services.RegisterExternalUser;


public class Register {

	public static int registerQuantity = 0;
	
	public static void main(int type) {
		
		if(type == 1){
			System.out.println("Registro de ex-aluno");
			
			String  	     fullName     = "Lucas Felipe"; 
			int    			 CPF          =  219389384;
			String 			 email        = "lucasfelipems@gmail.com";
			String 		     tellphone    = "01290494029";
			int              registration =  1125673447;
			SimpleDateFormat format 	  = new SimpleDateFormat("dd/MM/yyyy");
			Date 			 birth 		  = null;
			try {
				birth = format.parse("22/10/1996");

			}catch (ParseException e) {
				System.out.println("Erro na atribuição de data" +e);
			
			}
			
			RegisterAlumnusUser.main(fullName, CPF, email, tellphone, registration, birth);
			
			registerQuantity++;

		}else if(type == 2){
			System.out.println("Registro de usuário externo");
			
			String fullName  = "Lucas Felipe"; 
			String razaoSoc  = "Luksave C.O";
			int    CPF       =  219389384;
			int    CNPJ      =  910291142;
			String email     = "lucasfelipems@gmail.com";
			String tellphone = "01290494029";
			
			RegisterExternalUser.main(fullName, razaoSoc, CPF, CNPJ, email, tellphone);
			
			registerQuantity++;
			
		}
		
	}
	
}
