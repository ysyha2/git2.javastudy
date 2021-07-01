package myobj.item;

public class Pencil extends Item {
	public Pencil() {
		super("연필", 1000);
	}


	@Override
	public void use() {
		System.out.println("연필을 사용했습니다");
		
	}

}
