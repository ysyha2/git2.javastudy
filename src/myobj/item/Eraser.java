package myobj.item;

public class Eraser extends Item {
	public Eraser() {
		super("지우개", 300);
	}


	@Override
	public void use() {
		System.out.println("지우개를 사용했습니다");
	}

}
