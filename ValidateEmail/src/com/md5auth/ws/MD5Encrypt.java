package com.md5auth.ws;

import java.security.*;
 import java.math.*;
 
public class MD5Encrypt {
    public static void main(String args[]) throws Exception{
      String s="This is a test";
      MessageDigest m=MessageDigest.getInstance("MD5Encrypt");
       m.update(s.getBytes(),0,s.length());
     System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
    }
 }