package session3;

public class Factory {

	public String someString;
	
	private Factory(String privateString){
		this.someString = privateString;
	}
	
	static Factory makeObject(){
		return new Factory("A-String");
	}
	
	
	
	public static void main(String[] args){
		
		Factory s1 = Factory.makeObject();
		System.out.println(s1.someString);
		
		Factory s2 = new Factory("sdf");
		System.out.println(s2.someString);
	}
}
