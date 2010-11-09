package regex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class RegExTest {

	public static void main(String[] args) {

		//String regEx = "^(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}$";
		//String regEx = "[A-Za-z0-9+_+]+@[A-Za-z0-9].[A-Za-z]+";
		String regEx = "(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\\-+)|([A-Za-z0-9]+\\.+)|([A-Za-z0-9]+\\++))*[A-Za-z0-9]+@((\\w+\\-+)|(\\w+\\.))*\\w{1,63}\\.[a-zA-Z]{2,6}";
		List<String> toSearch = new ArrayList<String>();
		toSearch.add("test@test.com");
		toSearch.add("ding@cs.umb.edu");
		toSearch.add("Email: <a href='mailto:ding@cs.umb.edu'> ding@cs.umb.edu </a>");
		
		Pattern pattern = Pattern.compile(regEx);
		
		for(String s : toSearch){
			
			Matcher matcher = pattern.matcher(s);
			
			while (matcher.find()){
				
				System.out.println("Found match in String <" + s + ">\n" +
						" Start: " + matcher.start() + "\n" + 
						" End: " + matcher.end() + "\n" + 
						" Content: " + matcher.group());
				
			}

		}
		
		
	}

}
