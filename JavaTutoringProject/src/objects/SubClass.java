package objects;

public class SubClass extends SuperClass{

	int ret = getter();
	int printer = print();
	
	public int print(){
		
		
		return 1;
	}
	
	public SubClass(){
		
		
	}
	public SubClass(int ret){
		
		this.ret = ret;
		System.out.println("cont");
	}
	
	final int getret(){
	
		
		return ret;
	}
	
	public static void main(String[] args){
		
		
		SubClass c = new SubClass(5);
		
		System.out.println(c.getret());
		
		SubClass c2 = new SubClass(7);
		
		System.out.println(c2.getret());
		
		
		
		try {
			SubClass s = (SubClass)Class.forName("SubClass").newInstance();
			System.out.println(s.getClass().getSuperclass().getDeclaredFields()[0]);
		} catch (InstantiationException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}


