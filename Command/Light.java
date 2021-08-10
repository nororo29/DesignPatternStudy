package desingPattern.command.receiver;

public class Light {
	String place;
	
	public Light(String place) {
		this.place = place;
	}
	
	public void on() {
		System.out.println(place + " Àüµî ºÒ ÄÑÁü");
	}
	public void off() {
		System.out.println(place + " Àüµî ºÒ ²¨Áü");
	}
}
