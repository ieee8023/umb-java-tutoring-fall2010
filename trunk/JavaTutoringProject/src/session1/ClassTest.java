package session1;

/**
 * 
 * @author Joseph Paul Cohen 2010
 *
 */
public class ClassTest {

	public static void main(String[] args) {
		
		ifStringPrint(9);
		
		ifStringPrint("text");
		
	}

	
	public static void ifStringPrint(Object o){

		if (String.class.getCanonicalName().equals(o.getClass().getCanonicalName())){
			System.out.println(o);
		}else{
			System.out.println("Not String! it's a " + o.getClass().getSimpleName());
		}
	}
}
