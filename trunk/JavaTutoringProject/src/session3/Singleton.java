package session3;

public class Singleton {

	private static Singleton singleObject = new Singleton("A-String");
	public String someString;
	
	private Singleton(String privateString){
		System.out.println("singleton built staticly");
		this.someString = privateString;
	}
	
	static Singleton getObject(){
		System.out.println("getObject called");
		return singleObject;
	}
	
}
