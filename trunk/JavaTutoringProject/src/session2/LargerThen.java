package session2;

import java.io.File;

public class LargerThen {

	public static void main(String[] args) {
		
		int minSizekb = 16000;
		
		File folder = new File("/");
		
		File[] files = folder.listFiles();
		
		for (File f: files){
			if(!f.isDirectory() && f.length()>minSizekb)
				System.out.printf("%12.2fkb %s\n", f.length()/1000.0,f.getName());
		}

	}

}
