package decoratorPattern2;

public abstract class DisplayDecorator extends Display {
	
	private Display decoratedDisplay;
	
	public DisplayDecorator(Display decoratedDisplay) {
		this.decoratedDisplay = decoratedDisplay;
	}

	@Override
	public void draw() {
		decoratedDisplay.draw();
	}

}

class LaneDecorator extends DisplayDecorator {

	public LaneDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}
	
	@Override
	public void draw() {
		super.draw();
		drawLane();
	}
	
	private void drawLane() {
		System.out.println("\t 차선 표시");
	}
	
}

class TrafficDecorator extends DisplayDecorator {

	public TrafficDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}
	
	@Override
	public void draw() {
		super.draw();
		drawTraffic();
	}
	
	private void drawTraffic() {
		System.out.println("\t 교통량 표시");
	}
	
}
