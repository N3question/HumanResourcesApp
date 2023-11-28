package model.hash;

import java.security.NoSuchAlgorithmException;

import model.utils.HashGenerator;

public class Hash {
	public static String hashingPassword(String password) {
		String hashedPassword = "";
		try {
			// passwordをハッシュ化
			hashedPassword = HashGenerator.generateHash(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashedPassword;
	}
}
