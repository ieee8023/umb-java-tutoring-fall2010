package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class HttpTest {

	public static void main(String[] args) throws IOException {

		String urlstr = "http://google.com";
		//String urlstr = "http://www.umb.edu/pictures/02.jpg";

		URL url = new URL(urlstr);
		URLConnection conn = url.openConnection();
		System.out.println("Content Type: " + conn.getContentType());
		InputStream in = conn.getInputStream();
		 
		//System.out.println(((char)in.read()));
		
		
		StringBuffer sb = new StringBuffer();
		int thischar;

		while (((thischar = in.read()) != -1)){
			sb.append((char)thischar);
		}
		
		
		System.out.println(sb.toString());
		
		//BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		//String line;
		//while ((line = rd.readLine()) != null){
			
		//	System.out.println(line);
			
		//}
	}
}
