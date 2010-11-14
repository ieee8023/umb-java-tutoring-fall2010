package stdin;

import java.io.IOException;

public class StdInTest {

	public static void main(String args[]) throws IOException{
		
		int buff;
		while ((buff = System.in.read()) != -1)
			System.out.print((char)buff);
	}
}
