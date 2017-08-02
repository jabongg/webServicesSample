package com.md5auth.ws;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import sun.misc.BASE64Encoder;

/**
 * This example demonstrates how to get access a web resource
 * protected using BASIC HTTP Authentication. The URL connection
 * needs to set the username and password into the Authorization
 * request header of the URL.  The username and password needs
 * to be encoded using BASE64.
 */
public class RequestAuthorizationHeaders {
  public static void main( String[] args ) throws Exception {

    // theencoder is a web resource protected using BASIC HTTP Authentication
    final String urlString = "http://www.google.com";
    final String company = "CCHI";
    final String service = "CCHIService";
    final String encryptedAccesstoken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9";

    // open url connection
    URL url = new URL( urlString );
    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    // set up url connection to get retrieve information back
    con.setRequestMethod( "GET" );
    con.setDoInput( true );

    // stuff the Authorization request header
    byte[] encodedPassword = ( company + ":" + service + ":" + encryptedAccesstoken).getBytes();
    BASE64Encoder encoder = new BASE64Encoder();
    con.setRequestProperty( "Authorization",
                            "Basic " + encoder.encode( encodedPassword ) );

    // pull the information back from the URL
    InputStream is = con.getInputStream();
    StringBuffer buf = new StringBuffer();
    int c;
    while( ( c = is.read() ) != -1 ) {
      buf.append( (char) c );
    }
    con.disconnect();

    // output the information
    System.out.println( buf );
  }
}