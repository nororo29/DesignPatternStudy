package decoratorPattern2;

public abstract class Display {
	public abstract void draw();
}

class RoadDisplay extends Display {

	@Override
	public void draw() {
		System.out.println("�⺻ ���� ǥ��");
	}
	
}
