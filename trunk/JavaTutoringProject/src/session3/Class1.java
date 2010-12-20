package session3;

public class Class1 extends AbClass1{

	String s = "something";
	
	public Class1(String s){
		super(s);
		
		this.s = s;
		System.out.println(super.func());
	}
	
	public void somethingFromClass1(){
		System.out.println("somethingFromClass1");
	}
	
	public String func(){
		return "funcClass1";
	}
}
