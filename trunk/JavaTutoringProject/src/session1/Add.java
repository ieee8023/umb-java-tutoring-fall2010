package session1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Add {

	public static void main(String[] args){
		
		InputStream is;
		try {
			is = new FileInputStream("project.in");
			System.out.println("File opened!");

			int chr;
			int sum = 0;
			//while (more chars){
				//read
			while((chr = is.read()) != -1){
			
				char theChar = (char)chr;
			
				
				
				
				try{
					//if (isdigit){
					int theValue = Integer.parseInt(String.valueOf(theChar));
					//+=
					sum += theValue;
				}catch (NumberFormatException e){
					
					//}elseif( ; || EOF){
					if (theChar == ';'){
						// output
						System.out.println(sum);
						//reset sum
						sum = 0;
						//}
					}
				}
			}
			//}
			
			if (sum != 0)
				System.out.println(sum);
			
			//close stream
			if (is instanceof FileInputStream)
				((FileInputStream)is).getChannel().close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File open failed!");
		} catch (IOException e) {
			System.out.println("Can't read character!");
		}
		
		

		
	}

	
}
