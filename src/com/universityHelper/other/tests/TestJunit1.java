package com.universityHelper.other.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.universityHelper.other.Encrypt;
import com.universityHelper.other.SendEmail;

public class TestJunit1 {
	@Test
	public void MatchPassword() {
		String password = "This is the password for encrypt using algorithm";
		String encodedPass = Encrypt.WriteEncrypt(password);
		String decodedPass = Encrypt.readEncrypt(encodedPass);
		assertEquals(password, decodedPass);
		
	}
	
	@Test
	public void sendMailCheck() {
		boolean sent=SendEmail.sendMailTO("mhsandamal1@gmail.com", "HEshan");
		assertTrue("Mail sent successfuly", sent);
		
	}
	
	
}
