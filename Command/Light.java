package desingPattern.command.receiver;

public class Light {
	String place;
	
	public Light(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place + " ���� �� ����");
	}
	public void off() {
		System.out.println(place + " ���� �� ����");
	}
}
