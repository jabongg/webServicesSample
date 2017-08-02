package com.cchi.auth;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class TripleDESUtil {
	
	private static Logger logger = Logger.getLogger(TripleDESUtil.class.toString());
	
	public static String generateKey() throws Exception {
		String text = null;
		String _Company = "Company=CCHI;";
		String _Service = "Service=CCHIService;";
		String _accessToken	="AccessToken=2017.08.02.12.18.15";
		
		text = _Company + _Service + _accessToken;
		
	    String codedtext = new TripleDESUtil()._encrypt(text,"SecretKey");
	    String decodedtext = new TripleDESUtil()._decrypt(codedtext,"SecretKey");
	 	logger.info(codedtext + " ---> " + decodedtext);
	 	return codedtext;

	}


	private String _encrypt(String message, String secretKey) throws Exception {
	
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		
		SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] plainTextBytes = message.getBytes("utf-8");
	    byte[] buf = cipher.doFinal(plainTextBytes);
	    byte [] base64Bytes = Base64.encodeBase64(buf);
	    String base64EncryptedString = new String(base64Bytes);
	    
	    return base64EncryptedString;
	}

	private String _decrypt(String encryptedText, String secretKey) throws Exception {
	
	    byte[] message = Base64.decodeBase64(encryptedText.getBytes("utf-8"));
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		
		Cipher decipher = Cipher.getInstance("DESede");
		decipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] plainText = decipher.doFinal(message);
		
		return new String(plainText, "UTF-8");
	}
	
	
	public static String generateTokenFromHTTPHeaders(String companyName, String serviceName, String accessToken) throws Exception {
		String text = null;
		String _Company = "Company=" + companyName + ";";
		String _Service = "Service=" + serviceName + ";";
		String _accessToken	="AccessToken=" + accessToken;
		
		text = _Company + _Service + _accessToken;
		
	    String codedtext = new TripleDESUtil()._encrypt(text,"SecretKey");
	    String decodedtext = new TripleDESUtil()._decrypt(codedtext,"SecretKey");
	 	logger.info(codedtext + " ---> " + decodedtext);
	 	return codedtext;		
	}
	
}
