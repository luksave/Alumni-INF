package tst;

import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Test;

import br.ufg.inf.alumniinf.persistence.model.bean.AlumnusUser;

public class AlumniUserObjectTest {
	
	@Test 
	public void createAndReturnUserName() {
		// Dado
		String  fullName     = "Lucas Felipe"; 
		int     CPF          =  219389384;
		String  email        = "lucasfelipems@gmail.com";
		String  tellphone    = "01290494029";
		int     registration =  1125673447;
		Date    birth 	     = Date.valueOf("1996-01-22");
		
		// Quando 
		AlumnusUser user = new AlumnusUser(fullName, CPF, email, tellphone, "alumnus", registration, birth);
		
		// Então
		assertTrue("ERRO NO NOME DO USER", user.getFullName().equals(fullName));
		
		// Então
		assertEquals("ERRO NO CPF DO USER", user.getCPF(), CPF);
		
		// Então
		assertTrue("ERRO NO EMAIL DO USER", user.getEmail().equals(email));
		
		// Então
		assertTrue("ERRO NO TELEFONE DO USER", user.getTellphone().equals(tellphone));
		
		// Então
		assertEquals("ERRO NA MATRICULA DO USER", user.getRegistration(), registration);
		
		// Então
		assertTrue("ERRO NA DATA DE NASCIMENTO DO USER", user.getBirthDate().equals(birth));
		
	}

}
