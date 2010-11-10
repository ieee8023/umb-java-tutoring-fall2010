package session2;

public class InfiniteRecursion {

	public static void main(String[] args) {
		
		try{
		printThisAndCallItAgain("test");
		}catch(Throwable t){
			System.out.println(t.getLocalizedMessage());
		}
		

	}

	
	public static void printThisAndCallItAgain(String s){
		
		System.out.println(s);
		InfiniteRecursion.printThisAndCallItAgain(s);
	}
}
