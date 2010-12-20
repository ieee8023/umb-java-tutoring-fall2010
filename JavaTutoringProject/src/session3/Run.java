package session3;

public class Run {

	public static void main(String[] args){
		
		SomeClass s1 = new SomeClass();
		System.out.println(s1.i);
		s1.addOne();
		System.out.println(s1.i);
		
		
		
		SomeClass.starti  = 6;
		
		SomeClass s2 = new SomeClass();
		System.out.println(s2.i);
		
	}
}
