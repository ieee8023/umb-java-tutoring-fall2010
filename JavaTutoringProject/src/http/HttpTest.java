package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpTest {

	public static void main(String[] args) throws IOException {

		String urlstr = "http://google.com";

		URL url = new URL(urlstr);
		URLConnection conn = url.openConnection();
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String line;
		while ((line = rd.readLine()) != null){
			
			System.out.println(line);
			
		}
	}
}
