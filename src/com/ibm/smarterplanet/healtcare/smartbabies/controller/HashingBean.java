package com.ibm.smarterplanet.healtcare.smartbabies.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;

//Kendisine parametre ile gelen değişkeni MD ile hashing işlemine tabii tutar

@Stateless
public class HashingBean {

	public String Hashing(String password) {

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md = messageDigest.digest(password.getBytes());
			BigInteger number = new BigInteger(1, md);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return hashtext;

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}

}
