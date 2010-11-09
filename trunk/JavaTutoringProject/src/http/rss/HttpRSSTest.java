package http.rss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class HttpRSSTest {

	public static void main(String[] args) throws IOException {

		//String urlstr = "http://google.com";
		//String urlstr = "http://shop.ebay.com/i.html?rt=nc&_nkw=computers&_rss=1";
		//String urlstr = "http://feeds.bbci.co.uk/news/rss.xml?edition=int";
		String urlstr = "http://rss.weather.com/weather/rss/local/USMA0046?cm_ven=LWO&cm_cat=rss&par=LWO_rss";
		
		URL url = new URL(urlstr);
		URLConnection conn = url.openConnection();
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		StringBuilder feed = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null)
			feed.append(line);
		
		//System.out.println(feed);
		
		RssConverter rssc = new RssConverter();
		
		Rss rss = rssc.fromXml(feed.toString());
		
		for(Item i: rss.channel.items){
			System.out.println(i.title);
			System.out.println("  " + i.description);
		}
	}
}
