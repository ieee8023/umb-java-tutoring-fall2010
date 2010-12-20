package session3;

public abstract class AbClass1 {

	public AbClass1(){
		System.out.println("no args");
	}
	
	/**
	 * Javadoc is <code>awesome</code>
	 * @param arg Is the string that you pass
	 */

	public AbClass1(String arg){
		System.out.println("1 args: " + arg);
	}
	
	public String toString(){
		return "AbClass1";
	}
	
	public String func(){
		return "func";
	}
}
