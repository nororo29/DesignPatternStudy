package decoratorPattern2;

public class Client {

	public static void main(String[] args) {
		// 기본도로표시
		Display road = new RoadDisplay();
		road.draw();
		
		// 기본도로표시 + 차선표시
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw();
		
		// 기본도로표시 + 교통량표시
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw();
		
		// 기본도로표시 + 차선표시 + 교통량표시
		Display roadWithTrafficLane = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
		roadWithTrafficLane.draw();
	}

}
