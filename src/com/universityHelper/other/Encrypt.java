package com.universityHelper.other;

public class Encrypt {
	
	//decode the password
	public static String readEncrypt(String text) {
		// String modText="";
		String[] b = text.split(" ");
		String[] blisyt = new String[text.length()];
		String f = "";
		for (int i = 0; i < b.length; i++) {

			blisyt[i] = String.valueOf((char) (Integer.valueOf(b[i]) ^ 17));
			f += String.valueOf(blisyt[i]);
		}
		return f;
	}

	//encode the password
	public static String WriteEncrypt(String text) {
        char[] b = text.toCharArray();
        byte[] blisyt = new byte[text.length()];
        String f = "";
        for (int i = 0; i < b.length; i++) {
            blisyt[i] = (byte) (((byte) b[i]) ^ 17);
            f += String.valueOf(blisyt[i]) + " ";
        }

        return f;
	}
}
