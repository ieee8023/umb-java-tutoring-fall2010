package session3;

public class Run2 {

	public static void main(String[] args) {
		
		//Factory s1 = Factory.makeObject();
		//System.out.println(s1.someString);
		
		
		//Factory s2 = new Factory("sdf");
		//System.out.println(s2.someString);
		
		//Singleton s = new Singleton("ASdf");
		
		System.out.println("Starting");
		Singleton s1 = Singleton.getObject();
		Singleton s2 = Singleton.getObject();
		
		

	}

}
