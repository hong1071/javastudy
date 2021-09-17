package prob03;

public class Map {

	public static void main(String[] args) {
		
		Marine m1 = new Marine();
		m1.move(2, 2);
		m1.stop();
		m1.stimPack();
		
		Tank t1 = (Tank) new Unit();
		t1.move(0, 0);
		t1.stop();
		t1.changeMode();
	}

}
