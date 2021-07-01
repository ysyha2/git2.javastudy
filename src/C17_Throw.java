import java.util.InputMismatchException;

public class C17_Throw {
	
	/*
		# throw
		
		 - 원하는 예외를 발생시킨다
		 
		# throws
		 
		 - 해당 메서드에서 발생하는 예외를 명시한다
		 - 해당 메서드를 호출한 곳으로 예외처리를 미룬다
		 // 예외처리를 나를 호출한곳으로 던질래(미룬다)
		 
		# Exception 클래스
		
		 - Exception 클래스를 상속받아 예외를 정의할 수 있다
		 - Exception 클래스를 상속받은 예외는 반드시 처리해야하는 예외가 된다
		 - 반드시 예외처리가 되어 있어야 컴파일을 허용해준다
		 
		# RuntimeException 클래스
		
		 - RuntimeException 클래스를 상속받은 예외는 반드시 처리하지 않아도 되는 예외가 된다
		 - 예외처리를 하지 않아도 컴파일 에러는 발생하지 않는다
	 */
	
	public static void main(String[] args) {
		test2();
		
		try 
		{
			test();
		}
		catch(NotAnimalException e) 
		{
			e.printStackTrace();
			System.out.println("호랑나비는 동물이 아닙니다");
		}
	}
	
	public static void test() throws NotAnimalException {
		String name = "호랑나비";
		
		if (name.equals("호랑이")) 
		{
			System.out.println("동물");
		}
		else if(name.equals("호랑나비"))
		{
			throw new NotAnimalException();
			//throw new InputMismatchException(); 
			// 이건 런타임익셉션이라 빨간줄안뜸
		}
	}
	public static void test2() {
		int a = 10;
		if(a % 2 ==0)
		{
			System.out.println("짝수");
		}
		else
		{
			throw new NotEvenException();
		}
	}

}

class NotAnimalException extends Exception{
	public NotAnimalException() {
		super("동물이 아닙니다.");
	}
}

class NotEvenException extends RuntimeException{
	public NotEvenException() {
		super("짝수가 아닙니다");
	}
}
