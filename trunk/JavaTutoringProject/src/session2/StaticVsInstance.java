package session2;

public class StaticVsInstance {

	public static void main(String[] args) {
		
		//System.out.println(something());
		//System.out.println(StaticVsInstance.something());
		
		String test = something(something("test"));
		System.out.println("(in main : " + test + ")");

	}
	
	public static String something(String s){
	
		int value = (1+1);
		//System.out.println("  in something: " + value);
		//return value;
		return " (in something: " + value + " " + s + ")";
	}

}
